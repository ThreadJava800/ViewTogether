package com.example.viewtogether.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationSector(val title: String, val state: NavBarState, val icon: ImageVector) {
    class Create(title: String): NavigationSector(title = title, state = NavBarState.CREATE, icon = Icons.Filled.Create)
    class Join(title: String): NavigationSector(title = title, state = NavBarState.JOIN, icon = Icons.Filled.Search)
    class Settings(title: String): NavigationSector(title = title, state = NavBarState.SETTINGS, icon = Icons.Filled.Settings)
}
