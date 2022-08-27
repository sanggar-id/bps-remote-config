package id.sanggar.bpsabtesting

import android.app.Application
import id.sanggar.remoteconfig.RemoteConfig
import id.sanggar.remoteconfig.module.RemoteConfigModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // fetching remote config on firebase
        RemoteConfigModule
            .get()
            .fetch(object : RemoteConfig.Listener {
                override fun onCompleted(config: RemoteConfig) {}
                override fun onError(t: Throwable) {}
            })
    }

}