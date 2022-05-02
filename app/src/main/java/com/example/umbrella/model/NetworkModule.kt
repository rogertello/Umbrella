package com.example.umbrella.model

import com.example.umbrella.model.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton




@Module
@InstallIn(SingletonComponent::class)
object NetworkModule
{
    @Provides
    @Singleton
    fun provideWeatherClient(retrofitObject:Retrofit):IWeatherAPI
    {
        return retrofitObject.create(IWeatherAPI::class.java)

    }

    @Provides
    @Singleton
    @GET(END_POINT_WEATHER)
    fun provideRetrofit(
       //@Query(PARAM_WEATHER_ZIP)  Zip:String,
       //@Query(PARAM_WEATHER_APPID) appid:String,
       //@Query(PARAM_WEATHER_UNITS) units:String
    ):Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}