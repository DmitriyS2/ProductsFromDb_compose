package com.sd.productsfromdb_compose.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import com.sd.productsfromdb_compose.R

@Composable
fun SearchText(
    text: MutableState<String>,
    label: String,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
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
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            focusManager.clearFocus()
        }),
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(horizontal = 16.dp),
                imageVector = Icons.Rounded.Search,
                tint = Color.Black,
                contentDescription = stringResource(R.string.iconsearch),
            )
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
        label = { Text(text = label) },
    )
}