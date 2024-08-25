package com.sd.productsfromdb_compose.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sd.productsfromdb_compose.R
import com.sd.productsfromdb_compose.presentation.ui.theme.BackgroundColor
import com.sd.productsfromdb_compose.presentation.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    vm: MainViewModel = viewModel(),
) {

    val listProducts by vm.data.observeAsState()
    val currentProduct by vm.currentProduct.observeAsState()

    val searchText = remember {
        mutableStateOf("")
    }
    val showDialogChangeAmount = remember {
        mutableStateOf(false)
    }
    val showDialogDeleteProduct = remember {
        mutableStateOf(false)
    }

    Column {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Список товаров",
                    textAlign = TextAlign.Center,
                )
            },
            colors = TopAppBarColors(
                containerColor = BackgroundColor,
                scrolledContainerColor = BackgroundColor,
                navigationIconContentColor = Color.Black,
                titleContentColor = Color.Black,
                actionIconContentColor = Color.Black
            ),
        )

        listProducts?.let { list ->
            val listAfterFilter = list.filter { product ->
                product.name.lowercase().contains(searchText.value.lowercase())
            }
            LazyColumn {
                item {
                    EditText(searchText)
                }
                itemsIndexed(listAfterFilter) { _, item ->
                    ProductCard(
                        productModel = item,
                        onClickChange = {
                            vm.setCurrentProduct(item)
                            showDialogChangeAmount.value = true
                        },
                        onCLickDelete = {
                            vm.setCurrentProduct(item)
                            showDialogDeleteProduct.value = true
                        },
                    )
                }
            }
        }
    }
    currentProduct?.let { product ->
        if (showDialogChangeAmount.value) {
            DialogChangeAmount(
                amount = product.amount,
                onClickApprove = { newAmount ->
                    vm.changeAmount(product.copy(amount = newAmount))
                    showDialogChangeAmount.value = false
                },
                onClickCancel = {
                    showDialogChangeAmount.value = false
                }
            )
        }
        if (showDialogDeleteProduct.value) {
            DialogDeleteProduct(
                onClickApprove = {
                    vm.deleteProduct(product.id)
                    showDialogDeleteProduct.value = false
                }
            )
        }
    }
}

@Composable
fun EditText(searchText: MutableState<String>) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        value = searchText.value,
        onValueChange = {
            searchText.value = it
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
            if (searchText.value.isNotEmpty()) {
                IconButton(
                    onClick = {
                        searchText.value = ""
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
            Text(text = stringResource(R.string.search_products))
        },
    )
}