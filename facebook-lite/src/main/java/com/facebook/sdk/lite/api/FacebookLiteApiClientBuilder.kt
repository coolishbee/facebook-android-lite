package com.facebook.sdk.lite.api

import android.app.Activity

class FacebookLiteApiClientBuilder(
    private val activity: Activity
) {
    fun build(): FacebookLiteApiClient {
        return FacebookLiteApiClientImpl(
            activity
        )
    }
}