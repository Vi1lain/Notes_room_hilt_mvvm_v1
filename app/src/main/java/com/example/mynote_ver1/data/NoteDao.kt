package com.example.mynote_ver1.data


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_db ORDER BY id ASC")
    fun getNotes():Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note:NoteEntity)

    @Delete
    fun deleteNote(note:NoteEntity)

    @Update
    fun updateNote(note:NoteEntity)

    @Query("SELECT * FROM note_db WHERE id= :id")
    fun getNoteId(id:Int):NoteEntity

}