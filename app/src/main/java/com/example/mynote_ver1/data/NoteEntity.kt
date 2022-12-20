package com.example.mynote_ver1.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_db")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val subText:String
)
