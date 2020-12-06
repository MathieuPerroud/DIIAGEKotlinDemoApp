package diiage.potherat.demo.demoapp2.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import diiage.potherat.demo.demoapp2.R
import diiage.potherat.demo.demoapp2.model.Quote


val QUOTE_COMPARATOR = object : DiffUtil.ItemCallback<Quote>() {
    override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean =
        // Quote ID serves as unique ID
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean =
        // Compare full contents (note: Java Quotes should call .equals())
        oldItem == newItem
}

class QuoteAdapter : PagingDataAdapter<Quote, QuoteViewHolder>(QUOTE_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.item_quote,
                parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val repoItem = getItem(position)
        // Note that item may be null, ViewHolder must support binding null item as placeholder
        holder.txtQuote.text = repoItem?.quote
        holder.txtSource.text = repoItem?.source
    }
}