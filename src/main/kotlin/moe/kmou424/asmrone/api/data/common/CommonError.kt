package moe.kmou424.asmrone.api.data.common

data class CommonError(
    var error: String
) {
    override fun toString(): String {
        return "CommonError(error='$error')"
    }
}
