package com.example.mynote_ver1.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynote_ver1.navigation.Screens
import com.example.mynote_ver1.view_model.NoteViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    navController: NavHostController,
    ) {

    val notes by viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(modifier = Modifier.fillMaxWidth(), floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate(Screens.AddScreen.route)
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(notes) { note ->
                NoteCard(note = note,navController =navController)
            }
        }
    }
}


