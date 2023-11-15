package com.example.rako.util

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject


open class CachePreferencesHelper @Inject constructor(context: Context) {

    companion object {
        private const val PREF_PACKAGE_NAME = "com.example.rako.cache.preferences"

        private const val PREF_KEY_ACCESS_TOKEN = "accessToken"


    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)

    var accessToken: String
        get() = preferences.getString(PREF_KEY_ACCESS_TOKEN, "").toString()
        set(token) = preferences.edit().putString(PREF_KEY_ACCESS_TOKEN, token).apply()


}