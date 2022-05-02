package com.example.umbrella.model.network

import com.example.umbrella.model.RootObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//api.openweathermap.org/data/2.5/forecast?
//zip=30339&appid=be86437005730e43c12367ba8b8077a8&units=metric
interface IWeatherAPI {
    @GET(END_POINT_WEATHER)
    suspend fun getAllInfo(
        @Query(PARAM_WEATHER_ZIP) Zip:String,
        @Query(PARAM_WEATHER_APPID) appid:String,
        @Query(PARAM_WEATHER_UNITS) units:String

    ): Response<RootObject>
}




