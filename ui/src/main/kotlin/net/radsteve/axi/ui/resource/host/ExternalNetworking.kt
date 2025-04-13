package net.radsteve.axi.ui.resource.host

import org.bukkit.Bukkit
import java.net.InetSocketAddress
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

private var externalAddressAccessible: Boolean? = null
private var cachedServerAddress: InetSocketAddress? = null
private val httpClient: HttpClient = HttpClient.newHttpClient()
private const val CHECKIP_URL = "https://checkip.amazonaws.com"

/**
 * Gets the external address of the server.
 * This method does a network request to `https://checkip.amazonaws.com`.
 *
 * You can specify them manually with the `axi.external_addr` and
 * `axi.external_port` JVM properties.
 */
public fun externalServerAddress(): InetSocketAddress {
  cachedServerAddress?.let { addr -> return addr }
  val addrProp = System.getProperty("axi.external_addr")
  val portProp = System.getProperty("axi.external_port")
  val port = portProp?.toInt() ?: Bukkit.getPort()

  if (addrProp != null) {
    val addr = InetSocketAddress.createUnresolved(addrProp, port)
    cachedServerAddress = addr

    return addr
  }

  val response = httpClient.send(
    HttpRequest.newBuilder(URI.create(CHECKIP_URL)).build(),
    HttpResponse.BodyHandlers.ofString(),
  )
  val responseStr = response.body().removeSuffix("\\n")
  val addr = InetSocketAddress.createUnresolved(responseStr, port)
  cachedServerAddress = addr

  checkExternalAddr()

  return cachedServerAddress!!
}

/** Builds an external server URI with the specified [path] and [addr]. */
public fun buildServerURI(path: String = "", addr: InetSocketAddress = externalServerAddress()): URI {
  return URI.create("http://" + addr.hostString.removeSuffix("\n") + ":" + addr.port + "/" + path)
}

/** Checks if the [externalServerAddress] is accessible by sending it an HTTP request. */
public fun checkExternalAddr(): Boolean {
  externalAddressAccessible?.let { accessible -> return accessible }
  val response = runCatching {
    httpClient.send(
      HttpRequest.newBuilder(buildServerURI())
        .timeout(Duration.ofSeconds(2))
        .build(),
      HttpResponse.BodyHandlers.ofString(),
    )
  }

  if (response.isFailure) {
    externalAddressAccessible = false
    cachedServerAddress = InetSocketAddress.createUnresolved("localhost", System.getProperty("axi.external_port")?.toInt() ?: Bukkit.getPort())

    return false
  }
  val res = response.getOrThrow()

  externalAddressAccessible = (res.statusCode() == 200) && (res.body().isEmpty())

  return externalAddressAccessible!!
}
