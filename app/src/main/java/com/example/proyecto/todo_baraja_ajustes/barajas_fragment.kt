package com.example.proyecto.todo_baraja_ajustes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.OnClickListener
import com.example.proyecto.R


class barajas_fragment() : Fragment(), OnClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecycleViewAdapterBaraja
    private val viewModel: BarajaViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_barajas_fragment, container, false)


        lateinit var baraja : List<String>
        adapter = RecycleViewAdapterBaraja(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter

        if (viewModel.posicion == 1){
            baraja = viewModel.Standard
        }
        else if (viewModel.posicion == 2){
            baraja = viewModel.T_Shirt
        }
        else if (viewModel.posicion == 3){
            baraja = viewModel.Fibonacci
        }
        else if (viewModel.posicion == 4){
            baraja = viewModel.Hours
        }
        else{
            baraja = viewModel.Standard
        }
        recyclerView.layoutManager = GridLayoutManager(activity, baraja.size+1,  GridLayoutManager.VERTICAL, false)
        (recyclerView.layoutManager as GridLayoutManager).setSpanSizeLookup(object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if(baraja == viewModel.T_Shirt){
                    return 3
                }
                else if(baraja == viewModel.Fibonacci){
                    return 5
                }
                if (position % 3 == 0){
                    return 4
                }
                return 4
            }
        })
        recyclerView.setLayoutManager(recyclerView.layoutManager)
        for(i in baraja){
            adapter.addItem(i)
        }


        return view
    }
    override fun onClickItem(item: Any) {
        if(item is String){
            setFragmentResult("requestKey_5", bundleOf("number" to item) )
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.fragment_container, detail_baraja_fragment())
                this.addToBackStack(null)
            }
        }

    }

}
