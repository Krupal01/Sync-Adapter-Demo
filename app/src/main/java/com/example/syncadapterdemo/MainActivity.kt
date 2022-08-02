package com.example.syncadapterdemo

import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.syncadapterdemo.ui.theme.SyncAdapterDemoTheme


class MainActivity : ComponentActivity() {

    private lateinit var dataAccount : Account
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataAccount = createSyncAccount()

        setContent {

            SyncAdapterDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier.fillMaxSize()) {
                        Button(onClick = {
                            val bundle = Bundle()
                            bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true)
                            bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true)
                            ContentResolver.requestSync(dataAccount, AUTHORITIES,bundle)
                            Log.i(TAG,"sync click")
                        }) {
                            Text(text = "Sync")
                        }
                    }

                }
            }
        }
    }

    private fun createSyncAccount(): Account {
        val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        Log.i(TAG,"account created")
        return Account(ACCOUNT, ACCOUNT_TYPE).also { newAccount ->
            /*
             * Add the account and account type, no password or user data
             * If successful, return the Account object, otherwise report an error.
             */
            if (accountManager.addAccountExplicitly(newAccount, null, null)) {
                /*
                 * If you don't set android:syncable="true" in
                 * in your <provider> element in the manifest,
                 * then call context.setIsSyncable(account, AUTHORITY, 1)
                 * here.
                 */
            } else {
                /*
                 * The account exists or some other error occurred. Log this, report it,
                 * or handle it internally.
                 */
            }
        }
    }
}



