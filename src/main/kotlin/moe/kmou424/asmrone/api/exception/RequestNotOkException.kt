package moe.kmou424.asmrone.api.exception

import moe.kmou424.asmrone.api.data.common.CommonError

class RequestNotOkException(private val error: CommonError) : RuntimeException() {
    override fun toString(): String {
        return super.toString() + " -> " + error
    }
}