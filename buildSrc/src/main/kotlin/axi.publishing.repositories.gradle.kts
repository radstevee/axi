plugins {
  `maven-publish`
}

publishing {
  repositories {
    maven {
      name = "radPublic"
      url = uri("https://maven.radsteve.net/public")

      credentials {
        username = System.getenv("RAD_MAVEN_USER")
        password = System.getenv("RAD_MAVEN_TOKEN")
      }
    }
  }
}
