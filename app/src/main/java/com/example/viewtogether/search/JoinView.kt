package com.example.viewtogether.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.viewtogether.R

@Composable
fun JoinView(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = stringResource(id = R.string.enter_code), fontSize = 24.sp)
        BasicTextField(
            value = "",
            onValueChange = {},
            textStyle = TextStyle(color = Color.White),
            singleLine = true,
            modifier = Modifier.width(IntrinsicSize.Max)
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.connect_to_conference), fontSize = 24.sp)
        }
    }
}