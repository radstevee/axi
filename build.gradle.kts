private fun delegatingTask(name: String, vararg delegateTasks: String) {
  tasks.register(name) {
    childProjects.forEach { (_, project) ->
      runCatching {
        delegateTasks.forEach { task -> dependsOn(project.tasks.getByName(task)) }
      }
    }
  }
}

delegatingTask("buildAll", "build")
delegatingTask("spotlessCheck", "spotlessCheck")
delegatingTask("spotless", "spotlessApply")
delegatingTask("publishAll", "spotlessCheck", "publish")
