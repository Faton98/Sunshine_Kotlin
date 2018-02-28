package com.sunshine.sunshine


import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Faton on 03/02/2018.
 */
interface API {
    @GET("forecast?id=1621177&appid=5dd8ed28eee2932234d8770b8a2edc67")
    fun forcastCall(): Call<ForcastResponse>
}