package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ajustes_fragment : Fragment() {
    private val viewModel: AjustesViewModel by viewModels()
    lateinit var adapter : AdapterView<Adapter>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ajustes_fragment, container, false)
        // Inflate the layout for this fragment
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val eleccion = spinner.getSelectedItem().toString()
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
                //pos me da la posicion de el seleccionado
                //item me da el nombre del seleccionado
                //luego enviar la informacion del seleccionado al fragmento de barajas
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        return view
    }

}