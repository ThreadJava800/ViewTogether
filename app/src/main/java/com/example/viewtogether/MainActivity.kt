package com.example.viewtogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viewtogether.create.CreateView
import com.example.viewtogether.navigation.NavBarState
import com.example.viewtogether.navigation.NavigationSector
import com.example.viewtogether.search.JoinView
import com.example.viewtogether.settings.SettingsView
import com.example.viewtogether.ui.theme.ViewTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BottomNavigationBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val sectors = listOf(
                NavigationSector.Create(stringResource(id = R.string.create_sector)),
                NavigationSector.Join(stringResource(id = R.string.join_sector)),
                NavigationSector.Settings(stringResource(id = R.string.settings_sector))
            )
            var selectedSectorNum by remember { mutableStateOf(0) }

            NavigationBar {
                sectors.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(item.title) },
                        selected = selectedSectorNum == index,
                        onClick = {
                            selectedSectorNum = index
                            navController.navigate(item.state.name)
                        }
                    )
                }
            }
        }) {
        NavHost(navController, startDestination = NavBarState.CREATE.toString()) {
            composable(route = NavBarState.JOIN.toString()) { JoinView(navController) }
            composable(route = NavBarState.CREATE.toString()) { CreateView(navController) }
            composable(route = NavBarState.SETTINGS.toString()) { SettingsView(navController) }
        }
    }
}