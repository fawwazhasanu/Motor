package com.fawwaz.motor.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News (
    val id : String = "",
    val nama : String = "",
    val warna   : String = "",
    val deskripsi   : String = "",
    val gambar   : String = ""
) : Parcelable