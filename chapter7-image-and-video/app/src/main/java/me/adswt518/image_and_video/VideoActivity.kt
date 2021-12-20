package me.adswt518.image_and_video

import android.graphics.PixelFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import me.adswt518.image_and_video.databinding.ActivityVideoBinding


class VideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    var totalTimeMs = 0
    var stopThread = 0

    companion object {
        const val STATUS_FINISH_UPDATE = 0
        const val CUR_TIME = "currentTime"
    }

    val handler: Handler = Handler(Looper.getMainLooper()) { msg ->
        when (msg.what) {
            STATUS_FINISH_UPDATE -> {
                val totalTime = timeToString(totalTimeMs)
                val curTime = timeToString(msg.data[CUR_TIME] as Int)
                binding.time.text = "$curTime/$totalTime"
                binding.seekBar.max = totalTimeMs
                binding.seekBar.progress = msg.data[CUR_TIME] as Int
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonPause.setOnClickListener { binding.videoView.pause() }
        binding.buttonPlay.setOnClickListener { binding.videoView.start() }
        binding.buttonReplay.setOnClickListener {
            binding.videoView.start()
            binding.videoView.resume()
        }
        binding.videoView.holder.setFormat(PixelFormat.TRANSPARENT)
        binding.videoView.setZOrderOnTop(true)
        binding.videoView.setVideoPath(getVideoPath(R.raw.android_12))

        binding.seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
//                    println("pos:${progress}")
                    binding.videoView.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        val timeUpdateThread = TimeUpdateThread()
        timeUpdateThread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopThread = 1
    }

    private fun getVideoPath(resId: Int): String {
        return "android.resource://" + this.packageName + "/" + resId
    }

    private fun timeToString(timeMs: Int): String {
        val totalSeconds = timeMs / 1000
        val seconds = totalSeconds % 60
        val minutes = totalSeconds / 60 % 60
        val hours = totalSeconds / 3600
        fun format(time: Int): String {
            return if (time >= 10) {
                time.toString()
            } else {
                "0${time}"
            }
        }
        return if (hours == 0) {
            "${format(minutes)}:${format(seconds)}"
        } else {
            "${format(hours)}:${format(minutes)}:${format(seconds)}"
        }
    }

    inner class TimeUpdateThread : Thread() {
        override fun run() {
            super.run()
            update()
        }

        private fun update() {
            while (stopThread == 0) {
                if (binding.videoView.isPlaying) {
                    totalTimeMs = binding.videoView.duration
                    val msg = Message.obtain()
                    msg.what = STATUS_FINISH_UPDATE
                    msg.data = Bundle().apply {
                        putInt(CUR_TIME, binding.videoView.currentPosition)
                    }
                    handler.sendMessage(msg)
                    if (stopThread != 0) {
                        break
                    }
                    sleep(100)// update per 0.1s
                }
            }
        }
    }
}