package moe.kmou424.asmrone.api.module

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.data.app.VersionData
import moe.kmou424.asmrone.api.util.RequestUtil
import moe.kmou424.asmrone.api.util.RequestUtil.parseBody

internal class AppClient {
    fun version(token: String) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(authToken = token),
            HttpMethod.Get,
            urlPath = GlobalProperties.ASMROneApi.Path.Version
        )
        return@runBlocking response.parseBody<VersionData>()
    }
}