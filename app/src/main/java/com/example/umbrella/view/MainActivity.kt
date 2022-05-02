package com.example.umbrella.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.umbrella.R
import com.example.umbrella.databinding.ActivityMainBinding
import com.example.umbrella.model.ThreadObjects
import com.example.umbrella.model.network.API_VALUE_TEMP_FAHRENHEIT
import com.example.umbrella.packages.Helpers
import com.example.umbrella.viewmodel.WeatherViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding : ActivityMainBinding
  private val weatherViewModel : WeatherViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
                  
        //ThreadObjects.ScaleMesure = API_VALUE_TEMP_FAHRENHEIT

           weatherViewModel.onCreate()

        weatherViewModel.weatherModel.observe(this, Observer { currentItem->
            var temperature :String =currentItem.listItems[1].mainObject.temp
            binding.tvTemperature.text="$temperature °"
            binding.tvPlace.text=currentItem.City.name
            binding.tvSky.text=currentItem.listItems[1].weather[0].description
            var icon :String =currentItem.listItems[1].weather[0].icon
            Picasso.get().load("https://openweathermap.org/img/wn/" + icon + ".png").into(binding.ivImageWeather)

             var listGroupedByDate = currentItem.listItems.groupBy { m -> m.txt.substring(0,10) }

            var today = listGroupedByDate.toList().find{
            a->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    a.first.equals(Helpers.getCurrentDate())
                } else {
                    TODO("VERSION.SDK_INT < O")
                }
            }

            if (today != null) {
                Log.d(TAG, "today no null ${today.second}")

                binding.rvWeather.layoutManager = GridLayoutManager(this, 3)
                binding.rvWeather.adapter =  WeatherItemAdapter(today.second, this@MainActivity)


            }

            var tomorrow = listGroupedByDate.toList().find{
                    a->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    a.first.equals(Helpers.getPlusDate(1))
                } else {
                    TODO("VERSION.SDK_INT < O")
                }
            }

            if (tomorrow != null) {

                binding.rvWeatherTomorrow.layoutManager = GridLayoutManager(this, 3)
                binding.rvWeatherTomorrow.adapter =  WeatherItemAdapter(tomorrow.second, this@MainActivity)

//                WeatherItemAdapter(tomorrow.second, this@MainActivity)
//                    .apply{
//                        Log.d(TAG, "onCreateTomorrow: $this")
//                        binding.rvWeatherTomorrow.configRecycler(this)
//                        binding.llWeatherForecast.visibility = View.VISIBLE
//                    }
            }
            binding.imbSettings.setOnClickListener {
                val intent :Intent = Intent(this, WeatherSettingsActivity::class.java)
                startActivity(intent)
            }

            binding.swipeRefreshLayoutMain.setOnRefreshListener {
                weatherViewModel.onCreate()
            }

            if(Helpers.IsHot(temperature))
            {
                binding.headerItem.setBackgroundResource(R.color.orange_hot)
            }else{
                binding.headerItem.setBackgroundResource(R.color.blue_cold)
            }
        })

        weatherViewModel.isLoading.observe(this, Observer { binding.progress.isVisible=it })

    }


}

private fun RecyclerView.configRecycler(weatherItemAdapter: WeatherItemAdapter) {
    this.layoutManager = GridLayoutManager(this.context, 3)
    this.adapter = adapter
}
