package moe.kmou424.asmrone.api.data.work

import moe.kmou424.asmrone.api.data.common.AttributeData

data class TagData(
    val i18n: Map<String, AttributeData>,
    val id: Int,
    val name: String
) {
    override fun toString(): String {
        return "TagData(i18n=$i18n, id=$id, name='$name')"
    }
}
