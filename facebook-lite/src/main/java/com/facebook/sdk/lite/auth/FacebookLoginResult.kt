package com.facebook.sdk.lite.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FacebookLoginResult(
    var fbProfile: FacebookProfile?
): Parcelable {
    companion object {

    }

    data class Builder(
        var fbProfile: FacebookProfile? = null

    ){
        fun fbProfile(fbProfile: FacebookProfile?) = apply {
            this.fbProfile = fbProfile
        }
        fun build() = FacebookLoginResult(fbProfile)
    }
}