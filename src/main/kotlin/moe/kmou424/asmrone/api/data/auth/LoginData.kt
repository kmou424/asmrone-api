package moe.kmou424.asmrone.api.data.auth

data class LoginData(
    val token: String
) {
    override fun toString(): String {
        return "LoginData(token='$token')"
    }
}
