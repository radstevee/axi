plugins {
    id("axi.kotlin-conventions")
    id("axi.paper-conventions")
}

axiPaper {
    internals()
}

dependencies {
    api(libs.bundles.cloud)
}
