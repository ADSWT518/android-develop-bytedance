package me.adswt518.translator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.gson.GsonBuilder
import me.adswt518.translator.api.Trans
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
        }

        override fun responseBodyStart(call: Call) {
            super.responseBodyStart(call)
        }
    }

    val client: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(TimeConsumeInterceptor())
        .eventListener(okhttpListener).build()

    val gson = GsonBuilder().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestBtn = findViewById(R.id.trBtn)
        inputText = findViewById(R.id.trText)
        outputText = findViewById(R.id.trResult)

        requestBtn?.setOnClickListener {
            outputText?.text = ""
            click(inputText?.text.toString())
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
        request(url, object : Callback{
            override fun onFailure(call : Call, e : IOException){
                outputText?.text = e.message
            }

            override fun onResponse(call: Call, response: Response) {
                val bodyString = response.body?.string()
                val youdaoBean = gson.fromJson(bodyString, YoudaoBean::class.java)
                val tranList = youdaoBean.web_trans.web_translation[0].trans
                println(tranList)
                var output : String ?= null
                for (trans in tranList){
                    output += (trans.value + ";")
                }
                outputText?.text = output
            }
        })
    }

}