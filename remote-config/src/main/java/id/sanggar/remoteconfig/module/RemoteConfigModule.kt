package id.sanggar.remoteconfig.module

import id.sanggar.remoteconfig.RemoteConfig
import id.sanggar.remoteconfig.internal.RemoteConfigImpl

object RemoteConfigModule {

    // singleton
    // TODO: Use dependency injection principles
    fun get(): RemoteConfig {
        return RemoteConfigImpl()
    }

}