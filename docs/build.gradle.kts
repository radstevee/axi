import com.github.gradle.node.npm.task.NpmTask
import io.papermc.paperweight.util.capitalized

plugins {
  id("axi.kotlin-conventions")
  id("com.github.node-gradle.node") version "7.1.0"
}

setOf("dev", "build", "preview").forEach { task ->
  tasks.register<NpmTask>("docs${task.capitalized()}") {
    args = listOf("run", task)
  }
}

spotless {
  freshmark {
    toggleOffOn()
    target("src")
  }
}

tasks {
  delete("publish")
}
