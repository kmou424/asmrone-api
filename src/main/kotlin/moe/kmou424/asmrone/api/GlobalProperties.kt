package moe.kmou424.asmrone.api

import java.net.Proxy

internal object GlobalProperties {

    object Config {
        var GlobalProxy: Proxy = Proxy.NO_PROXY
        var AccessToken: String? = null
        val Seed: Int
            get() = (1 .. 99).random()
    }

    object ASMROneApi {
        const val host = "api.asmr.one/api"
        object Path {
            // App
            const val Version = "version"
            // Auth
            const val AuthMe = "auth/me"
            const val Register = "auth/reg"
            // MediaRepo
            const val Works = "works"
        }
    }
}