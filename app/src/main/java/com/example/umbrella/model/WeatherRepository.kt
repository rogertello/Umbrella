package com.example.umbrella.model

import com.example.umbrella.model.network.WeatherAPIService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api : WeatherAPIService) {

    suspend fun getAllData(
        Zip:String,
        appid:String,
        units:String
    ):RootObject{
        val response : RootObject = api.getAllInfo(Zip,appid,units)
        return response
    }

}