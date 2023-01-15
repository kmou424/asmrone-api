package moe.kmou424.asmrone.api

import moe.kmou424.asmrone.api.data.auth.LoginData
import moe.kmou424.asmrone.api.data.auth.RegisterData
import moe.kmou424.asmrone.api.module.AppClient
import moe.kmou424.asmrone.api.module.AuthClient
import moe.kmou424.asmrone.api.util.HandleUtil
import java.net.Proxy

class ASMROneClient(
    token: String? = null,
    proxy: Proxy = Proxy.NO_PROXY
) {

    init {
        // 初始化时设置Token
        GlobalProperties.AccessToken = token
        // 初始化时设置代理
        GlobalProperties.GlobalProxy = proxy
    }

    inner class App {
        private val mAppApi: AppClient = AppClient()

        fun version() = HandleUtil.checkAccessTokenAndRun { token ->
            mAppApi.version(token)
        }
    }


    inner class Auth {
        private val mAuthClient: AuthClient = AuthClient()

        // 登录并保存token
        fun login(name: String, password: String): LoginData {
            mAuthClient.login(name, password).let {
                GlobalProperties.AccessToken = it.token
                return it
            }
        }

        // 注册并保存token
        fun register(name: String, password: String): RegisterData {
            mAuthClient.register(name, password).let {
                GlobalProperties.AccessToken = it.token
                return it
            }
        }

        // 验证token
        fun authMe() = HandleUtil.checkAccessTokenAndRun { token ->
            mAuthClient.authMe(token)
        }

        // 清除token退出登录
        fun logout() {
            GlobalProperties.AccessToken = null
        }
    }
}