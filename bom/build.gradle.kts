plugins {
    `java-platform`
}

dependencies {
    constraints {
        rootProject.childProjects
            .filter { (name) -> name != "bom" }
            .forEach { (_, project) -> api(project) }
    }
}
