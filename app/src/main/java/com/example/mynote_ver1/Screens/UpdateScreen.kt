package com.example.mynote_ver1.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynote_ver1.navigation.Screens
import com.example.mynote_ver1.view_model.NoteViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun UpdateScreen(navController:NavHostController,
    viewModel: NoteViewModel = hiltViewModel(),
    noteid:Int?
) {
    val note = viewModel.note
    LaunchedEffect(Unit ){
        if (noteid != null) {
            viewModel.getNote(noteid)
        }
    }

  Scaffold(topBar = { TopAppBar() {
      IconButton(onClick = {navController.popBackStack(route = Screens.HomeScreen.route, inclusive = false) }) {Icon(Icons.Filled.ArrowBack, null)}
      Spacer(Modifier.weight(1f, true))
      Text(text = "Изменить запись")
      IconButton(onClick = {viewModel.updateNote(note) }) {Icon(Icons.Filled.Check, null)}
      
  }}) {
      Card(
          shape = MaterialTheme.shapes.medium,
          modifier = Modifier
              .fillMaxWidth()
              .padding(10.dp),
          elevation = 10.dp,
      ){
          Column(modifier = Modifier.fillMaxWidth(),
              horizontalAlignment = Alignment.CenterHorizontally) {
              OutlinedTextField(modifier = Modifier
                  .fillMaxWidth(),
                  value = note.title,
                  onValueChange = {title-> viewModel.updateTitle(title) },
                  colors = TextFieldDefaults.outlinedTextFieldColors(
                      focusedBorderColor = Green,
                      unfocusedBorderColor = White) )
              Divider()
              OutlinedTextField(modifier = Modifier
                  .fillMaxWidth(),
                  value = note.subText,
                  onValueChange = {subText-> viewModel.updateSubText(subText) },
                  colors = TextFieldDefaults.outlinedTextFieldColors(
                      focusedBorderColor = Green,
                      unfocusedBorderColor = White))

          }
      }
  }



}