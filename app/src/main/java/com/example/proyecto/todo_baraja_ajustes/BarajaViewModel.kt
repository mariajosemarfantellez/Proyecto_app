package com.example.proyecto.todo_baraja_ajustes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.todo_salas.Rooms

class BarajaViewModel (application: Application) : AndroidViewModel(application) {

    val myCases =  MutableLiveData<MutableList<Rooms>>()
    val contexto = application.baseContext
    val Standard = listOf<String>("0","1/2","1","2","3","5","8","13","20","40","100","∞","?","CAFE")
    val T_Shirt = listOf<String>("XS","S","M","L","XL","XXL","?","CAFE")
    val Fibonacci = listOf<String>("0","1","2","3","5","8","13","21","34","55","89","144","∞","?","CAFE")
    val Hours = listOf<String>("0","1","2","3","4","6","8","12","16","24","32","40","?","CAFE")
    var posicion : Int = 0

    init {



    }




}