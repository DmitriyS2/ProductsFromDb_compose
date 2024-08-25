package com.sd.productsfromdb_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sd.productsfromdb_compose.data.mapper.Mapper
import com.sd.productsfromdb_compose.presentation.ui.theme.ProductsFromDB_composeTheme
import com.sd.productsfromdb_compose.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductsFromDB_composeTheme {
                val vm: MainViewModel = viewModel()
                val mapper = Mapper()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val n by vm.temp.observeAsState()
                    Text(
                        text = "vm.temp = $n",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
