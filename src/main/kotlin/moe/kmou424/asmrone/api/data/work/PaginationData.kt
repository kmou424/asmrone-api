package moe.kmou424.asmrone.api.data.work

data class PaginationData(
    val currentPage: Int,
    val pageSize: Int,
    val totalCount: Int
) {
    override fun toString(): String {
        return "PaginationData(currentPage=$currentPage, pageSize=$pageSize, totalCount=$totalCount)"
    }
}