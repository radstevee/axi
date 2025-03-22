# Installation

To install the UI module, you need to add it to your dependencies:

::: code-group

```kts{4} [build.gradle.kts]
dependencies {
  implementation(platform("net.radstevee.axi:axi-bom:VERSION"))
  implementation("net.radstevee.axi:axi-core")
  implementation("net.radstevee.axi:axi-ui")
}
```

```groovy{4} [build.gradle]
dependencies {
  implementation platform('net.radstevee.axi:axi-bom:VERSION')
  implementation 'net.radstevee.axi:axi-core'
  implementation 'net.radstevee.axi:axi-ui'
}
```

:::

And now it is installed and will automatically be loaded!
