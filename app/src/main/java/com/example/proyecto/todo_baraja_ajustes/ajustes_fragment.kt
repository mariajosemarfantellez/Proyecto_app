package com.example.proyecto.todo_baraja_ajustes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import androidx.fragment.app.*
import com.example.proyecto.NavigationActivity
import com.example.proyecto.R

class ajustes_fragment() : Fragment() {
    //private val viewModel: AjustesViewModel by viewModels()
    lateinit var adapter : AdapterView<Adapter>
    //lateinit var navigationActivity: NavigationActivity
    private val viewModel: BarajaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ajustes_fragment, container, false)

        val navigationActivity = NavigationActivity()

        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val eleccion = spinner.getSelectedItem().toString()

        spinner?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
                if (pos != null){
                    navigationActivity.change(pos)
                }
                if(pos!=0){
                    val bundle = Bundle()
                    bundle.putInt("position_2", pos)
                    barajas_fragment().arguments = bundle
                    viewModel.posicion = pos
                    activity?.supportFragmentManager?.commit {
                        this.replace(R.id.fragment_container, barajas_fragment())
                        this.addToBackStack(null)
                    }
                    //activity?.supportFragmentManager?.popBackStack()
                }

                //setFragmentResult("requestKey_4", bundleOf("position" to pos) )
                //activity?.supportFragmentManager?.popBackStack()
                // pos me da la posicion de el seleccionado
                //item me da el nombre del seleccionado
                //luego enviar la informacion del seleccionado al fragmento de barajas
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        return view
    }


}