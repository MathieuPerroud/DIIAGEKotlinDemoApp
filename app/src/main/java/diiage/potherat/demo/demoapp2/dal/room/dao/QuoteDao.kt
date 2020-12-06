package diiage.potherat.demo.demoapp2.dal.room.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import diiage.potherat.demo.demoapp2.dal.repository.QuoteRepository
import diiage.potherat.demo.demoapp2.model.Quote

@Dao
interface QuoteDao : QuoteRepository{
    @Query("SELECT * FROM Quote")
    override fun getAll():PagingSource<Int,Quote>
    @Query("SELECT * FROM Quote WHERE id = :id")
    override fun getById(id:Long):LiveData<Quote>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun create(quote: Quote): Long
    @Delete
    override suspend fun delete(quote: Quote)
    @Update
    override suspend fun update(quote: Quote)
}