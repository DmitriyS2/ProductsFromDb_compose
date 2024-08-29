package com.sd.productsfromdb_compose.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sd.productsfromdb_compose.R
import com.sd.productsfromdb_compose.domain.model.ProductModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductCard(
    productModel: ProductModel = ProductModel(),
    onClickChange: () -> Unit = {},
    onCLickDelete: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 8.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = productModel.name,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Normal
                    )
                    Row {
                        IconButton(
                            onClick = onClickChange
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Edit,
                                contentDescription = stringResource(R.string.changeamount),
                                tint = Color.Blue
                            )
                        }
                        IconButton(
                            onClick = onCLickDelete
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Delete,
                                contentDescription = stringResource(R.string.deleteproduct),
                                tint = Color.Red
                            )
                        }
                    }
                }
                FlowRow(
                    verticalArrangement = Arrangement.spacedBy((-8).dp),
                ) {
                    productModel.tags.forEach {
                        FilterChip(
                            modifier = Modifier.padding(end = 4.dp),
                            selected = false,
                            onClick = { },
                            label = { Text(it) }
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Box(modifier = Modifier.weight(0.5f)) {
                        Text(
                            text = stringResource(R.string.stock),
                            fontSize = 16.sp,
                        )
                    }
                    Box(modifier = Modifier.weight(0.5f)) {
                        Text(
                            text = stringResource(R.string.date_added),
                            fontSize = 16.sp,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Box(modifier = Modifier.weight(0.5f)) {
                        Text(
                            text = if (productModel.amount == 0) {
                                stringResource(id = R.string.no)
                            } else {
                                productModel.amount.toString()
                            },
                            fontSize = 16.sp,
                        )
                    }
                    Box(modifier = Modifier.weight(0.5f)) {
                        Text(
                            text = getData(productModel.time),
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}

private fun getData(date: Date): String {
    return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date)

}

@Preview
@Composable
fun ProductCard_Preview() {
    ProductCard()
}