package com.example.pj_infantil

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class Language_conf : AppCompatActivity(){
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var changeLanguageEs: Button
    private lateinit var changeLanguageEn: Button
    private lateinit var changeLanguageCat: Button
    private lateinit var backSecundaryMenu: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.language_conf)

        sharedPreferences = getSharedPreferences("LanguagePreferences", MODE_PRIVATE)

        val changeLanguageCat: Button = findViewById(R.id.buttoncatChange)
        val changeLanguageEs: Button = findViewById(R.id.buttonEspChange)
        val changeLanguageEn: Button = findViewById(R.id.buttonEngChange)
        val butonBack = findViewById<ImageView>(R.id.backMenuSecundari)


        changeLanguageEs.setOnClickListener {
            // Cambiar el idioma y reiniciar la actividad
            changeLanguage("es") // Cambia a español, puedes ajustar según tus necesidades
            recreate()
        }
        changeLanguageEn.setOnClickListener {
            // Cambiar el idioma y reiniciar la actividad
            changeLanguage("en")
            recreate()
        }
        changeLanguageCat.setOnClickListener {
            // Cambiar el idioma y reiniciar la actividad
            changeLanguage("ca") // Cambia a español, puedes ajustar según tus necesidades
            recreate()
        }

        butonBack.setOnClickListener {
            val intent = Intent(this, SecundaryMenu::class.java)
            startActivity(intent)
        }
    }

    private fun changeLanguage(languageCode: String) {
        val editor = sharedPreferences.edit()
        editor.putString("language", languageCode)
        editor.apply()

        // Configurar el idioma de la aplicación
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    override fun onResume() {
        super.onResume()
        // Aplicar el idioma almacenado en las preferencias compartidas
        val languageCode = sharedPreferences.getString("language", "en")
        val locale = Locale(languageCode!!)
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}