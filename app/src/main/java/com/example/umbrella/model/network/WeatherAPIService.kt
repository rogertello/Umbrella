package com.example.umbrella.model.network


import com.example.umbrella.model.RootObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class WeatherAPIService @Inject constructor(private val api :IWeatherAPI) {

    suspend fun getAllInfo(
        Zip:String,
        appid:String,
        units:String
    ):RootObject{
        return withContext(Dispatchers.IO)
        {
            val response : Response<RootObject> = api.getAllInfo(Zip,appid,units)
           response.body()!!
            // response.body()?: emptyList()
//            if( response.body()!= null){
//                response.body()!!
//            }else
//            {
//return null
//            }
        }
    }
}