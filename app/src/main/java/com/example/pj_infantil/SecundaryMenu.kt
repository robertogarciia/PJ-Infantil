package com.example.pj_infantil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class SecundaryMenu :AppCompatActivity(){
private lateinit var btnSound: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_secundari)

        val btnSound = findViewById<ImageView>(R.id.imageButton3)


        btnSound.setOnClickListener {
            val intent = Intent(this, Sound_conf::class.java)
            startActivity(intent)
        }

       /* languageBtn.setOnClickListener {
            val intent = Intent(this, Language_conf::class.java)
            startActivity(intent)
        }
        */

    }
}