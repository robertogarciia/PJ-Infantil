package com.example.pj_infantil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pj_infantil.room.Settings
import com.example.pj_infantil.room.SettingsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPlayMenuPrincipal: ImageView
    private lateinit var buttonConfigMenuPrincipal: ImageView
    private lateinit var buttonHistoryMenuPrincipal: ImageView
    private lateinit var settingsDao: SettingsDao

    //prueba 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_principal)

        val db = (applicationContext as App).db

        settingsDao = db.settingsDao()
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
        insertInitialData()
    }
    private fun insertInitialData() {
        GlobalScope.launch(Dispatchers.IO) {
            val existingSettings = settingsDao.getSettings()
            if (existingSettings == null) {
                settingsDao.insertSettings(Settings(id = 1, isdone = false))
            }
        }
    }
}