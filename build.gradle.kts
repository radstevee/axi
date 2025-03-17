private fun delegatingTask(name: String, vararg delegateTasks: String) {
  tasks.register(name) {
    childProjects.forEach { (_, project) ->
      runCatching {
        delegateTasks.forEach { task -> dependsOn(project.tasks.getByName(task)) }
      }
    }
  }
}

delegatingTask("build", "build")
delegatingTask("spotlessCheck", "spotlessCheck")
delegatingTask("spotless", "spotlessApply")
delegatingTask("publish", "publish")
delegatingTask("dokka", "dokkaGenerate")
