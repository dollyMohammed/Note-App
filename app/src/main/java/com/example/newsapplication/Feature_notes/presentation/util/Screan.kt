package com.example.newsapplication.Feature_notes.presentation.util

sealed class Screan(val route:String){
    object NotesScrean:Screan("notes_screan")
    object AddEditNoteScrean:Screan("Add_edit_note_screan")

}
