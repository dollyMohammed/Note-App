package com.example.newsapplication.Feature_notes.domain.use_case

import com.example.newsapplication.Feature_notes.domain.model.Note
import com.example.newsapplication.Feature_notes.domain.repository.NoteRepository

class GrtNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id:Int): Note?{
        return repository.getNoteById(id)
    }
}