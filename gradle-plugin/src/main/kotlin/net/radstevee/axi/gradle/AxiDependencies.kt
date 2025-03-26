package net.radstevee.axi.gradle

import com.google.devtools.ksp.gradle.KspGradleSubplugin
import io.papermc.paperweight.userdev.PaperweightUser
import io.papermc.paperweight.userdev.PaperweightUserDependenciesExtension
import net.radstevee.axi.gradle.AxiDependencies.Coordinates.PAPER_API
import net.radstevee.axi.gradle.AxiDependencies.Coordinates.axi
import net.radstevee.axi.gradle.ext.AxiExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.add
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.the

public object AxiDependencies {
  public object Coordinates {
    public const val PAPER_API: String = "io.papermc.paper:paper-api"

    public fun axi(module: String): String = "net.radstevee.axi:axi-$module"
  }

  public fun applyTo(project: Project, axi: AxiExtension) {
    applyPaper(project, axi)
    applyAxi(project, axi)
    applyKsp(project, axi)
  }

  private fun applyPaper(project: Project, axi: AxiExtension) {
    val version = axi.versions.minecraft.getOrElse(AxiVersions.MINECRAFT) + "-R0.1-SNAPSHOT"

    if (axi.paper.internals.getOrElse(false)) {
      project.plugins.apply(PaperweightUser::class.java)

      val devBundleCoordinates = axi.paper.devBundleCoordinates.orNull

      if (devBundleCoordinates == null) {
        // Default dev bundle
        val paperweight = project.dependencies.the<PaperweightUserDependenciesExtension>()
        paperweight.paperDevBundle(version)
      } else {
        // Fork dev bundle
        val dependency = project.dependencies.create("$devBundleCoordinates:$version")
        project.dependencies.add("paperweightDevelopmentBundle", dependency)
      }
    } else {
      project.dependencies.add("compileOnly", "${axi.paper.apiCoordinates.getOrElse(PAPER_API)}:$version")
    }
  }

  private fun applyAxi(project: Project, axi: AxiExtension) {
    val version = axi.versions.axi.getOrElse(AxiVersions.AXI)

    fun add(dependencyNotation: Any) {
      project.dependencies.add("axiRuntime", dependencyNotation)
      project.dependencies.add("implementation", dependencyNotation)
    }

    axi.moduleDeps.forEach { mod ->
      add("${axi(mod)}:$version")
    }
  }

  private fun applyKsp(project: Project, axi: AxiExtension) {
    project.plugins.apply(KspGradleSubplugin::class.java)
    val axiVersion = axi.versions.axi.getOrElse(AxiVersions.AXI)
    project.dependencies.add("ksp", "${axi("ksp")}:$axiVersion")
  }
}
