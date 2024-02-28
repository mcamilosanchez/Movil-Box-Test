package com.example.testmovilbox.app.di

import android.content.Context
import androidx.room.Room
import com.example.testmovilbox.domain.database.ProductDataBase
import com.example.testmovilbox.domain.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val PRODUCT_DATABASE_NAME = "product_database"

    @Singleton
    @Provides
    fun providerRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ProductDataBase::class.java, PRODUCT_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideProductDao(dataBase: ProductDataBase): ProductDao = dataBase.getProductDao()

}