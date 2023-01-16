package moe.kmou424.asmrone.api.module

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.constant.MediaRepoConst.OrderBy
import moe.kmou424.asmrone.api.constant.MediaRepoConst.SortMethod
import moe.kmou424.asmrone.api.constant.MediaRepoConst.Subtitle
import moe.kmou424.asmrone.api.data.work.PaginationWorksData
import moe.kmou424.asmrone.api.util.RequestUtil
import moe.kmou424.asmrone.api.util.RequestUtil.parseBody

internal class MediaRepoClient {
    fun getWorks(
        orderBy: OrderBy,
        sortMethod: SortMethod,
        page: Int,
        subtitle: Subtitle,
        seed: Int = GlobalProperties.Config.Seed
    ) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(authToken = GlobalProperties.Config.AccessToken),
            HttpMethod.Get,
            urlPath = GlobalProperties.ASMROneApi.Path.Works,
            urlParameters = HashMap<String, String>().also {
                it["order"] = orderBy.key
                it["sort"] = sortMethod.key
                it["page"] = "$page"
                if (orderBy == OrderBy.RANDOM) {
                    it["seed"] = "$seed"
                }
                it["subtitle"] = if (subtitle.has) "1" else "0"
            }
        )
        return@runBlocking response.parseBody<PaginationWorksData>()
    }
}