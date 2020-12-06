package diiage.potherat.demo.demoapp2.dal.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import diiage.potherat.demo.demoapp2.dal.room.dao.QuoteDao
import diiage.potherat.demo.demoapp2.model.Quote

@Database(entities = [Quote::class], version = 1)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun quoteDao():QuoteDao
}