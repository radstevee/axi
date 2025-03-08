private fun delegatingTask(name: String, delegateTask: String) {
    tasks.register(name) {
        childProjects.forEach { (_, project ) ->
            runCatching {
                dependsOn(project.tasks.getByName(delegateTask))
            }
        }
    }
}

delegatingTask("buildAll", "build")
delegatingTask("publishAll", "publish")
