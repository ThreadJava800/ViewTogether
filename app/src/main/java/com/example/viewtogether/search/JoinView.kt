package com.example.viewtogether.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.viewtogether.R
import com.example.viewtogether.utils.CODE_LENGTH

@Composable
fun JoinView(navController: NavController) {
    val errorMessage = stringResource(id = R.string.error_in_code)
    var code by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }

    fun containsError(string: String): Boolean {
        return !(string.length == CODE_LENGTH && string.isDigitsOnly())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.enter_code), fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        TextField(
            value = code,
            label = { Text(stringResource(id = R.string.enter_code)) },
            onValueChange = {
                code = it
                isError = containsError(code)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            isError = isError,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .semantics {
                    if (isError) {
                        error(errorMessage)
                    }
                }.padding(start = 16.dp),
            placeholder = { Text(stringResource(id = R.string.enter_code)) },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.then(Modifier.size(24.dp)),
                    onClick = {
                        code = ""
                        isError = false
                    }
                ) {
                    if (isError) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "Clear field",
                            tint = Color.Red
                        )
                    } else {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "Clear field",
                        )
                    }
                }
            }
        )
        // text for error message
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .alpha(if (isError) 1f else 0f)
            )
        }
        Button(modifier = Modifier.padding(top = 16.dp), onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.connect_to_conference), fontSize = 24.sp)
        }
    }
}