package com.example.umbrella.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.inflate
import androidx.appcompat.app.AppCompatActivity
import com.example.umbrella.R
import android.content.Intent
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.example.umbrella.model.MainObjectList
import com.example.umbrella.model.ThreadObjects
import com.example.umbrella.model.network.API_VALUE_TEMP_CELSIUS
import com.example.umbrella.model.network.API_VALUE_TEMP_FAHRENHEIT
import com.example.umbrella.model.network.API_VALUE_TEMP_Kelvin


class WeatherSettingsActivity : AppCompatActivity() {
    private lateinit var binding : WeatherSettingsActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_settings)

        val cZip = findViewById<TextView>(R.id.tb_ZipCode)
        val cCelcius = findViewById<RadioButton>(R.id.rb_Celcius)
        val cFarenheit = findViewById<RadioButton>(R.id.rb_Farenheith)
        val cKelvin = findViewById<RadioButton>(R.id.rb_Kelvin)

        val btn =findViewById<Button>(R.id.btnSetReturn)
        cZip.text = ThreadObjects.ZipCode

        when (ThreadObjects.ScaleMesure){
            API_VALUE_TEMP_CELSIUS ->{
                                        cCelcius.isSelected=true
                                        cFarenheit.isSelected=false
                                        cKelvin.isSelected=false
                                    }
            API_VALUE_TEMP_FAHRENHEIT ->{
                                        cCelcius.isSelected=false
                                        cFarenheit.isSelected=true
                                        cKelvin.isSelected=false
                                    }
            API_VALUE_TEMP_Kelvin ->{
                                    cCelcius.isSelected=false
                                    cFarenheit.isSelected=false
                                    cKelvin.isSelected=true
                                }
            else->{
                    cCelcius.isSelected=false
                    cFarenheit.isSelected=false
                    cKelvin.isSelected=true
                    }
        }


        btn.setOnClickListener {

            ThreadObjects.ZipCode = cZip.text.toString()

            if(cCelcius.isSelected)
            {
                ThreadObjects.ScaleMesure=API_VALUE_TEMP_CELSIUS
            }
            else if(cFarenheit.isSelected)
            {
                ThreadObjects.ScaleMesure= API_VALUE_TEMP_FAHRENHEIT
            }
            else{
                ThreadObjects.ScaleMesure=API_VALUE_TEMP_Kelvin
            }

            val intent :Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}