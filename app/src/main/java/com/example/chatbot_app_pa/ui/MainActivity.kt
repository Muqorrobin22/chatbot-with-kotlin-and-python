package com.example.chatbot_app_pa.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.chatbot_app_pa.R
import com.example.chatbot_app_pa.data.Message
import com.example.chatbot_app_pa.remote.Request
import com.example.chatbot_app_pa.retrofit.DiseaseApiService
//import com.example.chatbot_app_pa.retrofit.bot
import com.example.chatbot_app_pa.retrofit.dto.BotResponseDto
import com.example.chatbot_app_pa.retrofit.dto.Disease
import com.example.chatbot_app_pa.retrofit.retrofit
import com.example.chatbot_app_pa.utils.BotResponse
import com.example.chatbot_app_pa.utils.Constant.RECEIVE_ID
import com.example.chatbot_app_pa.utils.Constant.SEND_ID
import com.example.chatbot_app_pa.utils.textProcessingPython
import com.example.cobaktor.remote.DiseaseService
import io.ktor.client.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MessageAdapter

    // Ktor
//    private val service = DiseaseService.create()
    private val client = HttpClient {}
//    val inferredDisease = listOf<String>("batuk", "pilek", "coba", "panas")
//    val apiService = retrofit.create(DiseaseApiService::class.java)
    val apiService = retrofit.create(DiseaseApiService::class.java)
//    val botService = bot.create(BotApiService::class.java)
    var getInferredDisease = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView()

        clickEvents()

        customMessage(welcomeWordPython())

    }

    fun getRequestDisease(path: List<String>) {

        var diseaseContainer = mutableListOf<Disease>()


            GlobalScope.launch(Dispatchers.Main) {
                try {
                    for (url in path) {
                        val responses = withContext(Dispatchers.IO) {
                            apiService.getDiseases(url)
                        }
                        diseaseContainer.addAll(responses)
                    }

                    var messageTotal = calculateTotal(diseaseContainer)

                    var getDiseaseNameByMaxWeight = getDiseaseWithMaxTotal(messageTotal)

                    getInferredDisease = getDiseaseNameByMaxWeight

                    Log.v("Datanya dinamis(main): ", path.toString())
                    Log.v("Data Total: ", diseaseContainer.toString())
                    Log.v("Nama Penyakit: ", getDiseaseNameByMaxWeight.toString())
                    Log.v("Get Inferred Disease", getInferredDisease)

                    val responses =  apiService.getBotResponse(getDiseaseNameByMaxWeight)

                    Log.v("Inferred Disease beb ", responses.toString())

                    val finalResponse = getOutputBot(responses)

                    customMessage(finalResponse)

                    Log.v("Final Response ", finalResponse)
                }
                catch (e: Exception) {
                    customMessage("Maaf Terjadi Kesalahan saat mengambil data.\n\nTunggu Beberapa Saat atau Cek Internet Kamu\n\nTerima Kasih")
                }

            }


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

                val response = baseResponseBot(message)
                if(response.isNotEmpty()) {
                    adapter.insertMessage(Message(response, RECEIVE_ID, timeStamp))
                    findViewById<RecyclerView>(R.id.rv_messages).scrollToPosition(adapter.itemCount - 1)
                }

            }
        }

    }

    private fun textProcessingPython(messageFromKotlin: String): String {
        val python = Python.getInstance()
        val pythonFiles = python.getModule("textProcessing")
        return pythonFiles.callAttr("textProcessing", messageFromKotlin).toString()
    }


    fun baseResponseBot(_message: String): String {
        val message = _message.lowercase()

        try {
            val responseBot = textProcessingPython(message)

            var removeBracket = responseBot.replace("[", "").replace("]", "").replace("'", "").replace(", ", ",")
//
            var stringToList = removeBracket.split(",").toList()


            getRequestDisease(stringToList)

            return ""

        } catch (e: Exception) {
            return "Oopss.. Maaf terjadi kesalahan saat membaca gejala :(\n\nMohon masukkan ulang gejala"
        }
    }


    fun calculateTotal(data: MutableList<Disease>): Map<String, Int> {
        Log.v("dalam CalculateTotal: ", data.toString())
        return data.groupingBy { it.disease_name }
            .aggregate { _, accumulator: Int?, element, _ ->
                accumulator?.plus(element.value_weight) ?: element.value_weight
            }
    }

    fun getDiseaseWithMaxTotal(data: Map<String, Int>): String {
        Log.v("MaxTotal", data.toString())

        if (data.isEmpty()) {
            return "Unknown"
        }

        val maxData = data.maxBy { it.value }.value
        val diseaseData = data.maxBy { it.value }.key

        return if (maxData >= 50) {
            diseaseData
        } else {
            "bobot_kurang"
        }
    }

    fun getOutputBot(response: MutableList<BotResponseDto>) : String {
        return response.getOrNull(0)?.output_bot.toString()
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

