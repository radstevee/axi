tasks.register("buildAll") {
    childProjects.forEach { (_, project ) ->
        dependsOn(project.tasks.getByName("build"))
    }
}
