package me.adswt518.dog_adoption

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private val items = arrayListOf<Pair<Pair<Int,String>, Triple<Int, String, String>>>()
    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.update(items[position])
        holder.dog.setOnClickListener {
            onItemClickListener.onItemClick(holder.itemView, position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<Pair<Pair<Int,String>, Triple<Int, String, String>>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }
}