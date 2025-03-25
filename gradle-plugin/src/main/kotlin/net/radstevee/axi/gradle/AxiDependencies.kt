package net.radstevee.axi.gradle

import com.google.devtools.ksp.gradle.KspGradleSubplugin
import io.papermc.paperweight.userdev.PaperweightUser
import io.papermc.paperweight.userdev.PaperweightUserDependenciesExtension
import net.radstevee.axi.gradle.AxiDependencies.Dependencies.PAPER_API
import net.radstevee.axi.gradle.AxiDependencies.Dependencies.axi
import net.radstevee.axi.gradle.AxiDependencies.Versions.AXI
import net.radstevee.axi.gradle.ext.AxiExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

public object AxiDependencies {
  private object Versions {
    const val MINECRAFT: String = "1.21.4"
    const val AXI: String = "0.0.0-SNAPSHOT"
  }

  private object Dependencies {
    const val PAPER_API: String = "io.papermc.paper:paper-api"

    fun axi(module: String): String = "net.radstevee.axi:axi-$module"
  }

  public fun applyTo(project: Project, axi: AxiExtension) {
    applyPaper(project, axi)
    applyAxi(project, axi)
    applyKsp(project, axi)
  }

  private fun applyPaper(project: Project, axi: AxiExtension) {
    val version = axi.versions.minecraft.getOrElse(Versions.MINECRAFT) + "-R0.1-SNAPSHOT"

    if (axi.paper.internals.getOrElse(false)) {
      project.plugins.apply(PaperweightUser::class.java)
      val pw = project.dependencies.the<PaperweightUserDependenciesExtension>()
      pw.paperDevBundle(version)
    } else {
      project.dependencies.add("compileOnly", "$PAPER_API:$version")
    }
  }

  private fun applyAxi(project: Project, axi: AxiExtension) {
    val version = axi.versions.axi.getOrElse(AXI)

    fun add(dependencyNotation: Any) {
      project.dependencies.add("axiRuntime", dependencyNotation)
      project.dependencies.add("implementation", dependencyNotation)
    }

    if (axi.moduleDeps.isEmpty()) {
      axi.modules("core")
    }

    axi.moduleDeps.forEach { mod ->
      add("${axi(mod)}:$version")
    }
  }

  private fun applyKsp(project: Project, axi: AxiExtension) {
    project.plugins.apply(KspGradleSubplugin::class.java)

    val axiVersion = axi.versions.axi.getOrElse(AXI)
    project.dependencies.add("ksp", "${axi("ksp")}:$axiVersion")
  }
}
