package com.example.newsapplication.Feature_notes.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapplication.Feature_notes.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
 abstract class NoteDatabase : RoomDatabase() {
     abstract val noteDao:NoteDao
     companion object{
         const val DATABASA_NAME = "notes_db"
     }

}