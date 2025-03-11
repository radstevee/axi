plugins {
  id("axi.kotlin-conventions")
  id("axi.paper-conventions")
}

repositories {
  maven("https://maven.radsteve.net/public")
  maven("https://maven.mcbrawls.net/releases")
}

dependencies {
  api(libs.bundles.packed)
  implementation(libs.bundles.inject)
}

axi {
  paper {
    internals()
  }
}
