package me.adswt518.dog_adoption

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.layout_text, parent, false)
) {
    fun update(text: String){

        itemView.findViewById<TextView>(R.id.title).setText(text)

    }

}