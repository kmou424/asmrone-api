package moe.kmou424.asmrone.api.module

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.data.auth.AuthMe
import moe.kmou424.asmrone.api.data.auth.Login
import moe.kmou424.asmrone.api.data.auth.Register
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
        return@runBlocking response.parseBody<Login>()
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
        return@runBlocking response.parseBody<Register>()
    }

    fun authMe(token: String = GlobalProperties.Config.AccessToken!!) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(authToken = token),
            HttpMethod.Get,
            urlPath = GlobalProperties.ASMROneApi.Path.AuthMe
        )
        return@runBlocking response.parseBody<AuthMe>()
    }
}