package com.sd.productsfromdb_compose.di

import com.sd.productsfromdb_compose.data.repository.ProductRepositoryImpl
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsProductRepository(impl: ProductRepositoryImpl): ProductRepository
}