package com.example.mynote_ver1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mynote_ver1.Screens.AddScreen

import com.example.mynote_ver1.Screens.HomeScreen
import com.example.mynote_ver1.Screens.UpdateScreen

sealed class Screens(val route: String) {
    object HomeScreen : Screens("home_screen")
    object AddScreen : Screens("add_screen")
    object UpdateScreen : Screens("update_screen")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) { HomeScreen(navController = navController) }
        composable(Screens.AddScreen.route) { AddScreen(navController = navController) }

        composable("${Screens.UpdateScreen.route}/{noteid}",
            arguments = listOf(navArgument(name = "noteid"){
                type = NavType.IntType

            })) { entry->
                UpdateScreen(noteid = entry.arguments?.getInt("noteid")?:0,navController = navController) }
    }



}
