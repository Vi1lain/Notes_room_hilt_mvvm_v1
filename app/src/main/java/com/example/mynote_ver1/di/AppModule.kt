package com.example.mynote_ver1.di

import android.content.Context
import androidx.room.Room
import com.example.mynote_ver1.data.NoteDao
import com.example.mynote_ver1.data.NoteDatabase
import com.example.mynote_ver1.data.NoteRepository
import com.example.mynote_ver1.data.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context, NoteDatabase::class.java, "note_db").build()
    @Provides
    fun provideNoteDao(
        noteDatabase: NoteDatabase
    ) = noteDatabase.noteDao()
    @Provides
    fun provideNoteRepository(
        noteDao: NoteDao
    ):NoteRepository = NoteRepositoryImpl(noteDao = noteDao)

}