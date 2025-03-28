package net.radstevee.axi.gradle

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget

public class AxiSubplugin : KotlinCompilerPluginSupportPlugin {
  override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
    AxiApplicator.applyTo(kotlinCompilation)

    // We do not want any CLI options
    return kotlinCompilation.project.provider(::emptyList)
  }

  override fun getCompilerPluginId(): String {
    return "axi"
  }

  override fun getPluginArtifact(): SubpluginArtifact {
    return SubpluginArtifact("net.radstevee.axi", "gradle-plugin", javaClass.`package`.implementationVersion)
  }

  override fun apply(target: Project) {
    AxiApplicator.applyTo(target)
  }

  // Only apply to JVM compilations which have a main source set
  override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean {
    return kotlinCompilation.allKotlinSourceSets.any { set -> set.name == "main" }
      && kotlinCompilation.target is KotlinJvmTarget
  }
}
