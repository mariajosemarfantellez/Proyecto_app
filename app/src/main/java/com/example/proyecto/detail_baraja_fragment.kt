package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener


class detail_baraja_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_baraja_fragment, container, false)


        setFragmentResultListener("requestKey_5") { requestKey, bundle ->
            val number = bundle.getString("number")
            val nn = view.findViewById<TextView>(R.id.text_detail_baraja)
            nn.text = number

        }
        val linear = view.findViewById<LinearLayout>(R.id.linear_detail_baraja)
        linear.setOnClickListener() {
            activity?.supportFragmentManager?.popBackStack()
        }
        return view

    }
}



