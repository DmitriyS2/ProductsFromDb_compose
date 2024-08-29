package com.sd.productsfromdb_compose.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sd.productsfromdb_compose.R
import com.sd.productsfromdb_compose.presentation.ui.component.ProductCard
import com.sd.productsfromdb_compose.presentation.ui.component.SearchText
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
    val showDialogAddNewProduct = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.list_products),
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
        },
        floatingActionButton = {
            FloatingActionButton(
                shape = FloatingActionButtonDefaults.largeShape,
                containerColor = BackgroundColor,
                onClick = {
                    showDialogAddNewProduct.value = true
                }) {
                Icon(Icons.Filled.Add, contentDescription = stringResource(R.string.add))
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { paddingValue ->
        Column(modifier = Modifier.padding(paddingValue)) {
            listProducts?.let { list ->
                val listAfterFilter = list.filter { product ->
                    product.name.lowercase().contains(searchText.value.lowercase())
                }
                LazyColumn {
                    item {
                        SearchText(searchText, stringResource(R.string.search_products))
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
                    },
                    onClickCancel = {
                        showDialogDeleteProduct.value = false
                    }
                )
            }
        }
        if (showDialogAddNewProduct.value) {
            DialogAddNewProduct(
                onClickApprove = { name, chips, stock ->
                    vm.addNewProduct(name, chips, stock)
                    showDialogAddNewProduct.value = false
                },
                onClickCancel = {
                    showDialogAddNewProduct.value = false
                }
            )
        }
    }
}