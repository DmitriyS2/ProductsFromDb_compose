package com.sd.productsfromdb_compose.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sd.productsfromdb_compose.domain.api.ChangeAmountUseCase
import com.sd.productsfromdb_compose.domain.api.DeleteProductUseCase
import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
import com.sd.productsfromdb_compose.domain.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val changeAmountUseCase: ChangeAmountUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
):ViewModel() {

    val data = MutableLiveData<List<ProductModel>>()

    init {
       loadData()
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                data.postValue(getAllProductsUseCase())
                Log.d("MyLog", "temp = ${data.value}")
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }

    fun changeAmount(productModel: ProductModel) {
        viewModelScope.launch {
            changeAmountUseCase(productModel)
        }
    }

    fun deleteProduct(id:Int) {
        viewModelScope.launch {
            deleteProductUseCase(id)
        }
    }
}