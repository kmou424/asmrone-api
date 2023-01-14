package moe.kmou424.asmrone.api.exception

class AccessTokenNotFoundException : RuntimeException() {
    override fun toString(): String {
        return super.toString() + " -> " + " You should login at first or set accessToken manually"
    }
}