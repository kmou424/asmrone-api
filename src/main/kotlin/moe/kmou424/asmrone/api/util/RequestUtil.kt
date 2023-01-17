package moe.kmou424.asmrone.api.util

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.serialization.jackson.*
import io.ktor.util.cio.*
import kotlinx.coroutines.runBlocking
import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.exception.RequestNotOkException
import java.io.File
import java.net.Proxy

object RequestUtil {
    fun getHttpClient(
        requestProxy: Proxy = GlobalProperties.Config.GlobalProxy,
        authToken: String? = null
    ): HttpClient {
        return HttpClient(OkHttp) {
            install(Logging) {
                logger = GlobalProperties.Config.GlobalLogger
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                jackson {
                    enable(SerializationFeature.INDENT_OUTPUT)
                }
            }
            engine {
                if (requestProxy != Proxy.NO_PROXY) {
                    proxy = requestProxy
                }
            }
            HandleUtil.isNotNullRun(authToken) { token ->
                install(Auth) {
                    bearer {
                        loadTokens {
                            BearerTokens(token, token)
                        }
                    }
                }
            }
        }
    }

    suspend fun request(
        httpClient: HttpClient,
        httpMethod: HttpMethod,
        urlHost: String = GlobalProperties.ASMROneApi.host,
        urlPath: String = "",
        urlParameters: Map<String, String>? = null,
        acceptContentType: String = "text/json",
        binaryFile: File? = null,
        jsonBody: Map<String, Any?>? = null,
    ): HttpResponse {
        return httpClient.request {
            method = httpMethod
            url {
                protocol = URLProtocol.HTTPS
                host = urlHost
                path(urlPath)
                HandleUtil.isNotNullRun(urlParameters) { params ->
                    for (entry in params.entries) {
                        parameters.append(entry.key, entry.value)
                    }
                }
            }
            headers {
                append(HttpHeaders.Accept, acceptContentType)
                append(HttpHeaders.UserAgent, GlobalProperties.Config.UserAgent)
            }
            HandleUtil.isNotNullRun(binaryFile) { file ->
                setBody(file.readChannel())
            }
            HandleUtil.isNotNullRun(jsonBody) { param ->
                contentType(ContentType.Application.Json)
                setBody(param)
            }
        }
    }

    inline fun <reified T> HttpResponse.parseBody() = runBlocking {
        try {
            return@runBlocking body<T>()
        } catch (e: JsonConvertException) {
            throw RequestNotOkException(body())
        }
    }
}