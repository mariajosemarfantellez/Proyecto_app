package com.example.proyecto.todo_salas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.OnClickListener
import com.example.proyecto.R


class salas_fragment : Fragment(), OnClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecycleViewAdapterRooms
    private val viewModel: SalasViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_salas_fragment, container, false)
        adapter = RecycleViewAdapterRooms(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel.myCases.observe(viewLifecycleOwner, Observer {
            adapter.set(it, -1)
        })
        /*viewModel.rooms = viewModel.delete()
        for(i in viewModel.rooms){
            adapter.addItem(i)
        }*/

        val button = view.findViewById<Button>(R.id.button_create)
        button.setOnClickListener {
            val bundle = Bundle()
            //Vamos al otro Fragment
            val fragmentTwo = crear_salas_fragment()
            fragmentTwo.arguments = bundle
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.fragment_container,fragmentTwo)
                this.addToBackStack(null)
            }
        }

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val name = bundle.getString("name")
            val password = bundle.getString("password")
            viewModel.rooms.add(Rooms(name,password))
            viewModel.Escritura(viewModel.rooms,"room_18.txt")
            //adapter.addItem(Rooms(name,password))

        }
        setFragmentResultListener("requestKey_2") { requestKey, bundle ->
            val name = bundle.getString("name")
            val password = bundle.getString("password")
            val position = bundle.getInt("position")
            viewModel.delete_rooms_2.add(Rooms(name,password))
            viewModel.Escritura(viewModel.delete_rooms_2, "delete_18.txt")
            //adapter.set(viewModel.rooms, position)
            //viewModel.rooms = viewModel.delete()
            //adapter.removeItem(position)
            viewModel.myCases.postValue(viewModel.rooms)

        }
        return view
    }

    override fun onClickItem(item: Any) {
        if(item is Rooms){
            setFragmentResult("requestKey_1", bundleOf("name" to item.name, "password" to item.password, "position" to adapter.data.indexOf(item)) )
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.fragment_container, delete_rooms_fragment())
                this.addToBackStack(null)
            }
        }

        }
    }
