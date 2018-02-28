package com.sunshine.sunshine

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_forcase.view.*

/**
 * Created by Faton on 03/02/2018.
 */
class AdapterBaru (private val forcaseList: List<ForcastResult>) : RecyclerView.Adapter<AdapterBaru.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view:View = LayoutInflater.from (parent?.context).inflate(R.layout.item_forcase, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return forcaseList.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
       holder?.bind(position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int){
            val forcast:ForcastResult= forcaseList[position]
            if (forcast.weatherList?.isNotEmpty()==true){
                val weather:Weather=forcast.weatherList[0]
                itemView?.b_Today?.text=forcast.dt_txt
                itemView?.b_Cerah2?.text= weather.description
                itemView?.b_Derajat2?.text= "${forcast.main.temp?.toDouble()?.minus(273)?.toInt()}\u00b0"
                val icon:Int= getSmallIconWeather(weather.id?.toInt()?:0)
                itemView.b_View1.setImageDrawable(ContextCompat.getDrawable(itemView.context,icon))

            }
        }
    }
}