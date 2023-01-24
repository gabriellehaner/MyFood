package com.example.myfood

import android.net.Uri
import java.io.Serializable

data class Receita(
    val titulo: String,
    val tempo: String,
    val ingredientes: String,
    val mododepreparo: String,
    val foto: Uri?
) : Serializable
