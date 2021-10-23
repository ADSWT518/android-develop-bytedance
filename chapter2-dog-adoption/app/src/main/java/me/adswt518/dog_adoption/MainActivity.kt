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


        val items = arrayListOf<String>()

        for (i in 1..1000) {
            items.add("Hello Android! $i")
        }

        adapter.updateItems(items)


        // 监听 SearchBox 发生输入行为
        findViewById<SearchBox>(R.id.search_box).setTextChangedListener(object :
            SearchBox.ChangedListener {
            override fun onTextChanged(text: String) {

                val filters = items.filter { it.contains(text) }

                adapter.updateItems(filters)

                Log.d("@=>", "onTextChanged: $text")
            }

        }
        )


    }

}