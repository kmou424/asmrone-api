package moe.kmou424.asmrone.api

import java.net.Proxy

object GlobalProperties {

    var GlobalProxy: Proxy = Proxy.NO_PROXY
    var AccessToken: String? = null

    object ASMROneApi {
        const val host = "api.asmr.one/api"
        object Path {
            // App
            const val Version = "version"
            // AuthApi
            const val AuthMe = "auth/me"
            const val Register = "auth/reg"
        }
    }
}