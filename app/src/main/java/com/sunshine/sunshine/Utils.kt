package com.sunshine.sunshine

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Faton on 04/02/2018.
 */
fun ConvertDatetoDay(date:String?):String?{
    val oldDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val newDate = SimpleDateFormat("EEEE", Locale("id"))
    val day = newDate.format(oldDate.parse(date))
    return day
}
fun getSmallIconWeather(weatherId:Int?):Int {
    return when(weatherId){
        in 200..232, in 900..906,in 958..962,761,771,781 -> R.drawable.ic_storm
        in 300..321 -> R.drawable.ic_light_rain
        in 500..504, in 520..531 -> R.drawable.ic_rain
        511, in 600..602 -> R.drawable.ic_snow
        in 701..761 -> R.drawable.ic_fog
        801         -> R.drawable.ic_light_clouds
        in 802..804 -> R.drawable.ic_cloudy
        in 951..957, 800 -> R.drawable.ic_clear
        else -> R.drawable.ic_storm
    }
}