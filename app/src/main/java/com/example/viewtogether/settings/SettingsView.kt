package com.example.viewtogether.settings

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SettingsView(navController: NavController) {
    Text("Create")
    Log.d("Nav", "Settings")
}