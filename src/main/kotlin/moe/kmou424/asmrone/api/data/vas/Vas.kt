package moe.kmou424.asmrone.api.data.vas

data class Vas(
    val id: String,
    val name: String
) {
    override fun toString(): String {
        return "VasData(id=$id, name='$name')"
    }
}
