package com.example.mytestnavigationapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onNavigationProfile: (userId: String) -> Unit,
    onNavigationDetails: () -> Unit,

    ) {

    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text("Home Screen")

            Button(
                onClick = { onNavigationDetails() }
            ) {
                Text("Go to details screen")
            }


            Button(
                onClick = { onNavigationProfile("253") }
            ) {
                Text("Go to profile screen")
            }
        }
    }
}