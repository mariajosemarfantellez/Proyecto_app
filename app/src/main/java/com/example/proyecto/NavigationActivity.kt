package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.proyecto.todo_baraja_ajustes.ajustes_fragment
import com.example.proyecto.todo_baraja_ajustes.barajas_fragment
import com.example.proyecto.todo_salas.salas_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity() : AppCompatActivity(), ChangeBaraja {
    private var baraja_change = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        //this.supportFragmentManager?.commit {
          //  this.replace(R.id.fragment_container,barajas_fragment(baraja_change))
          //  this.addToBackStack(null)
        //}
        supportFragmentManager.beginTransaction().apply{
            val bundle = Bundle()
            bundle.putInt("position_2", baraja_change)
            barajas_fragment().arguments = bundle
            replace(R.id.fragment_container, barajas_fragment())
            commit()
        }

        val bottom = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.image_baraja -> {
                    supportFragmentManager.beginTransaction().apply{
                        //val bundle = Bundle()
                        //bundle.putInt("position_2", baraja_change)
                        //barajas_fragment().arguments = bundle
                        replace(R.id.fragment_container, barajas_fragment())
                        commit()
                    }
                    //this.supportFragmentManager?.commit {
                      //  this.replace(R.id.fragment_container,barajas_fragment(baraja_change))
                      //  this.addToBackStack(null)
                    //}
                    true
                }
                R.id.image_salas -> {
                    this.supportFragmentManager?.commit {
                        this.replace(R.id.fragment_container, salas_fragment())
                        this.addToBackStack(null)
                    }
                    true
                }
                R.id.image_ajuste -> {
                    this.supportFragmentManager?.commit {
                        this.replace(R.id.fragment_container, ajustes_fragment())
                        this.addToBackStack(null)
                    }
                    true

                }
                else -> false
            }

        })

    }

    override fun change(item: Int): Int {
        baraja_change = item

        return baraja_change
    }
}



