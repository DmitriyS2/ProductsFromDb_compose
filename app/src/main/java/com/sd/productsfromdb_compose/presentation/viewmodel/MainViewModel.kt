package com.sd.productsfromdb_compose.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
import com.sd.productsfromdb_compose.domain.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
):ViewModel() {

    val temp = MutableLiveData<List<ProductModel>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                temp.postValue(getAllProductsUseCase())
                Log.d("MyLog", "temp = ${temp.value}")
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }
}