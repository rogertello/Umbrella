package com.example.umbrella.model.domain

import com.example.umbrella.model.RootObject
import com.example.umbrella.model.WeatherRepository
import javax.inject.Inject

//
class GetWeatherUseCase  @Inject constructor (private val repository : WeatherRepository){
suspend operator fun invoke(zipCode : String, appId:String, units : String) : RootObject?=repository.getAllData(zipCode,appId,units)
    //this.zipCode,this.appId,this.units
}