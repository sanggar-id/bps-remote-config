package id.sanggar.remoteconfig.internal

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import id.sanggar.remoteconfig.R
import id.sanggar.remoteconfig.RemoteConfig
import java.util.concurrent.TimeUnit

internal class RemoteConfigImpl : RemoteConfig {

    private val firebaseRemoteConfig by lazy {
        FirebaseRemoteConfig.getInstance()
    }

    override fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        val value = firebaseRemoteConfig.getString(key)

        return if (value.isNotEmpty()) value.toBoolean() else defaultValue
    }

    override fun getString(key: String): String {
        return getString(key, "")
    }

    override fun getString(key: String, defaultValue: String): String {
        val value = firebaseRemoteConfig.getString(key)

        return if (value.isNotEmpty()) value else defaultValue
    }

    override fun fetch(listener: RemoteConfig.Listener) {
        firebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        val settings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(ONE_MINUTES_EXPIRATION)
            .build()

        firebaseRemoteConfig.setConfigSettingsAsync(settings)

        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener {
                listener.onCompleted(this)
            }
            .addOnFailureListener {
                listener.onError(it)
            }
    }

    companion object {
        private val ONE_MINUTES_EXPIRATION = TimeUnit.MINUTES.toSeconds(1)
    }

}