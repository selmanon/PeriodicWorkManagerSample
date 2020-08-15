package com.jetbrains.handson.periodicworker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestingWorker(context: Context, parameters: WorkerParameters): Worker(context, parameters){
    override fun doWork(): Result {
        Log.i("CheckWorker","I will retry!")
        return Result.retry()
    }
}
