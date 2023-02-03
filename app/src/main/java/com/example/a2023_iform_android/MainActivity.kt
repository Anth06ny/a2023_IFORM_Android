package com.example.a2023_iform_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a2023_iform_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Créer l'IHM
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Affiche
        setContentView(binding.root)

        binding.btValidate.setOnClickListener {

            if(binding.rbLike.isChecked) {
                binding.et.setText(binding.rbLike.text)
            }
            else if(binding.rbDislike.isChecked) {
                binding.et.setText(binding.rbDislike.text)
            }

            binding.iv.setImageResource(R.drawable.baseline_delete_24)
        }

        binding.btCancel.setOnClickListener {
            binding.et.setText("")
            binding.rg.clearCheck()
            binding.iv.setImageResource(R.drawable.baseline_flag_24)
        }

        binding.btWeather.setOnClickListener {
            startActivity(Intent(this, WeatherActivity::class.java))
        }
    }

}