package moe.kmou424.asmrone.api.data.work

import com.fasterxml.jackson.annotation.JsonProperty

data class Rank(
    val category: String,
    val rank: Int,
    @JsonProperty("rank_date")
    val rankDate: String,
    val term: String
) {
    override fun toString(): String {
        return "WorkRankData(category='$category', rank=$rank, rankDate='$rankDate', term='$term')"
    }
}
