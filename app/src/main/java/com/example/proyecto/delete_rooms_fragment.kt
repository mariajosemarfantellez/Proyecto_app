package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener


class delete_rooms_fragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_delete_rooms_fragment, container, false)
        setFragmentResultListener("requestKey_1") { requestKey, bundle ->
            val name = bundle.getString("name")
            val password = bundle.getString("password")
            val position = bundle.getInt("position")
            val nn = view.findViewById<TextView>(R.id.name_delete)
            nn.text = name
            val button = view.findViewById<Button>(R.id.button_delete)
            button.setOnClickListener(){
                setFragmentResult("requestKey_2", bundleOf("name" to name, "password" to password, "position" to position) )
                activity?.supportFragmentManager?.commit {
                    this.replace(R.id.fragment_container,salas_fragment())
                    this.addToBackStack(null)
                }
                //activity?.supportFragmentManager?.popBackStack()
            }
        }

        return view
    }

}