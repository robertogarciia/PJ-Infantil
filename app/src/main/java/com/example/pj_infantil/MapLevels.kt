package com.example.pj_infantil

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.ImageView

class MapLevels: AppCompatActivity() {

    private lateinit var level1Button: ImageView
    private lateinit var level2Button: ImageView
    private lateinit var level3Button: ImageView
    private lateinit var level4Button: ImageView
    private lateinit var level5Button: ImageView
    private lateinit var level6Button: ImageView
    private lateinit var level7Button: ImageView
    private lateinit var level8Button: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firsts_levels)

        level1Button = findViewById(R.id.level1)
        level2Button = findViewById(R.id.level2)
        level3Button = findViewById(R.id.level3)
        level4Button = findViewById(R.id.level4)
        level5Button = findViewById(R.id.level5)
        level6Button = findViewById(R.id.level6)
        level7Button = findViewById(R.id.level7)
        level8Button = findViewById(R.id.level8)

        level1Button.setOnClickListener {
            val intent = Intent(this, lev1Activity::class.java)
            startActivity(intent)
        }
/*
        level2Button.setOnClickListener {
            val intent = Intent(this, level2memory::class.java)
            startActivity(intent)
        }

        level3Button.setOnClickListener {
            val intent = Intent(this, level3memory::class.java)
            startActivity(intent)
        }

        level4Button.setOnClickListener {
            val intent = Intent(this, level4memory::class.java)
            startActivity(intent)
        }

        level5Button.setOnClickListener {
            val intent = Intent(this, level5memory::class.java)
            startActivity(intent)
        }

        level6Button.setOnClickListener {
            val intent = Intent(this, level6memory::class.java)
            startActivity(intent)
        }

        level7Button.setOnClickListener {
            val intent = Intent(this, level7memory::class.java)
            startActivity(intent)
        }

        level8Button.setOnClickListener {
            val intent = Intent(this, level8memory::class.java)
            startActivity(intent)
        }
*/

    }
}