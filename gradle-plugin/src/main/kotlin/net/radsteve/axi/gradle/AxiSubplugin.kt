package net.radsteve.axi.gradle

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

public class AxiSubplugin : KotlinCompilerPluginSupportPlugin {
  override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
    AxiApplicator.applyTo(kotlinCompilation)

    // We do not want any CLI options
    return kotlinCompilation.project.provider(::emptyList)
  }

  override fun getCompilerPluginId(): String {
    return "net.radsteve.axi"
  }

  override fun getPluginArtifact(): SubpluginArtifact {
    return SubpluginArtifact("net.radsteve.axi", "gradle-plugin", javaClass.`package`.implementationVersion)
  }

  override fun apply(target: Project) {
    AxiApplicator.applyTo(target)
  }

  // Only apply to JVM compilations
  override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean {
    return kotlinCompilation.target.platformType == KotlinPlatformType.jvm
  }
}
