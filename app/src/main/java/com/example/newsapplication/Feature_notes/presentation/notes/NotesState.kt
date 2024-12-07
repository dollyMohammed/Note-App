package com.example.newsapplication.Feature_notes.presentation.notes

import com.example.newsapplication.Feature_notes.domain.model.Note
import com.example.newsapplication.Feature_notes.presentation.util.NoteOrder
import com.example.newsapplication.Feature_notes.presentation.util.OrderType

data class NotesState(
    val notes:List<Note> = emptyList(),
val noteOrder: NoteOrder=NoteOrder.Date(OrderType.Descending),
    val isOrderSelectVisible:Boolean=false
    )
