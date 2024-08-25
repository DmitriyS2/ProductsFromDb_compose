package com.sd.productsfromdb_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sd.productsfromdb_compose.presentation.ui.screen.MainScreen
import com.sd.productsfromdb_compose.presentation.ui.theme.ProductsFromDB_composeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsFromDB_composeTheme {
                MainScreen()
            }
        }
    }
}
