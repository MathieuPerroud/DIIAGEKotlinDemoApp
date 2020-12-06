package diiage.potherat.demo.demoapp2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity()
data class Quote (@PrimaryKey(autoGenerate = true) val id:Long, val quote: String, val source: String, val date: LocalDateTime)