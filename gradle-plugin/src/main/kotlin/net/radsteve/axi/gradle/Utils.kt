package net.radsteve.axi.gradle

import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import java.io.File

public val KotlinCompilation<*>.resources: File get() = defaultSourceSet.resources.sourceDirectories.files.first()
