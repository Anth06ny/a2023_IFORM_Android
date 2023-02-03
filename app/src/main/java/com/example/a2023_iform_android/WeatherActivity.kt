package com.example.a2023_iform_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.a2023_iform_android.databinding.ActivityMainBinding
import com.example.a2023_iform_android.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    //Créer l'IHM
    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {
            binding.tvError.isVisible = false
            binding.progressBar.isVisible = true

            thread {
                try {
                    val weather = RequestUtils.loadWeather("Toulouse")

                    runOnUiThread {
                        binding.tv.setText(weather.name)
                        binding.tvWind.setText("${weather.wind.speed}")
                        binding.tvTemp.text = "${weather.temperature.temp}°"
                        binding.tvMinMax.text = "(${weather.temperature.temp_min}°/${weather.temperature.temp_max}°)"
                        binding.progressBar.isVisible = false

                        if(weather.weather.isNotEmpty()) {
                            binding.tvDesc.text = weather.weather.get(0).description
                            Picasso.get().load("https://openweathermap.org/img/wn/${weather.weather.get(0).icon}@4x.png").into(binding.ivTemp)
                        }
                        else {
                            binding.tvDesc.text = "-"
                        }
                    }
                }
                catch (e: Exception) {
                    e.printStackTrace()
                    runOnUiThread {
                        binding.tvError.isVisible = true
                        binding.tvError.setText("Une erreur est survenue : ${e.message}")
                        binding.progressBar.isVisible = false
                    }
                }
            }

        }
    }
}