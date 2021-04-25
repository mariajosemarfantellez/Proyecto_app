package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login= findViewById<Button>(R.id.button_login)
        login.setOnClickListener(){
            val intent = Intent(this, NavigationActivity::class.java)
            this.startActivity(intent)
        }

    }
}