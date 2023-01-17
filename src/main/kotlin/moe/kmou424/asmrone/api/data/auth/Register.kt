package moe.kmou424.asmrone.api.data.auth

data class Register(
    val token: String
) {
    override fun toString(): String {
        return "RegisterData(token='$token')"
    }
}
