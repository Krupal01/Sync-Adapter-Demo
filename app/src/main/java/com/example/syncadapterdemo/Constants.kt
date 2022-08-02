package com.example.syncadapterdemo

import android.net.Uri

const val TAG = "TAG"
const val AUTHORITIES =  "com.example.syncadapterdemo.DataContentProvider"
const val ACCOUNT_TYPE = "example.com"
const val ACCOUNT = "placeholderaccount"

const val SECONDS_PER_MINUTE = 60L
const val SYNC_INTERVAL_IN_MINUTES = 60L
const val SYNC_INTERVAL = SYNC_INTERVAL_IN_MINUTES * SECONDS_PER_MINUTE