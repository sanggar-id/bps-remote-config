package id.sanggar.bpsabtesting

import android.app.Application
import android.util.Log
import id.sanggar.remoteconfig.RemoteConfig
import id.sanggar.remoteconfig.module.RemoteConfigModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // fetching remote config on firebase
        RemoteConfigModule
            .get()
            .fetch(object : RemoteConfig.Listener {
                override fun onCompleted(config: RemoteConfig) {
                    Log.d("BPS Testing", "firebase remote config is fetched")
                }
                override fun onError(t: Throwable) {
                    Log.d("BPS Testing", "yah gagal nih!")
                }
            })
    }

}