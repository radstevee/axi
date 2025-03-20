plugins {
  id("axi.kotlin-conventions")
  id("axi.paper-conventions")
}

axi {
  paper {
    internals()
  }
}

dependencies {
  api(libs.bundles.cloud) {
    exclude(group = "org.jetbrains.kotlinx")
  }
  api(libs.bundles.mccoroutine)
}
