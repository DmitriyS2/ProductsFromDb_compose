package com.sd.productsfromdb_compose.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sd.productsfromdb_compose.domain.api.ChangeAmountUseCase
import com.sd.productsfromdb_compose.domain.api.DeleteProductUseCase
import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
import com.sd.productsfromdb_compose.domain.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val changeAmountUseCase: ChangeAmountUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
) : ViewModel() {

    val data = getAllProductsUseCase()

    private val _currentProduct = MutableLiveData<ProductModel?>()
    val currentProduct: LiveData<ProductModel?>
        get() = _currentProduct

    fun setCurrentProduct(productModel: ProductModel?) {
        _currentProduct.value = productModel
    }

    fun changeAmount(productModel: ProductModel) {
        viewModelScope.launch {
            try {
                changeAmountUseCase(productModel)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            try {
                deleteProductUseCase(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}