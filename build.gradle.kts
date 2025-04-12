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
delegatingTask("publish", "publish")
delegatingTask("dokka", "dokkaGenerate")
delegatingTask("lint", "ktlintFormat")
