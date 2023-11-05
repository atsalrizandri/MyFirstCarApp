package com.atsalaja.myfirstcarapp.car

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    var name: String = "",
    var description: String = "",
    var image: Int = 0,
    var transmisi: String = "",
    var bbm: String = "",
    var cc: String = ""
) : Parcelable
