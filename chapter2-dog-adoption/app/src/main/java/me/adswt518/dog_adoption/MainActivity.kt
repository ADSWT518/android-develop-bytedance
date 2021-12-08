package me.adswt518.dog_adoption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list)
        val adapter = SearchAdapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        val items = arrayListOf<Pair<Pair<Int, String>, Triple<Int, String, String>>>()

        for (i in 1..(dogMap.size)) {
            val dogPhoto = dogMap[i]?.first?.first
            val dogName = dogMap[i]?.first?.second
            val dogAge = dogMap[i]?.second?.first
            val dogGender = if (dogMap[i]?.second?.second == true) "Female" else "Male"
            val dogVariety = dogMap[i]?.second?.third
            items.add(
                Pair(
                    Pair(
                        dogPhoto,
                        dogName
                    ),
                    Triple(
                        dogAge,
                        dogGender,
                        dogVariety
                    )
                ) as Pair<Pair<Int, String>, Triple<Int, String, String>>
            )
        }

        adapter.updateItems(items)

        adapter.setOnItemClickListener(object : SearchAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                // position here is the index in List "items", so we need to add 1 to it to get the key in dogMap
                println("click $position item")
                activityIntent(position + 1)
            }
        })

        // 监听 SearchBox 发生输入行为
        findViewById<SearchBox>(R.id.search_box).setTextChangedListener(object :
            SearchBox.ChangedListener {
            override fun onTextChanged(text: String) {
                val filters = items.filter {
                    it.first.second.contains(text, true) or
                            it.second.first.toString().contains(text) or
                            it.second.second.contains(text, true) or
                            it.second.third.contains(text, true)
                }
                adapter.updateItems(filters)
                Log.d("@=>", "onTextChanged: $text")
            }
        }
        )
    }

    fun activityIntent(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}