package moe.kmou424.asmrone.api.data.auth

data class RegisterData(
    val token: String
) {
    override fun toString(): String {
        return "RegisterData(token='$token')"
    }
}
