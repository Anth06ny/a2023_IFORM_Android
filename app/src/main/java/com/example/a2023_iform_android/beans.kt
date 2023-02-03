package com.example.a2023_iform_android

import com.google.gson.annotations.SerializedName
import java.util.*


//Ici je n'ai mis que ce qui est utile pour l'affichage demandé mais on peut tout mettre
data class WeatherBean(
    var name: String,
    @SerializedName("main")
    var temperature: TempBean,
    var wind: WindBean,
    var weather:List<DescriptionBean>,
)

class DescriptionBean(var description:String, var icon :String)

data class TempBean(var temp: Double, var temp_min:Double, var temp_max:Double)
data class WindBean(var speed: Double)

