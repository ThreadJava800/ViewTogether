package com.example.viewtogether.create

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.viewtogether.R

@Composable
fun CreateView(navController: NavController) {
    var link by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(stringResource(id = R.string.choose_file), fontSize = 24.sp)
        }
        Text(text = "or", fontSize = 24.sp, modifier = Modifier.padding(top = 16.dp))
        Text(text = "Provide a link to youtube", fontSize = 24.sp, modifier = Modifier.padding(top = 16.dp))
        TextField(
            value = link,
            label = { Text(stringResource(id = R.string.youtube_link_label)) },
            onValueChange = {
                link = it
            },
            singleLine = true,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .padding(top = 16.dp),
            placeholder = { Text(stringResource(id = R.string.youtube_link_placeholder), fontSize = 24.sp) },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.then(Modifier.size(24.dp)),
                    onClick = {
                        link = ""
                    }
                ) {
                    Icon(
                        Icons.Filled.Clear,
                        contentDescription = "Clear field",
                    )
                }
            }
        )
    }
}