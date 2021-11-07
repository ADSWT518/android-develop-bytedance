package me.adswt518.clock

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
import me.adswt518.clock.R
import java.text.SimpleDateFormat
import java.util.*

/**
 *  author : neo
 *  time   : 2021/10/30
 *  desc   :
 */
class ClockActivity : Activity() {

    companion object {
        const val STATUS_ONE_SECOND = 0
    }

    private var numberClockTextView: TextView? = null
    var clockView: ClockView? = null

    private fun getTime(): String? {
        val format = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return format.format(Date())
    }

    private val handler = Handler(Looper.getMainLooper()) { msg ->
        when (msg.what) {
            STATUS_ONE_SECOND -> {
                numberClockTextView?.text = getTime()
                clockView?.invalidate()
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
        numberClockTextView = findViewById<TextView>(R.id.number_clock)
        clockView = findViewById<ClockView>(R.id.clock)
        var updateTimeThread = UpdateTimeThread()
        updateTimeThread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }


    inner class UpdateTimeThread : Thread() {
        override fun run() {
            super.run()
            updateSecond()
        }

        private fun updateSecond() {
            while (true) {
                Log.d("clockupdate", "abababa")
                val msg = Message.obtain()
                msg.what = STATUS_ONE_SECOND
                handler.sendMessageDelayed(msg, 1000)
            }
        }
    }
}