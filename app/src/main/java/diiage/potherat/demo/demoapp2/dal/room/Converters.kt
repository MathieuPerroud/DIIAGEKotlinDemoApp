package diiage.potherat.demo.demoapp2.dal.room

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

object Converters {
    @TypeConverter
    fun convertLocalDateTimeToDatabase(dateTime:LocalDateTime): Long {
        return dateTime.toEpochSecond(ZoneOffset.UTC)
    }
    @TypeConverter
    fun convertLocalDateTimeFromDatabase(dateTime:Long): LocalDateTime {
        return LocalDateTime.ofEpochSecond(dateTime,0, ZoneOffset.UTC)
    }
}