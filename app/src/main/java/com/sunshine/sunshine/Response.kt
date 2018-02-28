package com.sunshine.sunshine

import android.preference.PreferenceManager
import com.google.gson.annotations.SerializedName
import java.security.MessageDigest

/**
 * Created by Faton on 03/02/2018.
 */

data class ForcastResponse(
        @field:SerializedName("cod")
        val cod:String? = "",
        @field:SerializedName("message")
        val message:String? = "",
        @field:SerializedName("city")
        val city: City? = City(),
        @field:SerializedName("list")
        val resultList:List<ForcastResult>
)
data class ForcastResult(
        @field:SerializedName("main")
        val main:Temp = Temp(),
        @field:SerializedName("weather")
        val weatherList: List<Weather>?= null,
        @field:SerializedName("dt_txt")
        var dt_txt:String? = ""

)
data class City(
        @field:SerializedName("name")
        val name:String? = "",
        @field:SerializedName("country")
        val country:String? = "",
        @field:SerializedName ("id")
        val id:String? = ""
)
data class Temp(
        @field:SerializedName("temp")
        val temp:String? = ""
)
data class Weather(
        @field:SerializedName("id")
        val id:String? = "",
        @field:SerializedName("main")
        val main:String? = "",
        @field:SerializedName("description")
        val description:String? = ""
)