package com.example.proyecto.todo_salas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.proyecto.R


class crear_salas_fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crear_salas_fragment, container, false)
        val name = view.findViewById<EditText>(R.id.new_room_name)
        val password = view.findViewById<EditText>(R.id.new_room_password)

        val guardar_button = view.findViewById<Button>(R.id.button_guardar)
        guardar_button.setOnClickListener() {
            setFragmentResult("requestKey", bundleOf("password" to password.getText().toString(), "name" to name.getText().toString()) )
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }

}