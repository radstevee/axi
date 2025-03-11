package net.radstevee.axi.ksp

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets

public class AxiProcessor(
  env: SymbolProcessorEnvironment,
) : SymbolProcessor {
  private companion object Identifier {
    const val AUTO_REGISTERED_ANNOTATION: String = "net.radstevee.axi.core.command.AutoRegistered"
    const val AUTO_GENERATED_PACKAGE: String = "_axi_ksp_autogenerated"
    const val COMMAND: String = "net.radstevee.axi.core.command.Command"
  }

  private val gen: CodeGenerator = env.codeGenerator

  private fun createCodeFile(
    pkg: String,
    name: String,
    content: String,
    vararg deps: KSFile,
  ) {
    gen.createNewFile(
      Dependencies(false, *deps),
      pkg,
      name,
    ).use { out ->
      OutputStreamWriter(out, StandardCharsets.UTF_8).use { writer ->
        writer.write(content)
      }
    }
  }

  private fun processCommands(resolver: Resolver) {
    val properties = resolver.getSymbolsWithAnnotation(AUTO_REGISTERED_ANNOTATION)
      .filterIsInstance<KSPropertyDeclaration>()
    val services = mutableListOf<String>()

    properties.forEach { property ->
      val declQualified = property.qualifiedName!!.asString()
      val declName = property.simpleName.asString()
      val newPackage = property.packageName.asString() + ".$AUTO_GENERATED_PACKAGE"
      val newClassName = "__autogenerated_$declName"

      val code = """
                // spotless:off
                package $newPackage
                
                public class $newClassName : $COMMAND by $declQualified
                // spotless:on
      """.trimIndent()

      services.add("$newPackage.$newClassName")

      createCodeFile(newPackage, newClassName, code, property.containingFile!!)
    }

    runCatching {
      gen.createNewFileByPath(
        Dependencies(false),
        "META-INF/services/$COMMAND",
        "",
      ).use { out ->
        OutputStreamWriter(out, StandardCharsets.UTF_8).use { writer ->
          services.forEach { svc ->
            writer.write(svc)
            writer.write("\n")
          }
        }
      }
    }
  }

  override fun process(resolver: Resolver): List<KSAnnotated> {
    processCommands(resolver)
    return emptyList()
  }
}
