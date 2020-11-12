package com.namanh.lovedays.features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namanh.lovedays.R
import com.namanh.lovedays.core.navigation.Navigator
import kotlinx.android.synthetic.main.memory_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class MemoriesAdapter
@Inject constructor() : RecyclerView.Adapter<MemoriesAdapter.ViewHolder>() {

    internal var collection: List<MemoryView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (MemoryView, Navigator.Extras) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.memory_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(collection[position], clickListener)

    override fun getItemCount(): Int = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(memoryView: MemoryView, clickListener: (MemoryView, Navigator.Extras) -> Unit) {
            itemView.textTitle.text = memoryView.title
            itemView.textDescription.text = memoryView.description
            itemView.textDate.text = "${memoryView.day}-${memoryView.month}-${memoryView.year}"
            itemView.setOnClickListener {
                clickListener(
                    memoryView,
                    Navigator.Extras(itemView.textTitle)
                )
            }
        }
    }
}