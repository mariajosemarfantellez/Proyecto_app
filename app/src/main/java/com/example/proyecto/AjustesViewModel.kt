package com.example.proyecto

import android.app.Application
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.lifecycle.AndroidViewModel
import java.util.ArrayList

class AjustesViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var elementos : ArrayList<String>

    init{
        elementos.add("Standard")
        elementos.add("T-Shirt")
        elementos.add("Fibonacci")
        elementos.add("Hours")
    }
}