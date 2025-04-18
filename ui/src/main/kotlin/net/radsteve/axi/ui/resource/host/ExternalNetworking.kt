package net.radsteve.axi.ui.resource.host

import net.radsteve.axi.utility.mutableLazy
import org.bukkit.Bukkit
import org.jetbrains.annotations.ApiStatus
import java.net.InetSocketAddress
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

private val httpClient: HttpClient = HttpClient.newHttpClient()
private const val CHECKIP_URL = "https://checkip.amazonaws.com"

/**
 * The external address of the server.
 * The lazy initialiser does a network request to `https://checkip.amazonaws.com`.
 *
 * You can specify them manually with the `axi.external_addr` and
 * `axi.external_port` JVM properties.
 */
@set:ApiStatus.Internal
public var externalServerAddress: InetSocketAddress by mutableLazy {
  val addrProp = System.getProperty("axi.external_addr")
  val portProp = System.getProperty("axi.external_port")
  val port = portProp?.toInt() ?: Bukkit.getPort()

  if (addrProp != null) {
    val addr = InetSocketAddress.createUnresolved(addrProp, port)
    return@mutableLazy addr
  }

  val response = httpClient.send(
    HttpRequest.newBuilder(URI.create(CHECKIP_URL)).build(),
    HttpResponse.BodyHandlers.ofString(),
  )
  val responseStr = response.body().removeSuffix("\\n")
  val addr = InetSocketAddress.createUnresolved(responseStr, port)

  addr
}

/** Whether the [externalServerAddress] is accessible. */
public val externalAddressAccessible: Boolean by lazy {
  val response = runCatching {
    httpClient.send(
      HttpRequest.newBuilder(buildServerURI())
        .timeout(Duration.ofSeconds(2))
        .build(),
      HttpResponse.BodyHandlers.ofString(),
    )
  }

  if (response.isFailure) {
    externalServerAddress = InetSocketAddress.createUnresolved(
      "localhost",
      System.getProperty("axi.external_port")?.toInt() ?: Bukkit.getPort(),
    )

    return@lazy false
  }
  val res = response.getOrThrow()

  (res.statusCode() == 200) && (res.body().isEmpty())
}

/** Builds an external server URI with the specified [path] and [addr]. */
public fun buildServerURI(path: String = "", addr: InetSocketAddress = externalServerAddress): URI {
  @Suppress("HttpUrlsUsage")
  return URI.create("http://" + addr.hostString.removeSuffix("\n") + ":" + addr.port + "/" + path)
}
