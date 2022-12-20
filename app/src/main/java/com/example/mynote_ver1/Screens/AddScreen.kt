package com.example.mynote_ver1.Screens


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynote_ver1.data.NoteEntity
import com.example.mynote_ver1.navigation.Screens
import com.example.mynote_ver1.view_model.NoteViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController,
    viewModel: NoteViewModel = hiltViewModel()) {

    var titleState by remember { mutableStateOf("") }
    var subTextState by remember { mutableStateOf("") }
    Scaffold(topBar = { TopAppBar{
        IconButton(onClick = {navController.popBackStack(route = Screens.HomeScreen.route, inclusive = false) })
        {Icon(Icons.Filled.ArrowBack, null)}
        Spacer(Modifier.weight(1f, true))
        Text(text = "Добавить запись")
        IconButton(onClick = {
            val note = NoteEntity(
                id = 0,
                title = titleState,
                subText = subTextState
            )
            viewModel.addNote(note)
            navController.popBackStack(route = Screens.HomeScreen.route, inclusive = false)
        })
        {Icon(Icons.Filled.Check, null)}

    }}){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = titleState,
                onValueChange = { titleState = it },
                placeholder = { Text(text = "Title") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.White
                ))
            Divider()
            OutlinedTextField(modifier = Modifier
                .fillMaxWidth(),
                value = subTextState,
                onValueChange = { subTextState = it },
                placeholder = { Text(text = "info") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.White
                ))
        }
    }
}}