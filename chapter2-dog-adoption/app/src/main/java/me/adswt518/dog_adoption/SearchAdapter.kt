package me.adswt518.dog_adoption

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private val items = arrayListOf<Pair<Pair<Int,String>, Triple<Int, String, String>>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.update(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<Pair<Pair<Int,String>, Triple<Int, String, String>>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}