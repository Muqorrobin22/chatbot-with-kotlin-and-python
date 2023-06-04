package com.example.chatbot_app_pa.utils

import android.util.Log
import com.chaquo.python.Python
import com.example.chatbot_app_pa.remote.Request
import com.example.chatbot_app_pa.retrofit.DiseaseImplement

// Python Text Processing
fun textProcessingPython(messageFromKotlin: String): String {
    val python = Python.getInstance()
    val pythonFiles = python.getModule("textProcessing")
    return pythonFiles.callAttr("textProcessing", messageFromKotlin).toString()
}

object BotResponse {
    fun basicResponses(_message: String) : String {

        val message = _message.lowercase()

        // The Bot Response from Python AI ( Sistem Pakar )
        
        try {
            val responseBot = textProcessingPython(message)

            var removeBracket = responseBot.replace("[", "").replace("]", "").replace("'", "").replace(", ", ",")
//
            var stringToList = removeBracket.split(",").toList()
//
//
//            Request.makeRequestDiseaseCount(stringToList)

//            Log.v("Response Bot: ", stringToList.toString())
//            Log.v("Response Bot Hardcode: ", "batuk")
//            DiseaseImplement.requestDisease("batuk")
//
//            var diseaseValue = DiseaseImplement.getInferredDisease()
//            Log.v("diseaseValue: ", diseaseValue)

            return "coba"

        } catch (e: Exception) {
            return "Oopss.. Maaf terjadi kesalahan saat membaca gejala :(\n\nMohon masukkan ulang gejala"
        }

    }
}