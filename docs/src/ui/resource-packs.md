# Resource Packs

Axi has a resource pack API wrapping around [packed](https://packed.radsteve.net).

## Creating your own resource pack

You can create your own by extending the `AxiPack` class like such:

```kt
object ExamplePack : AxiPack("example")
```

Now, this won't compile. We need to provide the underlying packed `resourcePack`
like such:

```kt
public object ExamplePack : AxiPack("example") {
  override val pack: ResourcePack = resourcePack {
    meta {
      description = "Example axi pack"
      format = PackFormat.V1_21_4
    }

    assetResolutionStrategy = SourceDirectoryAssetResolutionStrategy(File("../assets"))

    applyAxi()
  }
}
```

This is a very basic packed resource pack. If you are unfamiliar with packed,
you can read its [docs](https://packed.radsteve.net/getting-started.html).

Notice how we don't specify an `outputDir` ourselves? That's handled by axi's
`applyAxi` function. Be sure to call this in your resource pack builders, otherwise
Axi's resource pack API will not work.

## Saving your resource pack

To save your resource pack, all you need to do is call `AxiPack#save`. This will
save the resource pack to a temporary directory, create a zip file and read the
contents and the hash into memory.

## Sending your resource pack

Axi uses [inject](https://github.com/mcbrawls/inject) to serve resource packs
via the Minecraft port (using Netty injection). This requires your IP address
to be exposed publicly. How Axi achieves this is it pings `checkip.amazonaws.com`
and uses the result as a public IP, unless specified otherwise using the
`axi.external_addr` and `axi.external_port` JVM properties.

To send a resource pack to a player, you can use `Audience#sendAxiPack`.
This call will suspend until the pack has either loaded or it failed to load
since it returns whether the pack has loaded for each receiving player.
