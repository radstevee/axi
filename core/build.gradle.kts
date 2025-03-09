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
    api(libs.bundles.cloud)
    api(libs.bundles.mccoroutine)
}
