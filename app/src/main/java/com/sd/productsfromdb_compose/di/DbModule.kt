package com.sd.productsfromdb_compose.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sd.productsfromdb_compose.data.db.AppDb
import com.sd.productsfromdb_compose.data.db.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {
    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, NAME_DB)
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    db.disableWriteAheadLogging()
                }
            })
            .createFromAsset(NAME_DB)
            .build()
    }

    @Provides
    @Singleton
    fun provideNumberDao(
        appDb: AppDb
    ): ProductDao = appDb.productDao()

    private const val NAME_DB = "data.db"
}