package com.example.newsapplication.Feature_notes.presentation.add_edit_note.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsapplication.Feature_notes.presentation.util.NoteOrder
import com.example.newsapplication.Feature_notes.presentation.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier=Modifier,
    noteOrder: NoteOrder=NoteOrder.Date(OrderType.Descending),
    onOrderChange:(NoteOrder) -> Unit
){
    Column (modifier = Modifier){
        Row (modifier = Modifier.fillMaxWidth()){
            DefaultRaduioButton(text = "Title", selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType))})
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRaduioButton(text = "Date", selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType))})
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRaduioButton(text = "Color", selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType))})

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (modifier = Modifier.fillMaxWidth()){
            DefaultRaduioButton(text = "Ascending", selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Ascending))})
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRaduioButton(text = "Descending", selected = noteOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Descending))})



        }
    }
}