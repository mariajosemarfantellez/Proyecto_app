package com.example.proyecto.todo_baraja_ajustes

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.IAdapterView
import com.example.proyecto.OnClickListener
import com.example.proyecto.R

class RecycleViewAdapterBaraja(override val onClickListener: OnClickListener):
    RecyclerView.Adapter<RecycleViewAdapterBaraja.ClassViewHolderBaraja>(), IAdapterView {

    var data = mutableListOf<String>()
    val tamaño = Resources.getSystem().getDisplayMetrics().widthPixels
    inner class ClassViewHolderBaraja(private val view: View): RecyclerView.ViewHolder(view){
        fun bindView(item: String, position: Int){
            val number = view.findViewById<TextView>(R.id.text_baraja)
            number.text = item
            if(data.size % 3 == 1 ){
                cambio_espacio_caso_1(position)
            }
            if (data.size % 3!=0) {
                if (data.size % 3 == 2) {
                    cambio_espacio_caso_2(position)
                }
            }

        }
        fun cambio_espacio_caso_2(position : Int){
            if(position == data.size-1){
                view.x += tamaño/6 -20
            }
            if(position == data.size -2){
                view.x += tamaño/6 -20
            }

        }
        fun cambio_espacio_caso_1(position:Int){
            if(position == data.size -1){
                view.x += tamaño/3 -19
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolderBaraja {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bajaras_viewholder,parent, false)
        return ClassViewHolderBaraja(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolderBaraja, position: Int) {
        val item = data[position]
        holder.bindView(item, position)
        holder.itemView.setOnClickListener {
            onClickListener.onClickItem(item)
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun addItem(item: Any?) {
        if(item is String){
            data.add(item)
            notifyDataSetChanged()
        }
        this.notifyDataSetChanged()
    }

    fun set(cases: List<String>?, pos:Int){
        if(cases != null){
            for(i in cases){
                data.add(i)
            }
        }
        this.notifyDataSetChanged()
    }

}