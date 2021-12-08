package me.adswt518.dog_adoption

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DogRelativeLayoutHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.layout_dog, parent, false)
) {
    var dog: RelativeLayout = itemView.findViewById(R.id.dog)

    fun update(dogInfoPair: Pair<Pair<Int, String>, Triple<Int, String, String>>) {
        itemView.findViewById<ImageView>(R.id.photo).setImageResource(dogInfoPair.first.first)
        itemView.findViewById<TextView>(R.id.name).text = dogInfoPair.first.second
        itemView.findViewById<TextView>(R.id.info).text =
            if (dogInfoPair.second.first == 1){
                "Age: ${dogInfoPair.second.first} year, Gender: ${dogInfoPair.second.second}, Variety: ${dogInfoPair.second.third}"
            }else {
                "Age: ${dogInfoPair.second.first} years, Gender: ${dogInfoPair.second.second}, Variety: ${dogInfoPair.second.third}"
            }
    }
}