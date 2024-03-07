package com.example.pj_infantil.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SettingsDao {

    @Query("UPDATE settings SET isdone = 1 WHERE id = :idLevel")
    fun updateIsdone(idLevel: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSettings(settings: Settings)
    @Query("SELECT * FROM settings WHERE id = 1")
    fun getSettings(): Settings?


}