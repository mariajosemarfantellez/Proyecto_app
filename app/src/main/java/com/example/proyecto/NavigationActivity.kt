package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.proyecto.todo_baraja_ajustes.ajustes_fragment
import com.example.proyecto.todo_baraja_ajustes.barajas_fragment
import com.example.proyecto.todo_salas.salas_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_navigation)
        this.supportFragmentManager?.commit {
            this.replace(R.id.fragment_container, barajas_fragment())
            this.addToBackStack(null)
        }

        val bottom = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.image_baraja -> {
                    this.supportFragmentManager?.commit {
                        this.replace(R.id.fragment_container, barajas_fragment())
                        this.addToBackStack(null)
                    }
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

}



