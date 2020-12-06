package diiage.potherat.demo.demoapp2.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import diiage.potherat.demo.demoapp2.dal.repository.QuoteRepository
import diiage.potherat.demo.demoapp2.model.Quote

class GalleryViewModel @ViewModelInject constructor(repository: QuoteRepository) : ViewModel() {

    val quotes: LiveData<PagingData<Quote>> = Pager(PagingConfig(20, 20),
        pagingSourceFactory = { repository.getAll() }).liveData
}