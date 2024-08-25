package com.sd.productsfromdb_compose.di

import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
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
}