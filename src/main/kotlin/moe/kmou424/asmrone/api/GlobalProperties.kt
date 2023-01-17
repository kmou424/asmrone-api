package moe.kmou424.asmrone.api

import io.ktor.client.plugins.logging.*
import java.net.Proxy

internal object GlobalProperties {

    object Config {
        var GlobalProxy: Proxy = Proxy.NO_PROXY
        var GlobalLogger: Logger = Logger.DEFAULT
        var AccessToken: String? = null
        var UserAgent: String = "ktor client"
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
            // WorksRepo
            const val AllWorks = "works"
            const val FavWorks = "review"
        }
    }
}