package moe.kmou424.asmrone.api.util

import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.exception.AccessTokenNotFoundException

object HandleUtil {
    fun <T> isNullRun(obj: T?, block: () -> Unit = {}) {
        obj ?: block()
    }

    fun <T> isNotNullRun(obj: T?, block: (obj: T) -> Unit = {}) {
        obj?.run { block(obj) }
    }

    fun <T> checkAccessTokenAndRun(block: (token: String) -> T): T {
        if (GlobalProperties.AccessToken == null)
            throw AccessTokenNotFoundException()
        return block(GlobalProperties.AccessToken!!)
    }
}