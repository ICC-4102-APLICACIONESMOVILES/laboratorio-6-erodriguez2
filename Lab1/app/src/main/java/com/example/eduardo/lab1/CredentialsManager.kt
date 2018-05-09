package com.example.eduardo.lab1

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.R.id.edit
import android.content.SharedPreferences



class CredentialsManager(context: Context){

    private val PREFERENCES_NAME = "SharedPreferencesFile"
    private val PREFERENCES_EMAIL_FIELD = "userEmail"
    private val PREFERENCES_PASSWORD_FIELD = "userPassword"
    private val PREFERECES_TOKEN = "userToken"
    private val DEFAULT_VALUE = ""
    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun getEmail(): String{
        return preferences.getString(PREFERENCES_EMAIL_FIELD, DEFAULT_VALUE)
    }

    fun getPassword(): String{
        return preferences.getString(PREFERENCES_PASSWORD_FIELD, DEFAULT_VALUE)
    }

    fun getToken() : String{
        return preferences.getString(PREFERECES_TOKEN, DEFAULT_VALUE)
    }

    fun setEmail(newEmail: String){
        val editor = preferences.edit()
        editor.putString(PREFERENCES_EMAIL_FIELD, newEmail)
        editor.apply()
    }

    fun setPassword(newPassword: String){
        val editor = preferences.edit()
        editor.putString(PREFERENCES_PASSWORD_FIELD, newPassword)
        editor.apply()
    }

    fun setToken(newToken: String){
        val editor = preferences.edit()
        editor.putString(PREFERECES_TOKEN, newToken)
        editor.apply()
    }
}