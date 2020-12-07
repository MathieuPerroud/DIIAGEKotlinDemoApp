package diiage.potherat.demo.demoapp2.ioc

import android.content.Context
import android.util.AndroidException
import androidx.room.Room
import dagger.Module

import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import diiage.potherat.demo.demoapp2.dal.repository.QuoteRepository
import diiage.potherat.demo.demoapp2.dal.room.Database
import diiage.potherat.demo.demoapp2.dal.room.dao.QuoteDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    lateinit var database: Database

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        database =  Room.inMemoryDatabaseBuilder(
            context,
            Database::class.java,
        ).build()
        return database
    }

    @Provides
    fun provideQuoteRepository(database: Database): QuoteRepository {
        return database.quoteDao()
    }

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

}