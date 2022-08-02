package com.example.syncadapterdemo

import android.accounts.Account
import android.content.*
import android.os.Bundle
import android.util.Log

class DataSyncAdapter(
    context: Context,
    autoInitialize : Boolean,
    allowParallelSyncs : Boolean = false,
    private val contentResolver: ContentResolver? = context.contentResolver
) : AbstractThreadedSyncAdapter(context, autoInitialize, allowParallelSyncs) {

    override fun onPerformSync(
        p0: Account?,
        p1: Bundle?,
        p2: String?,
        p3: ContentProviderClient?,
        p4: SyncResult?
    ) {
        Log.i(TAG , "${p0?.name} sync perform")
    }
}