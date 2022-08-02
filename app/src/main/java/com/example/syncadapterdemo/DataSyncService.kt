package com.example.syncadapterdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class DataSyncService : Service() {

    override fun onCreate() {
        super.onCreate()
        synchronized(dataSyncAdapterLock){
            Log.i(TAG,"sync service created")
            dataSyncAdapter = dataSyncAdapter ?: DataSyncAdapter(applicationContext,true)
        }
    }

    override fun onBind(p0: Intent?): IBinder {
        Log.i(TAG,"sync service bind")
        return dataSyncAdapter?.syncAdapterBinder ?: throw IllegalStateException()
    }

    companion object{
        private var dataSyncAdapter: DataSyncAdapter? = null
        private val dataSyncAdapterLock = Any()
    }
}