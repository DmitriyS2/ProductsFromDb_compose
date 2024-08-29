package com.sd.productsfromdb_compose.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sd.productsfromdb_compose.R
import com.sd.productsfromdb_compose.presentation.ui.component.TextField

@Composable
fun DialogAddNewProduct(
    onClickApprove: (name: String, chips: String, stock: String) -> Unit =
        { _: String, _: String, _: String -> },
    onClickCancel: () -> Unit = {},
) {
    val isErrorName = remember {
        mutableStateOf(false)
    }
    val isErrorChips = remember {
        mutableStateOf(false)
    }
    val isErrorStock = remember {
        mutableStateOf(false)
    }

    val newName = remember {
        mutableStateOf("")
    }
    val newChips = remember {
        mutableStateOf("")
    }
    val newStock = remember {
        mutableStateOf("")
    }


    Dialog(onDismissRequest = onClickCancel) {
        Card(
            modifier = Modifier.height(400.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        modifier = Modifier.padding(top = 16.dp),
                        imageVector = Icons.Rounded.AddCircleOutline,
                        contentDescription = stringResource(R.string.iconadd),
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(R.string.add_new_product),
                        fontSize = 22.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        text = newName,
                        label = stringResource(R.string.title),
                        isError = isErrorName
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        text = newChips, label = stringResource(R.string.tags),
                        isError = isErrorChips, flagChips = true
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        text = newStock,
                        label = stringResource(R.string.stock_warehouse),
                        isError = isErrorStock,
                        flagNumber = true
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButton(onClick = onClickCancel) {
                            Text(text = stringResource(R.string.no))
                        }
                        TextButton(onClick = {
                            if (!isErrorName.value && newName.value.isNotEmpty()
                                && !isErrorChips.value
                                && !isErrorStock.value && newStock.value.isNotEmpty()
                            ) {
                                onClickApprove(newName.value, newChips.value, newStock.value)
                            }
                        }) {
                            Text(text = stringResource(R.string.yes))
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DialogAddNewProduct_Preview() {
    DialogAddNewProduct {}
}
