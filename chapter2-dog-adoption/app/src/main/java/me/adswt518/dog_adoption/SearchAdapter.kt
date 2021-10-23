package me.adswt518.dog_adoption

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private val items = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.update(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}