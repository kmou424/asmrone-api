package moe.kmou424.asmrone.api.data.work

import com.fasterxml.jackson.annotation.JsonProperty
import moe.kmou424.asmrone.api.data.circle.CircleData
import moe.kmou424.asmrone.api.data.vas.VasData

data class WorkInfoData(
    val circle: CircleData,
    @JsonProperty("circle_id")
    val circleId: Int,
    @JsonProperty("create_date")
    val createDateString: String,
    @JsonProperty("dl_count")
    val downloadCount: Int,
    @JsonProperty("has_subtitle")
    val hasSubtitle: Boolean,
    @JsonProperty("id")
    val dlsiteId: Int,
    val mainCoverUrl: String,
    val samCoverUrl: String,
    val thumbnailCoverUrl: String,
    val name: String,
    @JsonProperty("nsfw")
    val isNSFW: Boolean,
    @JsonProperty("price")
    val sellingPrice: Int,
    @JsonProperty("rank")
    val historyRanks: Array<RankData>?,
    @JsonProperty("rate_average_2dp")
    val rateAvgScore: Double,
    @JsonProperty("rate_count")
    val rateCount: Int,
    @JsonProperty("rate_count_detail")
    val rateDetailByScore: Array<RateScoreDetailData>,
    @JsonProperty("userRating")
    val rateByUser: Int?,
    @JsonProperty("release")
    val releaseDateString: String,
    @JsonProperty("review_count")
    val commentCount: Int,
    val tags: Array<TagData>?,
    val title: String,
    @JsonProperty("vas")
    val vases: Array<VasData>
) {
    override fun toString(): String {
        return "WorkInfoData(circle=$circle, circleId=$circleId, createDateString='$createDateString', downloadCount=$downloadCount, hasSubtitle=$hasSubtitle, dlsiteId=$dlsiteId, mainCoverUrl='$mainCoverUrl', samCoverUrl='$samCoverUrl', thumbnailCoverUrl='$thumbnailCoverUrl', name='$name', isNSFW=$isNSFW, sellingPrice=$sellingPrice, historyRanks=${historyRanks.contentToString()}, rateAvgScore=$rateAvgScore, rateCount=$rateCount, rateDetailByScore=${rateDetailByScore.contentToString()}, rateByUser=$rateByUser, releaseDateString='$releaseDateString', commentCount=$commentCount, tags=${tags.contentToString()}, title='$title', vases=${vases.contentToString()})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WorkInfoData

        if (circle != other.circle) return false
        if (circleId != other.circleId) return false
        if (createDateString != other.createDateString) return false
        if (downloadCount != other.downloadCount) return false
        if (hasSubtitle != other.hasSubtitle) return false
        if (dlsiteId != other.dlsiteId) return false
        if (mainCoverUrl != other.mainCoverUrl) return false
        if (samCoverUrl != other.samCoverUrl) return false
        if (thumbnailCoverUrl != other.thumbnailCoverUrl) return false
        if (name != other.name) return false
        if (isNSFW != other.isNSFW) return false
        if (sellingPrice != other.sellingPrice) return false
        if (!historyRanks.contentEquals(other.historyRanks)) return false
        if (rateAvgScore != other.rateAvgScore) return false
        if (rateCount != other.rateCount) return false
        if (!rateDetailByScore.contentEquals(other.rateDetailByScore)) return false
        if (rateByUser != other.rateByUser) return false
        if (releaseDateString != other.releaseDateString) return false
        if (commentCount != other.commentCount) return false
        if (!tags.contentEquals(other.tags)) return false
        if (title != other.title) return false
        if (!vases.contentEquals(other.vases)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = circle.hashCode()
        result = 31 * result + circleId
        result = 31 * result + createDateString.hashCode()
        result = 31 * result + downloadCount
        result = 31 * result + hasSubtitle.hashCode()
        result = 31 * result + dlsiteId
        result = 31 * result + mainCoverUrl.hashCode()
        result = 31 * result + samCoverUrl.hashCode()
        result = 31 * result + thumbnailCoverUrl.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + isNSFW.hashCode()
        result = 31 * result + sellingPrice
        result = 31 * result + historyRanks.contentHashCode()
        result = 31 * result + rateAvgScore.hashCode()
        result = 31 * result + rateCount
        result = 31 * result + rateDetailByScore.contentHashCode()
        result = 31 * result + (rateByUser ?: 0)
        result = 31 * result + releaseDateString.hashCode()
        result = 31 * result + commentCount
        result = 31 * result + tags.contentHashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + vases.contentHashCode()
        return result
    }
}
