package com.fatihbasertr.noteappkotlin.repository

import androidx.lifecycle.LiveData
import com.fatihbasertr.noteappkotlin.data.NoteDao
import com.fatihbasertr.noteappkotlin.model.Note


class NoteRepository(private val noteDao: NoteDao) {
    val getAllNote: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }
}