package com.example.proyecto.todo_salas

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Rooms(
        var name: String?,
        val password : String?
): Parcelable {
}