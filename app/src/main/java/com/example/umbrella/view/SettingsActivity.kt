package com.example.umbrella.view

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.inflate
import androidx.appcompat.app.AppCompatActivity
import com.example.umbrella.R
import android.content.Intent
import android.view.View
import android.widget.*
import com.example.umbrella.model.MainObjectList
import com.example.umbrella.model.ThreadObjects
import com.example.umbrella.model.network.API_VALUE_TEMP_CELSIUS
import com.example.umbrella.model.network.API_VALUE_TEMP_FAHRENHEIT
import com.example.umbrella.model.network.API_VALUE_TEMP_Kelvin


class WeatherSettingsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding : WeatherSettingsActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_settings)

        var listScales = listOf<String>("Celsius", "Farenheith", "Kelvin")
        val cZip = findViewById<TextView>(R.id.tb_ZipCode)
        val spinnerScale = findViewById<Spinner>(R.id.spinner_scale)

        val adap: ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_spinner_item,  listScales )

        spinnerScale.adapter=adap
        spinnerScale .onItemSelectedListener = this

        val btn =findViewById<Button>(R.id.btnSetReturn)
        cZip.text = ThreadObjects.ZipCode

        when (ThreadObjects.ScaleMesure){
            API_VALUE_TEMP_CELSIUS ->{
                spinnerScale.setSelection(0)
            }
            API_VALUE_TEMP_FAHRENHEIT ->{
                spinnerScale.setSelection(1)
            }
            API_VALUE_TEMP_Kelvin ->{
                spinnerScale.setSelection(2)
            }
            else->{
                spinnerScale.setSelection(0)
                ThreadObjects.ScaleMesure=API_VALUE_TEMP_CELSIUS
            }
        }

        btn.setOnClickListener {

            ThreadObjects.ZipCode = cZip.text.toString()
            var posDDL =spinnerScale.selectedItemPosition

            when(posDDL)
            {
                0->{
                    ThreadObjects.ScaleMesure=API_VALUE_TEMP_CELSIUS
                }
                1->{
                    ThreadObjects.ScaleMesure= API_VALUE_TEMP_FAHRENHEIT
                }
                2->{
                    ThreadObjects.ScaleMesure= API_VALUE_TEMP_Kelvin
                }
                else->{
                    ThreadObjects.ScaleMesure=API_VALUE_TEMP_CELSIUS
                }
            }

            val intent :Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
       // TODO("Not yet implemented")
    }
}