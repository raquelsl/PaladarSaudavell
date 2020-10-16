package com.raqs.paladarsaudvel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*
@Parcelize
data class Receita(

    val NomeReceita: String,
    val NomeIgredientes: String,
    val ModoPreparo: String

): Parcelable