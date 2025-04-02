plugins {
  axi.kotlin
  axi.paper
}

dependencies {
  implementation(libs.paper.api)
  implementation(libs.classgraph)
  implementation(kotlin("reflect"))
}

tasks {
  delete("publish")
}
