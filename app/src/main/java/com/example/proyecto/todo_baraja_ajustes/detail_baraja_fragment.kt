package com.example.proyecto.todo_baraja_ajustes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.example.proyecto.R


class detail_baraja_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_baraja_fragment, container, false)


        setFragmentResultListener("requestKey_5") { requestKey, bundle ->
            val number = bundle.getString("number")
            val nn = view.findViewById<TextView>(R.id.text_detail_baraja)
            val image = view.findViewById<ImageView>(R.id.imageView)
            if (number == "CAFE"){
                nn.text = ""
                image.setVisibility(View.VISIBLE)
            }
            else{
                image.setVisibility(View.INVISIBLE)
                nn.text = number
            }


        }
        val linear = view.findViewById<RelativeLayout>(R.id.linear_detail_baraja)
        linear.setOnClickListener() {
            activity?.supportFragmentManager?.popBackStack()
        }
        return view

    }
}



