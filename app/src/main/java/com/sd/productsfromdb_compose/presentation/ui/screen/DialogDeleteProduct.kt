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
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sd.productsfromdb_compose.R

@Composable
fun DialogDeleteProduct(
    onClickApprove: () -> Unit = {},
    onClickCancel: () -> Unit = {},
) {

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
                        imageVector = Icons.Filled.Warning,
                        contentDescription = stringResource(R.string.iconwarning),
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(R.string.remove_product),
                        fontSize = 22.sp,
                        color = Color.Black,
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(R.string.do_you_want_to_delete_product),
                        fontSize = 14.sp,
                        color = Color.Black,
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
                        TextButton(onClick = onClickApprove) {
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
fun DialogDeleteProduct_Preview() {
    DialogDeleteProduct {}
}
