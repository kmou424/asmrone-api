package moe.kmou424.asmrone.api.data.auth

data class AuthMeData(
    val user: UserData,
    val auth: Boolean,
    val reg: Boolean
) {
    override fun toString(): String {
        return "AuthMeData(user=$user, auth=$auth, reg=$reg)"
    }
}
