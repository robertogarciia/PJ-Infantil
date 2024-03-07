package com.example.pj_infantil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPlayMenuPrincipal: ImageView
    private lateinit var buttonConfigMenuPrincipal: ImageView
    private lateinit var buttonHistoryMenuPrincipal: ImageView

    //prueba 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_principal)

        buttonPlayMenuPrincipal = findViewById(R.id.controllerMP)

        buttonPlayMenuPrincipal.setOnClickListener {

            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }

        buttonConfigMenuPrincipal = findViewById(R.id.settingsMP)

        buttonConfigMenuPrincipal.setOnClickListener {

            val intent = Intent(this, SecundaryMenu::class.java)
            startActivity(intent)
        }

        buttonHistoryMenuPrincipal = findViewById(R.id.historyMP)

        buttonHistoryMenuPrincipal.setOnClickListener {

            val intent = Intent(this, historia::class.java)
            startActivity(intent)
        }

    }
}