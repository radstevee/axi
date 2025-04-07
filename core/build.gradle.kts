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
  compileOnlyApi(libs.bundles.fawe)
  api(libs.bundles.cloud) {
    exclude(group = "org.jetbrains.kotlinx")
  }
  api(libs.bundles.mccoroutine)
  api(libs.bundles.koin)
  // api(libs.bundles.kraft)
}
