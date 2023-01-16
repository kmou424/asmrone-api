package moe.kmou424.asmrone.api.data.circle

data class CircleData(
    val id: Int,
    val name: String
) {
    override fun toString(): String {
        return "CircleData(id=$id, name='$name')"
    }
}
