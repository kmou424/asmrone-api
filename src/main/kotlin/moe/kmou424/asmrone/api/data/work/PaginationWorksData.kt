package moe.kmou424.asmrone.api.data.work

data class PaginationWorksData(
    val pagination: PaginationData,
    val works: Array<WorkInfoData>
) {
    override fun toString(): String {
        return "PaginationWorksData(pagination=$pagination, works=${works.contentToString()})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PaginationWorksData

        if (pagination != other.pagination) return false
        if (!works.contentEquals(other.works)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pagination.hashCode()
        result = 31 * result + works.contentHashCode()
        return result
    }
}