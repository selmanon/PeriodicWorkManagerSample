package com.jetbrains.handson.periodicworker

import android.app.Application
import androidx.work.Configuration

class PeriodicWorker : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .build()


}