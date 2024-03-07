package com.example.pj_infantil.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class Settings (
    @PrimaryKey
    val id:Int,
    var isdone: Boolean = false
)