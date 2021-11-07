package me.adswt518.clock

import android.app.Activity
import android.os.Bundle
import me.adswt518.clock.R

/**
 *  author : neo
 *  time   : 2021/10/30
 *  desc   :
 */
class ClockActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
    }
}