package diiage.potherat.demo.demoapp2.dal.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Query
import diiage.potherat.demo.demoapp2.model.Quote

interface QuoteRepository {

    fun getAll(): PagingSource<Int, Quote>
    fun getById(id: Long): LiveData<Quote>

    suspend fun create(quote: Quote):Long
    suspend fun delete(quote: Quote)
    suspend fun update(quote: Quote)
}