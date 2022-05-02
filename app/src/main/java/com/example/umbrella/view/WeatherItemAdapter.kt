package com.example.umbrella.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrella.databinding.WeatherControlItemListBinding
import com.example.umbrella.databinding.WeatherControlItemdayListBinding
import com.example.umbrella.model.MainObjectList
import com.example.umbrella.packages.Helpers
import com.squareup.picasso.Picasso

class WeatherItemAdapter (private val items: List<MainObjectList>, val context: Context) :
    RecyclerView.Adapter< WeatherItemAdapter.BooksViewHolder>(){


    class BooksViewHolder(val binding: WeatherControlItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            WeatherControlItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        try {
            holder.binding.tvTemp.text = items[position].mainObject.temp.toDouble().toInt().toString() + "°"
            Picasso.get().load("https://openweathermap.org/img/wn/" + items[position].weather[0].icon + ".png").into(holder.binding.ivIconWeather)
            holder.binding.tvTime.text = Helpers.formatHour(items[position].txt)?.substring(11)
        } catch (e: Exception) {
            //context.toast(e.toString())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}