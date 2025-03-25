plugins {
  id("axi.kotlin-conventions")
  id("axi.paper-conventions")
}

dependencies {
  api(libs.bundles.packed)
  implementation(libs.bundles.inject)
}

axi {
  dependencies("core")

  paper {
    internals()
  }
}
