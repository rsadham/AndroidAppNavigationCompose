package com.example.mytestnavigationapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home")
        {

            HomeScreen(
                onNavigationProfile = { userId ->
                    navController.navigate("profile/$userId")
                },
                onNavigationDetails = {
                    navController.navigate("details")
                }
            )

        }


        composable("details")
        {
            DetailsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "profile/{userId}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.StringType
                }
            ))
        { backStateEntry ->
            ProfileScreen(
                userId = backStateEntry.arguments?.getString("userId") ?: "",
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }

}