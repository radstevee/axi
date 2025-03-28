plugins {
  id("axi.publishing-repo-conventions")
  `java-platform`
}

group = "net.radstevee.axi"
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
