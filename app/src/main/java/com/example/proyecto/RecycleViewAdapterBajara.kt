package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapterBaraja(override val onClickListener: OnClickListener):
    RecyclerView.Adapter<RecycleViewAdapterBaraja.ClassViewHolderBaraja>(), IAdapterView {

    var data = mutableListOf<String>()
    inner class ClassViewHolderBaraja(private val view: View): RecyclerView.ViewHolder(view){
        fun bindView(item: String){
            val number = view.findViewById<TextView>(R.id.text_baraja)
            number.text = item

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolderBaraja {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bajaras_viewholder,parent, false)
        return ClassViewHolderBaraja(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolderBaraja, position: Int) {
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
        if(item is String){
            data.add(item)
            notifyDataSetChanged()
        }
        this.notifyDataSetChanged()
    }
    //Este metodo utiliza la lista que le entrega el viewmodel
    fun set(cases: List<String>?, pos:Int){
        if(cases != null){
            for(i in cases){
                data.add(i)
            }
        }
        /*if(pos != -1){
            removeItem(pos)
        }*/
        //this.data = cases
        this.notifyDataSetChanged()
    }

    fun removeItem(position :Int){
        data.removeAt(position)
        this.notifyItemRemoved(position)
    }
    fun restoreItem(item : String, position: Int){
        data.add(item)
        this.notifyItemInserted(position)
    }
}