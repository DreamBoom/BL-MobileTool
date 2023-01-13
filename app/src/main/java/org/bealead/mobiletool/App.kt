package org.bealead.mobiletool

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp
import org.bealead.mobiletool.work.CheckBaseUrlWork
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree());
        }
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}