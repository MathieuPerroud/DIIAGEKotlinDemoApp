package diiage.potherat.demo.demoapp2.ui.edit

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import diiage.potherat.demo.demoapp2.common.SingleLiveEvent
import diiage.potherat.demo.demoapp2.dal.repository.QuoteRepository
import diiage.potherat.demo.demoapp2.model.Quote
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import java.time.LocalDateTime
import java.util.concurrent.ExecutorService

class QuoteEditViewModel @ViewModelInject constructor(private val dispatcher: CoroutineDispatcher, private val repository: QuoteRepository) : ViewModel() {
    val quote:MutableLiveData<String> = MutableLiveData()
    val source:MutableLiveData<String> = MutableLiveData()

    @ExperimentalCoroutinesApi
    private val actionSender = BroadcastChannel<Boolean>(Channel.BUFFERED)
    @FlowPreview
    val actionReceiver = actionSender.asFlow().asLiveData(dispatcher)

    @ExperimentalCoroutinesApi
    fun create(){
        val strquote = quote.value ?: "";
        val strsource = source.value ?: "";

        viewModelScope.launch {
            var id = repository.create(
                Quote(
                    0,
                    quote = strquote,
                    source = strsource,
                    LocalDateTime.now()
                )
            )
            if (id > 0){
                actionSender.offer(true)
            }
        }
    }


}