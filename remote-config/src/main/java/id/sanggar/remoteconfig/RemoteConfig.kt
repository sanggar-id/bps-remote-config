package id.sanggar.remoteconfig

interface RemoteConfig {

    fun getBoolean(key: String): Boolean

    fun getBoolean(key: String, defaultValue: Boolean): Boolean

    fun getString(key: String): String

    fun getString(key: String, defaultValue: String): String

    // cukup di call sekali, bisa dilakukan di Application class
    fun fetch(listener: Listener)

    interface Listener {
        fun onCompleted(config: RemoteConfig)
        fun onError(t: Throwable)
    }

}