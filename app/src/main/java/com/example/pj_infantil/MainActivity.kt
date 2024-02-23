package com.example.pj_infantil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPlayMenuPrincipal: TextView
    private lateinit var buttonConfigMenuPrincipal: TextView
    private lateinit var buttonHistoryMenuPrincipal: TextView

    //prueba

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_principal)

        buttonPlayMenuPrincipal = findViewById(R.id.TVPlayMenuPrincipal)

        buttonPlayMenuPrincipal.setOnClickListener {

            val intent = Intent(this, MapLevels::class.java)
            startActivity(intent)
        }

        buttonConfigMenuPrincipal = findViewById(R.id.TVConfigMenuPrincipal)

        buttonConfigMenuPrincipal.setOnClickListener {

            val intent = Intent(this, SecundaryMenu::class.java)
            startActivity(intent)
        }

        buttonHistoryMenuPrincipal = findViewById(R.id.TVHistorMenuPrincipal)

        buttonHistoryMenuPrincipal.setOnClickListener {

            val intent = Intent(this, SecundaryMenu::class.java)
            startActivity(intent)
        }

    }
}