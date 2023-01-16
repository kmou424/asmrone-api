package moe.kmou424.asmrone.api.constant

object MediaRepoConst {
    enum class OrderBy(val key: String) {
        CREATE_DATE("create_date"),
        RELEASE_DATE("release"),
        MY_RATING("rating"),
        DOWNLOAD_COUNT("dl_count"),
        SELLING_PRICE("price"),
        RATING("rate_average_2dp"),
        REVIEW_COUNT("review_count"),
        DLSITE_ID("id"),
        NO_NSFW("nsfw"),
        RANDOM("random")
    }

    enum class SortMethod(val key: String) {
        ASC("asc"),
        DESC("desc")
    }

    enum class Subtitle(val has: Boolean) {
        YES(true),
        NO(false)
    }
}