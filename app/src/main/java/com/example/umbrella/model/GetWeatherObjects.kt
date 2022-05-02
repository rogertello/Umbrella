package com.example.umbrella.model

import com.google.gson.annotations.SerializedName

data class RootObject (
    @SerializedName("cod")val Cod:String,
    @SerializedName("message")val Message:String,
    @SerializedName("city")val City:CityObject,
    @SerializedName("list")val listItems:List<MainObjectList>
        )

data class RootGroup(
    val dateString : String,
    val timeString : String,
    val listMainObjects :List<MainObjectList>
)

/*
data class QuoteModel(@SerializedName("quote")val quote:String,
                     @SerializedName("author")val author:String) {}
 */
data class MainObjectList(
    @SerializedName("main")val mainObject: MainObject,
    @SerializedName("dt")val dt:String,
    @SerializedName("dt_txt")val txt:String,
    @SerializedName("weather")val weather:List<WeatherObject>,
    @SerializedName("cod")val code:String
)

data class WeatherObject(
   @SerializedName("id") var id: Int,//800,
   @SerializedName("main") var main:String,//"Clear",
   @SerializedName("description") var description: String,//"clear sky",
   @SerializedName("icon") var icon:String //"01d"
)

data class MainObject(
    var temp: String,//26.18,
    var feels_like:String,//2 26.18,
    var temp_min: String,//224.87,
    var temp_max: String,//226.18,
    var pressure:String, //21022,
    var sea_level: String,//21022,
    var grnd_level:String, //2992,
    var humidity: String,//246,
    var temp_kf: String//21.31
)

data class CityObject (
    var name: String,//"Atlanta",
//"coord": {
//    "lat": 33.8713,
//    "lon": -84.4629
//},
    var coord:CoordObject,
    var country: String,//"US",
    var timezone: Int,//-14400,
    var sunrise:String,// 1650711439,
    var sunset: String//1650759277
        )

data class CoordObject(
    var lat:String,// 33.8713,
    var lon:String// -84.4629
)
