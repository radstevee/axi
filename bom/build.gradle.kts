plugins {
  axi.publishing.repositories
  `java-platform`
}

group = "net.radsteve.axi"
version = rootProject.property("version") as String

javaPlatform {
  allowDependencies()
}

dependencies {
  constraints {
    rootProject.childProjects
      .filter { (name) -> name != "bom" }
      .forEach { (_, project) -> api(project) }
  }
}

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["javaPlatform"])
    }
  }
}
