package com.example.testapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var expandedPosition = -1 // To track the position of the currently expanded item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.nameTextView.text = itemList[position]
        val subtitle = java.lang.String.format(
            holder.itemView.context.getString(R.string.SUBTITLE_LIST_NAME),
            "${position+1}"
        )
        holder.subtitleTextView.text = subtitle

        // Check if the item should be expanded
        if (position == expandedPosition) {
            holder.subtitleTextView.visibility = View.VISIBLE // Show subtitle
        } else {
            holder.subtitleTextView.visibility = View.GONE // Hide subtitle
        }

        // Set the click listener for expanding/collapsing the item
        holder.itemView.setOnClickListener { v: View? ->
            // Toggle the expanded position
            expandedPosition = if (expandedPosition == position) {
                -1 // Collapse the item if it's already expanded
            } else {
                position // Expand the clicked item
            }
            notifyDataSetChanged() // Refresh the list
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById<TextView>(R.id.item_name)
        var subtitleTextView: TextView = itemView.findViewById<TextView>(R.id.item_subtitle)
    }
}

