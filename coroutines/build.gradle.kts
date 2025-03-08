plugins {
    id("axi.kotlin-conventions")
    id("axi.paper-conventions")
}

dependencies {
    // Explicitly not exposing MCCoroutine for ease of use.
    implementation(libs.bundles.mccoroutine)
}
