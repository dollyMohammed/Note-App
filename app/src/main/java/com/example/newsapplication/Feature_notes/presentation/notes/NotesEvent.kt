package com.example.newsapplication.Feature_notes.presentation.notes

import com.example.newsapplication.Feature_notes.domain.model.Note
import com.example.newsapplication.Feature_notes.presentation.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder):NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object RestorNote:NotesEvent()
    object ToggleOrderSection:NotesEvent()
}
