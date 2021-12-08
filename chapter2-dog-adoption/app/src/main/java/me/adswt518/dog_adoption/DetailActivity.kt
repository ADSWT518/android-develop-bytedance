package me.adswt518.dog_adoption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val position = intent.extras?.getInt("position")
        dogMap[position]?.let {
            findViewById<ImageView>(R.id.photo_detail).setImageResource(it.first.first)
            findViewById<TextView>(R.id.name_detail).text = it.first.second
            findViewById<TextView>(R.id.info_detail).text =
                "Age: ${it.second.first} years, Gender: ${it.second.second}, Variety: ${it.second.third}"
            findViewById<TextView>(R.id.description).text = it.third
        }
    }
}