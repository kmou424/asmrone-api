package moe.kmou424.asmrone.api

import io.ktor.client.plugins.logging.*
import moe.kmou424.asmrone.api.constant.WorkRepoConst
import moe.kmou424.asmrone.api.data.auth.Login
import moe.kmou424.asmrone.api.data.auth.Register
import moe.kmou424.asmrone.api.module.AppClient
import moe.kmou424.asmrone.api.module.AuthClient
import moe.kmou424.asmrone.api.module.WorkRepoClient
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

    inner class WorkRepo {
        private val mWorkRepoClient: WorkRepoClient = WorkRepoClient()

        fun getWorks(
            orderBy: WorkRepoConst.OrderBy,
            sortMethod: WorkRepoConst.SortMethod,
            page: Int,
            subtitle: WorkRepoConst.Subtitle
        ) = HandleUtil.checkAccessTokenAndRun {
            mWorkRepoClient.getWorks(
                orderBy, sortMethod, page, subtitle
            )
        }

        fun getFavoriteWorks(
            favOrderBy: WorkRepoConst.FavOrderBy,
            sortMethod: WorkRepoConst.SortMethod,
            page: Int,
            favProgressFilter: WorkRepoConst.FavProgressFilter? = null
        ) = HandleUtil.checkAccessTokenAndRun {
            mWorkRepoClient.getFavoriteWorks(
                favOrderBy, sortMethod, page, favProgressFilter
            )
        }
    }
}