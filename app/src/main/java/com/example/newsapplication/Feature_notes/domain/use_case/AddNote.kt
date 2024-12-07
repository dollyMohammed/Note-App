package com.example.newsapplication.Feature_notes.domain.use_case

import com.example.newsapplication.Feature_notes.domain.model.InvalidNoteException
import com.example.newsapplication.Feature_notes.domain.model.Note
import com.example.newsapplication.Feature_notes.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("the title of the note can not be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("he content of the note can not be empty.")
        }
        repository.insertNote(note)
    }
}