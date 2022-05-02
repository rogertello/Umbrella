package com.example.umbrella.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.umbrella.model.RootObject
import com.example.umbrella.model.ThreadObjects
import com.example.umbrella.model.domain.GetWeatherUseCase
import com.example.umbrella.model.network.API_VALUE
import com.example.umbrella.model.network.API_VALUE_TEMP_CELSIUS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "WeatherViewModel"
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeather :GetWeatherUseCase
):ViewModel(){

    val weatherModel = MutableLiveData<RootObject>()
    val isLoading =MutableLiveData<Boolean>()

    fun onCreate(){
        Log.d(TAG, "onCreate: Iniciado")
        viewModelScope.launch{
            isLoading.postValue(true)
          //  val result = getWeather("30339",API_VALUE, API_VALUE_TEMP_CELSIUS)
            val result = getWeather(ThreadObjects.ZipCode,API_VALUE, ThreadObjects.ScaleMesure)
            val countITems = result?.listItems?.count()
            val scaleMssure=ThreadObjects.ScaleMesure
            val zcode=ThreadObjects.ZipCode
            Log.d(TAG, "onCreate: Scale mesure $scaleMssure ")
            Log.d(TAG, "onCreate: Scale mesure $zcode ")
                weatherModel.postValue(result!!)
                isLoading.postValue(false)

        }
    }
}