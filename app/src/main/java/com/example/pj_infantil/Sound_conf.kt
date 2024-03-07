package com.example.pj_infantil

import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Sound_conf : AppCompatActivity(){
    private lateinit var volumeSeekBar: SeekBar
    private lateinit var volumeTextView: TextView
    private lateinit var backmenu : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mute_configuration)

        volumeSeekBar = findViewById(R.id.volumeSeekBar)
        volumeTextView = findViewById(R.id.volumeTextView)
        backmenu = findViewById<ImageView>(R.id.backSecundariMenu)

        backmenu.setOnClickListener{
            val intent = Intent(this, SecundaryMenu::class.java)
            startActivity(intent)
        }

        // Obtener el controlador de audio del sistema
        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        // Configurar el rango del SeekBar según el volumen máximo del sistema
        volumeSeekBar.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        // Configurar el progreso inicial del SeekBar según el volumen actual del sistema
        volumeSeekBar.progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        // Configurar el oyente para el SeekBar
        volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Cambiar el volumen del sistema cuando se ajusta el SeekBar
                audioManager.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    progress,
                    AudioManager.FLAG_SHOW_UI
                )

                // Actualizar el texto con el porcentaje de volumen
                val volumePercentage = (progress * 100) / volumeSeekBar.max

                volumeTextView.text = " Volumen: $volumePercentage%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No se requiere implementación
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No se requiere implementación
            }
        })
    }
}