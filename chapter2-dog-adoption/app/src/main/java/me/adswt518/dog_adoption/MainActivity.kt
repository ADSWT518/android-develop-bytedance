package me.adswt518.dog_adoption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
}