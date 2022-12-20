package com.example.mynote_ver1.data

import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<NoteEntity>> =noteDao.getNotes()

    override fun addNote(note: NoteEntity) =noteDao.addNote(note = note)

    override fun deleteNote(note: NoteEntity) = noteDao.deleteNote(note = note)

    override fun updateNote(note: NoteEntity) = noteDao.updateNote(note = note)

    override fun getIdNote(id: Int): NoteEntity = noteDao.getNoteId(id)


}