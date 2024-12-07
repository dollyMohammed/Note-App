package com.example.newsapplication.di

import android.app.Application
import androidx.room.Room
import com.example.newsapplication.Feature_notes.data.data_source.NoteDatabase
import com.example.newsapplication.Feature_notes.data.repository.NoteRepositoryImpl
import com.example.newsapplication.Feature_notes.domain.repository.NoteRepository
import com.example.newsapplication.Feature_notes.domain.use_case.AddNote
import com.example.newsapplication.Feature_notes.domain.use_case.DeleteNote
import com.example.newsapplication.Feature_notes.domain.use_case.GetNotes
import com.example.newsapplication.Feature_notes.domain.use_case.GrtNote
import com.example.newsapplication.Feature_notes.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASA_NAME
        ).build()
    }
    @Provides
    @Singleton
fun provideNoteRepository(db:NoteDatabase):NoteRepository{
    return NoteRepositoryImpl(db.noteDao)
}
    @Provides
    @Singleton
fun providenoteUseCase(repository: NoteRepository):NoteUseCases{
    return NoteUseCases(
        getNotes = GetNotes(repository),
        deleteNote = DeleteNote(repository),
        addNote=AddNote(repository),
        getNote = GrtNote(repository)
    )
}
}