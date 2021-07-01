package com.fatihbasertr.noteappkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fatihbasertr.noteappkotlin.data.NoteDatabase
import com.fatihbasertr.noteappkotlin.model.Note
import com.fatihbasertr.noteappkotlin.repository.NoteRepository

import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    val getAllNote: LiveData<List<Note>>
    private val noteRepository: NoteRepository

    init {
        val userDao = NoteDatabase.getNoteDatabase(application).noteDao()
        noteRepository = NoteRepository(userDao)
        getAllNote = noteRepository.getAllNote
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }
}