package moe.kmou424.asmrone.api.constant

object WorkRepoConst {
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

    enum class FavOrderBy(val key: String) {
        CREATE_DATE("create_date"),
        RELEASE_DATE("release"),
        MY_RATING("rating"),
        DOWNLOAD_COUNT("dl_count"),
        SELLING_PRICE("price"),
        RATING("rate_average_2dp"),
        REVIEW_COUNT("review_count"),
        DLSITE_ID("id"),
        NO_NSFW("nsfw"),
        RANDOM("random"),
        UPDATE_DATE("updated_at")
    }

    enum class FavProgressFilter(val key: String) {
        LISTEN_WILL("marked"),
        LISTEN_DOING("listening"),
        LISTEN_DONE("listened"),
        LISTEN_AGAIN("replay"),
        LISTEN_POSTPONE("postponed")
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