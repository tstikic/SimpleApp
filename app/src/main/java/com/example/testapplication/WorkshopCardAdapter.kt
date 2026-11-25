package com.example.testapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

data class WorkshopCard(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)

class WorkshopCardAdapter(private val cards: List<WorkshopCard>) :
    RecyclerView.Adapter<WorkshopCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.workshop_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.iconView.setImageResource(card.icon)
        holder.titleView.setText(card.title)
        holder.descriptionView.setText(card.description)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconView: ImageView = itemView.findViewById(R.id.workshop_card_icon)
        val titleView: TextView = itemView.findViewById(R.id.workshop_card_title)
        val descriptionView: TextView = itemView.findViewById(R.id.workshop_card_description)
    }
}
