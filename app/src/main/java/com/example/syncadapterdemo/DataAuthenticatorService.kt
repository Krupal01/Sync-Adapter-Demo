package com.example.syncadapterdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class DataAuthenticatorService : Service() {

    private lateinit var mAuthenticator: DataAuthenticator

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"authenticator service created")
        mAuthenticator = DataAuthenticator(this)
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.i(TAG,"authenticator service bind")
        return mAuthenticator.iBinder
    }
}