package com.sd.productsfromdb_compose.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.RemoveCircleOutline
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sd.productsfromdb_compose.R

@Composable
fun DialogChangeAmount(
    amount: Int = 1,
    onClickApprove: (Int) -> Unit = {},
    onClickCancel: () -> Unit = {},
) {
    val showAmount = remember {
        mutableIntStateOf(amount)
    }
    Dialog(onDismissRequest = onClickCancel) {
        Card(
            modifier = Modifier.height(220.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        modifier = Modifier.padding(top = 16.dp),
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = stringResource(id = R.string.iconsettings),
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(R.string.quantity_products),
                        fontSize = 22.sp,
                        color = Color.Black,
                    )
                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(
                            modifier = Modifier.padding(end = 4.dp),
                            onClick = {
                                if (showAmount.intValue != 0) showAmount.intValue -= 1
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.RemoveCircleOutline,
                                contentDescription = stringResource(R.string.iconminus),
                            )
                        }
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = showAmount.intValue.toString(),
                            fontSize = 22.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        IconButton(
                            modifier = Modifier.padding(start = 4.dp),
                            onClick = { showAmount.intValue += 1 },
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.AddCircleOutline,
                                contentDescription = stringResource(R.string.iconplus),
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButton(onClick = onClickCancel) {
                            Text(text = stringResource(R.string.cancel))
                        }
                        TextButton(onClick = { onClickApprove(showAmount.intValue) }) {
                            Text(text = stringResource(R.string.accept))
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DialogChangeAmount_Preview() {
    DialogChangeAmount {}
}