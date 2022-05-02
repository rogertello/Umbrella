package com.example.umbrella.packages

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.umbrella.model.ThreadObjects
import com.example.umbrella.model.network.API_VALUE_TEMP_CELSIUS
import com.example.umbrella.model.network.API_VALUE_TEMP_FAHRENHEIT
import com.example.umbrella.model.network.API_VALUE_TEMP_Kelvin
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object Helpers
{
    public fun IsHot(Temp:String) :Boolean
    {
        var returner:Boolean = false;
        var iTemp = Temp.toDouble().toInt()
        when (ThreadObjects.ScaleMesure) {
            API_VALUE_TEMP_CELSIUS -> {
                if(iTemp >20){returner=true}
            }
            API_VALUE_TEMP_FAHRENHEIT-> {
                if(iTemp >68){returner=true}
            }
            API_VALUE_TEMP_Kelvin ->{
                if(iTemp >293){returner=true}
            }
            else -> { // Note the block
                //do nothing
            }
        }

        return returner
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDate(): String {

       val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return current.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getPlusDate(addDays : Int): String {

        val current = LocalDateTime.now().plusDays(addDays.toLong())
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return current.format(formatter)
    }

    public fun formatHour(input: String): String? {

        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val outputformat: DateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm a")
        val date: Date?
        var output: String? = null
        try {
            date = df.parse(input)
            output = outputformat.format(date)
            println(output)
        } catch (pe: ParseException) {
            pe.printStackTrace()
        }
        return output
    }

}