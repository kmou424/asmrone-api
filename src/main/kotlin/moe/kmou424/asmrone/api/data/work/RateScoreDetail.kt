package moe.kmou424.asmrone.api.data.work

import com.fasterxml.jackson.annotation.JsonProperty

data class RateScoreDetail(
    val count: Int,
    val ratio: Int,
    @JsonProperty("review_point")
    val point: Int
) {
    override fun toString(): String {
        return "RateScoreDetail(count=$count, ratio=$ratio, point=$point)"
    }
}
