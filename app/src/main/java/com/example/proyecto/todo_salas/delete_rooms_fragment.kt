package com.example.proyecto.todo_salas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import com.example.proyecto.R


class delete_rooms_fragment : Fragment() {

    private val viewModel: SalasViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_delete_rooms_fragment, container, false)
        setFragmentResultListener("requestKey_1") { requestKey, bundle ->
            val room = bundle.get("room")
            val name = bundle.getString("name")

            val nn = view.findViewById<TextView>(R.id.name_delete)
            nn.text = name
            val button = view.findViewById<Button>(R.id.button_delete)
            button.setOnClickListener(){
                if(viewModel.rooms.contains(room)){
                    viewModel.rooms.remove((room))
                    viewModel.myCases.postValue(viewModel.rooms)
                }
                activity?.supportFragmentManager?.commit {
                    this.replace(R.id.fragment_container, salas_fragment())
                    this.addToBackStack(null)
                }
            }
        }

        return view
    }

}