package com.example.umbrella.model.network


public const val API_VALUE="be86437005730e43c12367ba8b8077a8"

//api.openweathermap.org/data/2.5/forecast?zip=30339,us&appid=be86437005730e43c12367ba8b8077a8&units=metric
//api.openweathermap.org/data/2.5/forecast?zip=30339&appid=be86437005730e43c12367ba8b8077a8&units=metric
const val BASE_URL_WEATHER = "https://api.openweathermap.org/data/2.5/"
const val END_POINT_WEATHER = "forecast?"

const val API_VALUE_TEMP_CELSIUS="metric"
const val API_VALUE_TEMP_FAHRENHEIT="imperial"
const val API_VALUE_TEMP_Kelvin=""

const val PARAM_WEATHER_ZIP="zip"
const val PARAM_WEATHER_APPID="appid"
const val PARAM_WEATHER_UNITS="units"




/*
* Temperature is available in Fahrenheit, Celsius
* and Kelvin units.
For temperature in Fahrenheit use units=imperial
For temperature in Celsius use units=metric
Temperature in Kelvin is used by default, no need to
* use units parameter in API call
List of all API parameters with units
* openweathermap.org/weather-data
* */

