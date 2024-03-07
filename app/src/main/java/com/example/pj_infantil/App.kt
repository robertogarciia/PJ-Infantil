package com.example.pj_infantil

import android.app.Application
import androidx.room.Room
import com.example.pj_infantil.room.MyDB

class App: Application() {
    lateinit var db: MyDB

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            MyDB::class.java,
            "PIGame-db"
        ).build()
    }
}