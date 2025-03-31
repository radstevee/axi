package net.radsteve.axi.ui.resource.host

import io.netty.channel.ChannelHandlerContext
import net.mcbrawls.inject.http.HttpByteBuf
import net.mcbrawls.inject.http.HttpByteBuf.httpBuf
import net.mcbrawls.inject.http.HttpInjector
import net.mcbrawls.inject.http.HttpRequest
import net.mcbrawls.inject.spigot.InjectSpigot
import net.radsteve.axi.ui.resource.pack.AxiPackRegistry
import kotlin.text.get

internal object ResourcePackInjector : HttpInjector() {
  override fun intercept(
    ctx: ChannelHandlerContext,
    request: HttpRequest,
  ): HttpByteBuf {
    val buf = httpBuf(ctx)
    buf.writeStatusLine("1.1", 200, "OK")

    val pack = AxiPackRegistry[request.requestURI.removePrefix("/packs/")] ?: return buf

    buf.writeHeader("Content-Type", "application/zip")
    buf.writeBytes(pack.bytes)

    return buf
  }

  init {
    InjectSpigot.INSTANCE.registerInjector(this)
  }
}
