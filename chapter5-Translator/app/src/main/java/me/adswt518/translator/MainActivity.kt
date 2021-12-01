package me.adswt518.translator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.gson.GsonBuilder
import me.adswt518.translator.api.YoudaoBean
import me.adswt518.translator.interceptor.TimeConsumeInterceptor
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var requestBtn: Button? = null
    var inputText: EditText? = null
    var outputText: TextView? = null

    val okhttpListener = object : EventListener() {
        override fun dnsStart(call: Call, domainName: String) {
            super.dnsStart(call, domainName)
            Log.i("Translator", "Dns Search: $domainName")
        }

        override fun responseBodyStart(call: Call) {
            super.responseBodyStart(call)
            Log.i("Translator", "Response Start")
        }
    }

    val client: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(TimeConsumeInterceptor())
        .eventListener(okhttpListener).build()

    val gson = GsonBuilder().create()

    companion object {
        const val STATUS_FINISH_TRANSLATION = 0
        const val RESULT = "result"
    }

    val handler: Handler = Handler(Looper.getMainLooper()) { msg ->
        when (msg.what) {
            STATUS_FINISH_TRANSLATION -> {
                outputText?.text = "${msg.data[RESULT]}"
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestBtn = findViewById(R.id.trBtn)
        inputText = findViewById(R.id.trText)
        outputText = findViewById(R.id.trResult)

        requestBtn?.setOnClickListener {
            outputText?.text = ""
            val translationThread = TranslationThread()
            translationThread.start()
        }
    }

    fun request(url: String, callback: Callback) {
        val request: Request = Request.Builder()
            .url(url)
            .header("User-Agent", "My-translator")
            .build()
        client.newCall(request).enqueue(callback)
    }

    fun click(text: String) {
        val url = "https://dict.youdao.com/jsonapi?q=$text"
        request(url, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                outputText?.text = e.message
            }

            override fun onResponse(call: Call, response: Response) {
                val bodyString = response.body?.string()
                val youdaoBean = gson.fromJson(bodyString, YoudaoBean::class.java)
                val tranList = youdaoBean.web_trans.web_translation[0].trans
                println(tranList)
                var output: String? = ""
                for (trans in tranList) {
                    output += (trans.value + "；")
                }
                output = output?.substring(0, output?.length - 1)
                val msg = Message.obtain()
                msg.what = STATUS_FINISH_TRANSLATION
                msg.data = Bundle().apply {
                    putString(RESULT, output)
                }
                handler.sendMessage(msg)
            }
        })
    }

    inner class TranslationThread : Thread() {
        override fun run() {
            super.run()
            transition()
        }

        private fun transition() {
            click(inputText?.text.toString())
        }
    }
}