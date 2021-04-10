package net.alerok.motivation.infra

import android.content.Context

class SecurityPreferences(val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {

        // ?: will check if sharedPreferences.getString(key, "") is null, if it is, it will return ""
        return sharedPreferences.getString(key, "") ?: ""
    }
}
