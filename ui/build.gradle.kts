plugins {
  axi.kotlin
  axi.paper
}

dependencies {
  api(libs.bundles.packed)
  api(libs.interfaces)
  implementation(libs.bundles.inject)
}

axi {
  dependencies("core")

  paper {
    internals()
  }
}
