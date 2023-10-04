package com.lahaus.iterable_flutter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.RemoteMessage
import com.iterable.iterableapi.IterableFirebaseMessagingService

class IterablePushReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "Received push notification")

        context ?: return

        val dataBundle = intent?.extras ?: return
        val remoteMessage = RemoteMessage(dataBundle)

        IterableFirebaseMessagingService.handleMessageReceived(context, remoteMessage)
    }

    companion object {
        private const val TAG = "IterablePushReceiver"
    }
}