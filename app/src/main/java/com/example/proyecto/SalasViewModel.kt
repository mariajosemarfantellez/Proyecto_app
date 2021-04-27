package com.example.proyecto

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.io.*

class SalasViewModel(application: Application) : AndroidViewModel(application) {
    val myCases =  MutableLiveData<MutableList<Rooms>>()
    var rooms = mutableListOf<Rooms>()
    var delete_rooms_2 = mutableListOf<Rooms>()
    val contexto = application.baseContext

    init {
        //Inicializamos el archivo con estas salas
        /*rooms.add(Rooms("Frontend Team","1234"))
        rooms.add(Rooms("Devops Team","5678"))
        rooms.add(Rooms("Another Project","1010"))
        rooms.add(Rooms("Super Team","0000"))
        Escritura(rooms,"room_18.txt")
        Escritura(delete_rooms_2,"delete_18.txt")
        rooms.add(Rooms(",",""))*/

        //rooms = delete()
        rooms = Leer(contexto, "room_18.txt")
        myCases.postValue(rooms)
        //myCases.remove

        /*val gson = Gson()
            val fileName = "contacts.json"
            val file = application.assets.open(fileName).bufferedReader()
            cases = gson.fromJson(file,Array<Contactos>::class.java)

            for(i in 0..cases.size-1){
                contactos.add(cases[i])
            }*/


        //val file_2 = application.assets.open("contacts_2.txt").bufferedReader()


        /*ESTO CON VIEW MODEL
        val file_2 = application.resources.openRawResource(R.raw.contactos).bufferedReader()
        file_2.forEachLine {
            contactos.add(Contactos(it.split(";")[0], it.split(";")[1]))
        }*/

    }
    fun delete(): MutableList<Rooms>{
        rooms = Leer(contexto, "room_18.txt")
        delete_rooms_2 = Leer(contexto, "delete_18.txt")
        if(delete_rooms_2.size>0){
            for (i in 0..delete_rooms_2.size-1){
                for(j in 0..rooms.size-1){
                    if(delete_rooms_2[i].name == rooms[j].name){
                        rooms.removeAt(j)
                    }
                }
            }
        }
        return rooms

    }
    fun Escritura(list: MutableList<Rooms>, filename: String){
        Escribir(list, contexto, filename)
    }

    fun Leer(contexto: Context, filename :String) : MutableList<Rooms>{
        var rooms_final = mutableListOf<Rooms>()
        try{
            var input : FileInputStream? = null
            input = contexto.openFileInput(filename)
            var input_2: InputStreamReader = InputStreamReader(input)
            val buffer: BufferedReader = BufferedReader(input_2)
            var linea: String? = null
            while({linea = buffer.readLine(); linea}() != null) {
                if (linea!=null) {
                    val name_password = linea!!.split(",").toTypedArray()
                    rooms_final.add(Rooms(name_password[0],name_password[1]))
                }
            }
        }
        catch(e: Exception){
            println(e.message)
        }
        return rooms_final
    }

    fun Escribir(rooms: MutableList<Rooms>, context: Context, filename:String){
        try{
            val file: FileOutputStream
            file = context.openFileOutput(filename, Context.MODE_PRIVATE)
            for (i in rooms){
                val room = i.name + "," + i.password + '\n'
                file.write(room.toByteArray())
            }
            file.close()
        }
        catch(e: Exception){
            println(e.message)
        }
    }


}