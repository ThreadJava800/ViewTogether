package com.example.viewtogether.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.viewtogether.R
import com.example.viewtogether.ui.theme.beige

@Composable
fun SettingsView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .background(beige)
                .fillMaxWidth().clickable(onClick = {

                })
        ) {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Non authorised user",
                modifier = Modifier.size(128.dp)
            )
            Column {
                Text(
                    stringResource(id = R.string.basic_family_name),
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 24.sp
                )
                Text(
                    stringResource(id = R.string.basic_second_name),
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 24.sp
                )
            }
            Icon(
                Icons.Filled.KeyboardArrowRight,
                contentDescription = "Go to profile",
                modifier = Modifier
                    .padding(top = 32.dp, start = 100.dp)
                    .size(64.dp)
            )
        }
    }
}