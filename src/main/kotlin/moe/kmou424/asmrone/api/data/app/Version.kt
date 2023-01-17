package moe.kmou424.asmrone.api.data.app

import com.fasterxml.jackson.annotation.JsonProperty

data class Version(
    val current: String,
    @JsonProperty("latest_release")
    val latestRelease: String,
    @JsonProperty("latest_stable")
    val latestStable: String,
    val lockFileExists: Boolean,
    val lockReason: String?,
    val notifyUser: Boolean,
    @JsonProperty("update_available")
    val updateAvailable: Boolean
) {
    override fun toString(): String {
        return "VersionData(current='$current', latestRelease='$latestRelease', latestStable='$latestStable', lockFileExists=$lockFileExists, lockReason=$lockReason, notifyUser=$notifyUser, updateAvailable=$updateAvailable)"
    }
}
