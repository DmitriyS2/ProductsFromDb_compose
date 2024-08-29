package com.sd.productsfromdb_compose.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sd.productsfromdb_compose.R

@Composable
fun TextField(
    text: MutableState<String>,
    label: String,
    isError: MutableState<Boolean>,
    flagNumber: Boolean = false,
    flagChips: Boolean = false
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        onValueChange = {
            text.value = it
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            errorContainerColor = Color.White,
        ),
        singleLine = true,
        keyboardOptions = if (flagNumber) KeyboardOptions(keyboardType = KeyboardType.Number)
        else KeyboardOptions(keyboardType = KeyboardType.Text),
        keyboardActions = KeyboardActions(onDone = {
            if (checkInputText(text.value, flagNumber, flagChips)) {
                isError.value = false
                keyboardController?.hide()
                focusManager.clearFocus()
            } else {
                isError.value = true
            }
            keyboardController?.hide()
            focusManager.clearFocus()
        }),
        isError = isError.value,
        supportingText = {
            if (isError.value) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.wrong),
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        trailingIcon = {
            if (text.value.isNotEmpty()) {
                IconButton(
                    onClick = {
                        text.value = ""
                    }) {
                    Icon(
                        modifier = Modifier.padding(10.dp),
                        imageVector = Icons.Rounded.Close,
                        tint = Color.Black,
                        contentDescription = stringResource(R.string.iconclose)
                    )
                }
            }
        },
        label = {
            Text(text = label)
        },
    )
}

fun checkInputText(text: String, flagNumber: Boolean, flagChips: Boolean): Boolean {
    if (flagChips) return true
    if (text.isEmpty()) return false
    return when (flagNumber) {
        true -> try {
            val number: Int = text.toInt()
            number >= 0
        } catch (e: Exception) {
            false
        }

        false -> true
    }
}