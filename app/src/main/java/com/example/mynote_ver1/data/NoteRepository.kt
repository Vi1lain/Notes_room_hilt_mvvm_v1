package com.example.mynote_ver1.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<NoteEntity>>
    fun addNote(note:NoteEntity)
    fun deleteNote(note:NoteEntity)
    fun updateNote(note:NoteEntity)
    fun getIdNote(id:Int):NoteEntity
}