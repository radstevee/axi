plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.dokka)
    implementation(libs.plugin.ktx.serial)
    implementation(libs.plugin.paperweight)
    implementation(libs.plugin.spotless)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
