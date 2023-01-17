package moe.kmou424.asmrone.api.module

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import moe.kmou424.asmrone.api.GlobalProperties
import moe.kmou424.asmrone.api.constant.WorkRepoConst.FavProgressFilter
import moe.kmou424.asmrone.api.constant.WorkRepoConst.FavOrderBy
import moe.kmou424.asmrone.api.constant.WorkRepoConst.OrderBy
import moe.kmou424.asmrone.api.constant.WorkRepoConst.SortMethod
import moe.kmou424.asmrone.api.constant.WorkRepoConst.Subtitle
import moe.kmou424.asmrone.api.data.work.PaginationWorks
import moe.kmou424.asmrone.api.util.HandleUtil
import moe.kmou424.asmrone.api.util.RequestUtil
import moe.kmou424.asmrone.api.util.RequestUtil.parseBody

internal class WorkRepoClient {
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
            urlPath = GlobalProperties.ASMROneApi.Path.AllWorks,
            urlParameters = HashMap<String, String>().also { map ->
                map["order"] = orderBy.key
                map["sort"] = sortMethod.key
                map["page"] = "$page"
                if (orderBy == OrderBy.RANDOM) {
                    map["seed"] = "$seed"
                }
                map["subtitle"] = if (subtitle.has) "1" else "0"
            }
        )
        return@runBlocking response.parseBody<PaginationWorks>()
    }

    fun getFavoriteWorks(
        favOrderBy: FavOrderBy,
        sortMethod: SortMethod,
        page: Int,
        favProgressFilter: FavProgressFilter?
    ) = runBlocking {
        val response = RequestUtil.request(
            RequestUtil.getHttpClient(authToken = GlobalProperties.Config.AccessToken),
            HttpMethod.Get,
            urlPath = GlobalProperties.ASMROneApi.Path.FavWorks,
            urlParameters = HashMap<String, String>().also { map ->
                map["order"] = favOrderBy.key
                map["sort"] = sortMethod.key
                map["page"] = "$page"
                HandleUtil.isNotNullRun(favProgressFilter) { favFilterNotNull ->
                    map["filter"] = favFilterNotNull.key
                }
            }
        )
        return@runBlocking response.parseBody<PaginationWorks>()
    }
}