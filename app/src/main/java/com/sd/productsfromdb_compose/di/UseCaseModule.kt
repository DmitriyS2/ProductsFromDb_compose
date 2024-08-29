package com.sd.productsfromdb_compose.di

import com.sd.productsfromdb_compose.domain.api.AddNewProductUseCase
import com.sd.productsfromdb_compose.domain.api.ChangeAmountUseCase
import com.sd.productsfromdb_compose.domain.api.DeleteProductUseCase
import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
import com.sd.productsfromdb_compose.domain.impl.AddNewProductUseCaseImpl
import com.sd.productsfromdb_compose.domain.impl.ChangeAmountUseCaseImpl
import com.sd.productsfromdb_compose.domain.impl.DeleteProductUseCaseImpl
import com.sd.productsfromdb_compose.domain.impl.GetAllProductsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetAllProductUseCase(impl: GetAllProductsUseCaseImpl): GetAllProductsUseCase

    @Binds
    fun bindChangeAmountUseCase(impl: ChangeAmountUseCaseImpl): ChangeAmountUseCase

    @Binds
    fun bindDeleteProductUseCase(impl: DeleteProductUseCaseImpl): DeleteProductUseCase

    @Binds
    fun bindAddNewProductUseCase(impl: AddNewProductUseCaseImpl): AddNewProductUseCase
}