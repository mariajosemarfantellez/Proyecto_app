package com.example.proyecto.todo_salas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.IAdapterView
import com.example.proyecto.OnClickListener
import com.example.proyecto.R

class RecycleViewAdapterRooms(override val onClickListener: OnClickListener):
        RecyclerView.Adapter<RecycleViewAdapterRooms.ClassViewHolder>(), IAdapterView {

    var data = mutableListOf<Rooms>()
    inner class ClassViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bindView(item: Rooms){
            val name = view.findViewById<TextView>(R.id.text_sala_name)
            name.text = item.name

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.salas_viewholder,parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val item = data[position]
        holder.bindView(item)
        holder.itemView.setOnClickListener {
            onClickListener.onClickItem(item)
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun addItem(item: Any?) {
        if(item is Rooms){
            data.add(item)
            notifyDataSetChanged()
        }
        this.notifyDataSetChanged()
    }
    //Este metodo utiliza la lista que le entrega el viewmodel
    fun set(cases: List<Rooms>?, pos:Int){
        if(cases != null){
            for(i in cases){
                data.add(i)
            }
        }
        this.notifyDataSetChanged()
    }

}