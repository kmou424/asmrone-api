package moe.kmou424.asmrone.api.data.auth

data class User(
    val name: String,
    val group: String
) {
    override fun toString(): String {
        return "User(name='$name', group='$group')"
    }
}
