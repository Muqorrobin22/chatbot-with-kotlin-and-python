package com.example.chatbot_app_pa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.chatbot_app_pa.R
import com.example.chatbot_app_pa.data.Message
import com.example.chatbot_app_pa.utils.BotResponse
import com.example.chatbot_app_pa.utils.Constant.RECEIVE_ID
import com.example.chatbot_app_pa.utils.Constant.SEND_ID
import com.example.cobaktor.remote.DiseaseService
import io.ktor.client.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MessageAdapter

    // Ktor
//    private val service = DiseaseService.create()
    private val client = HttpClient {}
//    val inferredDisease = listOf<String>("batuk", "pilek", "coba", "panas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView()

        clickEvents()

        customMessage(welcomeWordPython())

//        makeRequestDiseaseCount(inferredDisease)

    }

    fun clickEvents() {
        val sendButton = findViewById<Button>(R.id.btn_send)
        val messageField = findViewById<EditText>(R.id.et_message)

        sendButton.setOnClickListener {
            sendMessage()
        }

        messageField.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main){
                    findViewById<RecyclerView>(R.id.rv_messages).scrollToPosition(adapter.itemCount - 1)
                }
            }
        }

    }


    private fun customMessage(message: String) {
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
//                var timestamp = LocalDateTime.now().toString()
                adapter.insertMessage(Message(message, RECEIVE_ID, "20:44"))

                findViewById<RecyclerView>(R.id.rv_messages).scrollToPosition(adapter.itemCount - 1)

            }
        }
    }

    private fun recyclerView() {
        adapter = MessageAdapter()
        findViewById<RecyclerView>(R.id.rv_messages).adapter = adapter
        findViewById<RecyclerView>(R.id.rv_messages).layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun sendMessage() {
        val message = findViewById<EditText>(R.id.et_message).text.toString()
        val timeStamp = "20:44"

        if(message.isNotEmpty()){
            findViewById<EditText>(R.id.et_message).setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            findViewById<RecyclerView>(R.id.rv_messages).scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = "20:44"

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {

                val response = BotResponse.basicResponses(message)
                adapter.insertMessage(Message(response, RECEIVE_ID, timeStamp))

                findViewById<RecyclerView>(R.id.rv_messages).scrollToPosition(adapter.itemCount - 1)

            }
        }

    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                findViewById<RecyclerView>(R.id.rv_messages).scrollToPosition(adapter.itemCount - 1)
            }
        }

    }

    // Python
    private fun initPython() {
        if (! Python.isStarted()) {
            Python.start( AndroidPlatform(this));
        }
    }

    private fun welcomeWordPython(): String {
        val pythonInstance =Python.getInstance()
        val pythonFiles = pythonInstance.getModule("welcomeWord")
        return pythonFiles.callAttr("welcome").toString()
    }

    // Ktor


    override fun onDestroy() {
        super.onDestroy()
        client.close()
    }

}

