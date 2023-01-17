package moe.kmou424.asmrone.api

import io.ktor.client.plugins.logging.*
import moe.kmou424.asmrone.api.constant.MediaRepoConst
import moe.kmou424.asmrone.api.data.auth.Login
import moe.kmou424.asmrone.api.data.auth.Register
import moe.kmou424.asmrone.api.module.AppClient
import moe.kmou424.asmrone.api.module.AuthClient
import moe.kmou424.asmrone.api.module.MediaRepoClient
import moe.kmou424.asmrone.api.util.HandleUtil
import java.net.Proxy

class ASMROneClient(
    token: String? = null,
    proxy: Proxy = Proxy.NO_PROXY,
    logger: Logger = Logger.DEFAULT
) {

    init {
        // 初始化时设置Token
        GlobalProperties.Config.AccessToken = token
        // 初始化时设置代理
        GlobalProperties.Config.GlobalProxy = proxy
        // 初始化时配置logger
        GlobalProperties.Config.GlobalLogger = logger
    }

    inner class Config {
        fun setProxy(proxy: Proxy) {
            GlobalProperties.Config.GlobalProxy = proxy
        }

        fun setUserAgent(userAgent: String) {
            GlobalProperties.Config.UserAgent = userAgent
        }
    }

    inner class App {
        private val mAppApi: AppClient = AppClient()

        fun version() = HandleUtil.checkAccessTokenAndRun {
            mAppApi.version()
        }
    }


    inner class Auth {
        private val mAuthClient: AuthClient = AuthClient()

        // 登录并保存token
        fun login(name: String, password: String): Login {
            mAuthClient.login(name, password).let {
                GlobalProperties.Config.AccessToken = it.token
                return it
            }
        }

        // 注册并保存token
        fun register(name: String, password: String): Register {
            mAuthClient.register(name, password).let {
                GlobalProperties.Config.AccessToken = it.token
                return it
            }
        }

        // 验证token
        fun authMe() = HandleUtil.checkAccessTokenAndRun {
            mAuthClient.authMe()
        }

        // 清除token退出登录
        fun logout() {
            GlobalProperties.Config.AccessToken = null
        }
    }

    inner class MediaRepo {
        private val mMediaRepoClient: MediaRepoClient = MediaRepoClient()

        fun getWorks(
            orderBy: MediaRepoConst.OrderBy,
            sortMethod: MediaRepoConst.SortMethod,
            page: Int,
            subtitle: MediaRepoConst.Subtitle
        ) = HandleUtil.checkAccessTokenAndRun {
            mMediaRepoClient.getWorks(
                orderBy, sortMethod, page, subtitle
            )
        }
    }
}