package com.example.pj_infantil

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class historia : AppCompatActivity() {
    private lateinit var IVBackMenuHistoria: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historia)

        val videoView = findViewById<VideoView>(R.id.xml_video_view)
        val packageName = "android.resource://" + packageName + "/" + R.raw.historia
        val uri = Uri.parse(packageName)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        IVBackMenuHistoria = findViewById(R.id.IVbackMenuHistoria)

        IVBackMenuHistoria.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}