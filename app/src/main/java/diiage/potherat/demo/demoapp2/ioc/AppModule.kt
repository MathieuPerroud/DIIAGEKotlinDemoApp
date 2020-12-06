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

// https://www.danstone.uk/2020/06/dependency-injection-hilt-room-database.html

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    lateinit var database: Database

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        // Make sure a read is made before writing so our onCreate callback is executed first
        /*database =  Room.databaseBuilder(
             ntext,
            Database::class.java, "database.db"
        ).fallbackToDestructiveMigration().build()*/
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