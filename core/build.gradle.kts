plugins {
  axi.kotlin
  axi.paper
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
  api(libs.bundles.koin)
  api(libs.bundles.fawe)
}
