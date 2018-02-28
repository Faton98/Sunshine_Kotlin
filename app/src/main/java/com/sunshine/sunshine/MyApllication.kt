package com.sunshine.sunshine

import android.app.Application
import android.content.pm.ApplicationInfo
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Faton on 03/02/2018.
 */
class MyApllication : Application() {
    companion object {
        lateinit var api:API
    }
    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(API::class.java)

    }
}