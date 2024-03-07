package com.example.pj_infantil

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.ImageView
import com.example.pj_infantil.room.Settings
import com.example.pj_infantil.room.SettingsDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MapLevels: AppCompatActivity() {

    private lateinit var level1Button: ImageView
    private lateinit var level2Button: ImageView
    private lateinit var level3Button: ImageView
    private lateinit var level4Button: ImageView
    private lateinit var level5Button: ImageView
    private lateinit var level6Button: ImageView
    private lateinit var level7Button: ImageView
    private lateinit var level8Button: ImageView
    private lateinit var settingsDao: SettingsDao
    private lateinit var backLevel: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firsts_levels)

        settingsDao = ((applicationContext as App).db).settingsDao()
        level1Button = findViewById(R.id.level1)
        level2Button = findViewById(R.id.level2)
        level3Button = findViewById(R.id.level3)
        level4Button = findViewById(R.id.level4)
        level5Button = findViewById(R.id.level5)
        level6Button = findViewById(R.id.level6)
        level7Button = findViewById(R.id.level7)
        level8Button = findViewById(R.id.level8)
        backLevel = findViewById(R.id.flechaback)

        backLevel.setOnClickListener{
            finish()
        }

        level1Button.setOnClickListener {
            val intent = Intent(this, lev1Activity::class.java)
            GlobalScope.launch {
                val setting = Settings(id=1, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }


        level2Button.setOnClickListener {
            val intent = Intent(this, level1memory::class.java)
            GlobalScope.launch {
                val setting = Settings(id=2, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }

        level3Button.setOnClickListener {
            val intent = Intent(this, levLabyrinth::class.java)
            GlobalScope.launch {
                val setting = Settings(id=3, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }

        level4Button.setOnClickListener {
            val intent = Intent(this, level1diferencias::class.java)
            GlobalScope.launch {
                val setting = Settings(id=4, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }

        level5Button.setOnClickListener {
            val intent = Intent(this, levAnswerCharacters::class.java)
            GlobalScope.launch {
                val setting = Settings(id=5, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }

        level6Button.setOnClickListener {
            val intent = Intent(this, level1puzzle::class.java)
            GlobalScope.launch {
                val setting = Settings(id=6, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }

        level7Button.setOnClickListener {
            val intent = Intent(this, lev2colors::class.java)
            GlobalScope.launch {
                val setting = Settings(id=7, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }

        level8Button.setOnClickListener {
            val intent = Intent(this, level2memory::class.java)
            GlobalScope.launch {
                val setting = Settings(id=8, isdone = false)
                settingsDao.insertSettings(setting)
            }
            startActivity(intent)
        }
    }
}