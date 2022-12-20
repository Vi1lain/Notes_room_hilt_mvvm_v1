package com.example.mynote_ver1.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote_ver1.data.NoteEntity
import com.example.mynote_ver1.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
): ViewModel(){
    var note by mutableStateOf(NoteEntity(0,"",""))
    val notes = noteRepository.getNotes()

    fun addNote(note:NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.addNote(note = note)
    }
    fun deleteNote(note:NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.deleteNote(note = note)
    }
    fun updateNote(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.updateNote(note = note)
    }
    fun getNote(id:Int) = viewModelScope.launch(Dispatchers.IO){
        note = noteRepository.getIdNote(id)
    }

    fun updateTitle(title:String){
        note = note.copy(
            title = title
        )
    }
    fun updateSubText(subText:String){
        note = note.copy(
            subText = subText
        )
    }
}