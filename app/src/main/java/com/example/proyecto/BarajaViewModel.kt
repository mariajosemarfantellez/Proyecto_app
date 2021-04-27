package com.example.proyecto

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class BarajaViewModel (application: Application) : AndroidViewModel(application) {
    val myCases =  MutableLiveData<MutableList<Rooms>>()
    val contexto = application.baseContext
    val Standard = listOf<String>("0","1/2","1","2","3","5","8","13","20","40","100","∞","?","Coffee")
    val T_Shirt = listOf<String>("XS","S","M","L","XL","XXL","?","Coffee")
    val Fibonacci = listOf<String>("0","1","2","3","5","8","13","21","34","55","89","144","∞","?","Coffee")
    val Hours = listOf<String>("0","1","2","3","4","6","8","12","16","24","32","40","?","Coffee")

    init {



    }




}