plugins {
    id("axi.kotlin-conventions")
    id("axi.paper-conventions")
}

dependencies {
    // Explicitly not exposing it because of our wrappers around it.
    implementation(libs.bundles.mccoroutine)
}
