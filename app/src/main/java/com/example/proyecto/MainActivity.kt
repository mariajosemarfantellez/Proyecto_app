package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        val login= findViewById<Button>(R.id.button_login)
        login.setOnClickListener(){
            val email = findViewById<EditText>(R.id.edit_email)
            val password = findViewById<EditText>(R.id.edit_password)
            val invalid = findViewById<TextView>(R.id.invalid_text)
            if (email.getText().toString() == "" || password.getText().toString() == ""){
                invalid.setVisibility(VISIBLE)
            }
            else{
                val intent = Intent(this, NavigationActivity::class.java)
                this.startActivity(intent)
            }

        }

    }
}