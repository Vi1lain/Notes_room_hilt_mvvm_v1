package com.example.mynote_ver1.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynote_ver1.data.NoteEntity
import com.example.mynote_ver1.navigation.Screens
import com.example.mynote_ver1.view_model.NoteViewModel

@Composable
fun NoteCard(
    navController: NavHostController,
    note: NoteEntity,
    viewModel: NoteViewModel = hiltViewModel()
) {
    val noteid = note.id

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .clickable {
                navController.navigate(Screens.UpdateScreen.route+"/$noteid")
            }
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = note.title)
                Text(text = note.subText) }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = { viewModel.deleteNote(note) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}
