 package com.sunshine.sunshine

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.e
import android.util.Log.i
import android.widget.LinearLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class MainActivity : AppCompatActivity() {

     private val tag=this::class.java.simpleName
     private val ForcastList= mutableListOf<ForcastResult>()
     private lateinit var adapter:AdapterBaru

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter= AdapterBaru(ForcastList)
        rView.layoutManager=LinearLayoutManager(this)
        rView.adapter=adapter
        getData()
    }
private fun getData(){
    MyApllication.api.forcastCall().enqueue(object : Callback<ForcastResponse>{
        override fun onFailure(call: Call<ForcastResponse>?, t: Throwable?) {
            e(tag,"eerror=${t?.message}")
        }

        @SuppressLint("SetTextI18n")
        override fun onResponse(call: Call<ForcastResponse>?, response: Response<ForcastResponse>?) {
           i(tag, "data= ${Gson().toJsonTree(response?.body())}")
            val newForcastList=response?.body()?.resultList
            val newCity=response?.body()?.city?.name
            val country=response?.body()?.city?.country
            bKota.text="${newCity}, ${country}"
            newForcastList?.map {
                it.dt_txt= ConvertDatetoDay(it.dt_txt)
                }
            displayCurrentForcast(newForcastList?.get(0))

            newForcastList?.distinctBy { it.dt_txt }?.let {
                ForcastList.addAll(it)
                ForcastList.removeAt(0)
                adapter.notifyDataSetChanged()
            }
        }
    @SuppressLint("SetTextI18n")
    private fun displayCurrentForcast(forcast: ForcastResult?){
        bDate.text = "Hari ini"
        bDerajat.text = "${forcast?.main?.temp?.toDouble()?.toInt()?.minus(273)?.toString()}\u00b0"
        bCerah.text= forcast?.weatherList?.get(0)?.description
        val icon =  getSmallIconWeather(forcast?.weatherList?.get(0)?.id?.toInt()?:0)
        imgCerah.setImageDrawable(ContextCompat.getDrawable(this@MainActivity, icon))

    }

    })

}

}
