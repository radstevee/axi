plugins {
    `java-platform`
    `maven-publish`
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

    repositories {
        maven {
            name = "rad-public"
            url = uri("https://maven.radsteve.net/public")

            credentials {
                username = System.getenv("RAD_MAVEN_USER")
                password = System.getenv("RAD_MAVEN_TOKEN")
            }
        }
    }
}
