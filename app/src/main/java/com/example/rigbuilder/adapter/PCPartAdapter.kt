package com.example.rigbuilder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rigbuilder.R
import com.example.rigbuilder.data.PCPart
import java.util.Locale

class PCPartAdapter(
    private val parts: List<PCPart>,
    private val onItemClick: (PCPart) -> Unit
) : RecyclerView.Adapter<PCPartAdapter.PCPartViewHolder>() {

    class PCPartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textPartName: TextView = itemView.findViewById(R.id.textPartName)
        val textPartCategory: TextView = itemView.findViewById(R.id.textPartCategory)
        val textPartBrand: TextView = itemView.findViewById(R.id.textPartBrand)
        val textPartPrice: TextView = itemView.findViewById(R.id.textPartPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCPartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_part, parent, false)
        return PCPartViewHolder(view)
    }

    override fun onBindViewHolder(holder: PCPartViewHolder, position: Int) {
        val part = parts[position]
        holder.textPartName.text = part.name
        holder.textPartCategory.text = "Category: ${part.category}"
        holder.textPartBrand.text = "Brand: ${part.brand}"
        holder.textPartPrice.text = String.format(Locale.US, "$%.2f", part.price)

        holder.itemView.setOnClickListener {
            onItemClick(part)
        }
    }

    override fun getItemCount(): Int = parts.size
}