package diiage.potherat.demo.demoapp2.ui.gallery

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import diiage.potherat.demo.demoapp2.R

class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtQuote: TextView = itemView.findViewById(R.id.txtQuote)
    val txtSource: TextView = itemView.findViewById(R.id.txtSource)
}