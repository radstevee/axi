package net.radsteve.axi.gradle.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.io.File
import javax.inject.Inject

public abstract class ProcessPluginYaml @Inject constructor(
  private val compilation: KotlinCompilation<*>,
) : DefaultTask() {
  private companion object {
    const val LOADER: String = "net.radsteve.axi.plugin.loader.AxiPluginLoader"
  }

  @TaskAction
  public fun run() {
    val yaml = Yaml()
    val resources = compilation.defaultSourceSet.resources.sourceDirectories.singleFile

    val pluginYamlFile = resources.resolve("plugin.yml")
    val paperPluginYamlFile = resources.resolve("paper-plugin.yml")

    if (!pluginYamlFile.exists() && !paperPluginYamlFile.exists()) {
      return
    }

    if (
      (pluginYamlFile.exists() && paperPluginYamlFile.exists())
      || (!pluginYamlFile.exists()) && paperPluginYamlFile.exists()
    ) {
      processPaperPluginYaml(yaml.load(paperPluginYamlFile.readText()), paperPluginYamlFile)
    } else {
      processPluginYaml(yaml.load(pluginYamlFile.readText()), pluginYamlFile)
    }
  }

  private fun processPluginYaml(yaml: Map<String, Any>, file: File) {
    if ("libraries" in yaml) {
      println("w: You are using the 'libraries' block in your plugin.yml. This block")
      println("   will be ignored and you should use the 'axiRuntime' instead!")
    }

    processPaperPluginYaml(yaml, file)
  }

  private fun processPaperPluginYaml(yaml: Map<String, Any>, file: File) {
    val new = yaml.toMutableMap()
    if ("loader" !in yaml) {
      new["loader"] = LOADER
    }

    if (!file.exists()) {
      file.parentFile.mkdirs()
      file.createNewFile()
    }

    val dumper = DumperOptions()
    dumper.indent = 2
    dumper.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK

    val yamlInstance = Yaml(dumper)
    val serialisedYaml = yamlInstance.dump(new)
    val output = compilation.output.resourcesDir.resolve("paper-plugin.yml")

    if (!output.exists()) {
      output.parentFile.mkdirs()
    }

    output.writeText(serialisedYaml)
  }
}
