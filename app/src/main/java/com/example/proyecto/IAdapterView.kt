package com.example.proyecto

interface IAdapterView {
    fun addItem(item: Any?)
    val onClickListener: OnClickListener
}