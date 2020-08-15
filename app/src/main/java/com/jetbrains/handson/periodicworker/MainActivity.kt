package com.jetbrains.handson.periodicworker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // provide custom configuration
        val myConfig = Configuration.Builder()
                .setMinimumLoggingLevel(android.util.Log.DEBUG)
                .build()

        // initialize WorkManager
        WorkManager.initialize(this, myConfig)

        val constraints: Constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        val recurringWork: PeriodicWorkRequest =
                PeriodicWorkRequest.Builder(TestingWorker::class.java,
                        1,
                        TimeUnit.MINUTES).setConstraints(constraints).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork("12312ds", ExistingPeriodicWorkPolicy.KEEP, recurringWork);
    }
}