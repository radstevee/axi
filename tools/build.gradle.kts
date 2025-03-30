plugins {
  id("axi.kotlin-conventions")
  id("axi.paper-conventions")
}

dependencies {
  implementation(libs.paper.api)
  implementation(libs.classgraph)
  implementation(kotlin("reflect"))
}

tasks {
  delete("publish")
}
