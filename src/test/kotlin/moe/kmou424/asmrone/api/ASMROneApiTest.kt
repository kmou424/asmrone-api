package moe.kmou424.asmrone.api

import org.junit.Test
import java.net.InetSocketAddress
import java.net.Proxy

class ASMROneApiTest {
    val testProxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress("127.0.0.1", 7890))
    val guestToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2FzbXIub25lIiwic3ViIjoiZ3Vlc3QiLCJhdWQiOiJodHRwczovL2FzbXIub25lL2FwaSIsIm5hbWUiOiJndWVzdCIsImdyb3VwIjoidXNlciIsImlhdCI6MTY3MzY4NTgxMywiZXhwIjoxNzA1MjIxODEzfQ.VufFn72CPLevSyItHA8U48g8R5X2jC1C9CzUbZ7AMFg"

    @Test
    fun testLogin() {
        val api = ASMROneClient(null, testProxy).Auth()
        println(api.login("guest", "guest"))
    }

    @Test
    fun testRegister() {
        val api = ASMROneClient(null, testProxy).Auth()
        println(api.register("guest", "guest"))
    }

    @Test
    fun testAuth() {
        val api = ASMROneClient(guestToken, testProxy).Auth()
        println(api.authMe())
    }

    @Test
    fun testAppVersion() {
        val api = ASMROneClient(guestToken, testProxy).App()
        println(api.version())
    }
}
