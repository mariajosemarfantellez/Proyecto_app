package com.example.proyecto

import android.os.Bundle
import android.text.style.TabStopSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView


class barajas_fragment(item : Int) : Fragment(), OnClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecycleViewAdapterBaraja
    private val viewModel: BarajaViewModel by viewModels()
    val baraja_change = item

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_barajas_fragment, container, false)

        //val baraja_change = arguments?.getInt("position_2")

        lateinit var baraja : List<String>
        adapter = RecycleViewAdapterBaraja(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter

        if (baraja_change == 1){
            baraja = viewModel.Standard
        }
        else if (baraja_change == 2){
            baraja = viewModel.T_Shirt
        }
        else if (baraja_change == 3){
            baraja = viewModel.Fibonacci
        }
        else if (baraja_change == 4){
            baraja = viewModel.Hours
        }
        else{
            baraja = viewModel.Standard
        }
        recyclerView.layoutManager = GridLayoutManager(activity, baraja.size,  GridLayoutManager.VERTICAL, false)
        (recyclerView.layoutManager as GridLayoutManager).setSpanSizeLookup(object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
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
        /*setFragmentResultListener("requestKey_4") { requestKey, bundle ->
            val position = bundle.getInt("position")

            if (position == 0){
                baraja = viewModel.Standard
            }
            if (position == 1){
                baraja = viewModel.T_Shirt
            }
            if (position == 2){
                baraja = viewModel.Fibonacci
            }
            if (position == 3){
                baraja = viewModel.Hours
            }
            recyclerView.layoutManager = GridLayoutManager(activity, baraja.size,  GridLayoutManager.VERTICAL, false)
            (recyclerView.layoutManager as GridLayoutManager).setSpanSizeLookup(object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
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
        }*/

        return view
    }
    override fun onClickItem(item: Any) {
        if(item is String){
            setFragmentResult("requestKey_5", bundleOf("number" to item) )
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.fragment_container,detail_baraja_fragment())
                this.addToBackStack(null)
            }
        }

    }

}
