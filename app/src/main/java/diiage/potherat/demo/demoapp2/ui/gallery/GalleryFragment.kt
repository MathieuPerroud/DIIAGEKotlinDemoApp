package diiage.potherat.demo.demoapp2.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.DifferCallback
import androidx.paging.PagedListAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import diiage.potherat.demo.demoapp2.R
import diiage.potherat.demo.demoapp2.model.Quote
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryFragment : Fragment() {
    private val galleryViewModel:GalleryViewModel by viewModels()
    private val adapter : QuoteAdapter = QuoteAdapter()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        val lstQuotes = root.findViewById<RecyclerView>(R.id.lstQuotes)
        lstQuotes.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        lstQuotes.adapter = adapter

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        galleryViewModel.quotes.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch { adapter.submitData(it) }
        })
    }
}