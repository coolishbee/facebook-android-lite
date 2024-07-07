package com.facebook.sdk.lite.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FacebookProfile(
    val userID: String?,
    val idToken: String?,
    val displayName: String?,
    val photoURL: String?,
    val email: String?,
    val authCode: String?
): Parcelable
