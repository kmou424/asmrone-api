package moe.kmou424.asmrone.api.module

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.data.auth.AuthMeData
import moe.kmou424.asmrone.api.data.auth.LoginData
import moe.kmou424.asmrone.api.data.auth.RegisterData
import moe.kmou424.asmrone.api.util.RequestUtil
import moe.kmou424.asmrone.api.util.RequestUtil.parseBody

internal class AuthClient {

    fun login(name: String, password: String) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(),
            HttpMethod.Post,
            urlPath = GlobalProperties.ASMROneApi.Path.AuthMe,
            jsonBody = HashMap<String, String>().also {
                it["name"] = name
                it["password"] = password
            }
        )
        return@runBlocking response.parseBody<LoginData>()
    }

    fun register(name: String, password: String) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(),
            HttpMethod.Post,
            urlPath = GlobalProperties.ASMROneApi.Path.Register,
            jsonBody = HashMap<String, String>().also {
                it["name"] = name
                it["password"] = password
            }
        )
        return@runBlocking response.parseBody<RegisterData>()
    }

    fun authMe(token: String) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(authToken = token),
            HttpMethod.Get,
            urlPath = GlobalProperties.ASMROneApi.Path.AuthMe
        )
        return@runBlocking response.parseBody<AuthMeData>()
    }
}