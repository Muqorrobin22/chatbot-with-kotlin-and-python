package com.example.chatbot_app_pa.utils

import com.chaquo.python.Python
import com.example.chatbot_app_pa.remote.Request

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
        val responseBot = textProcessingPython(message)

        var removeBracket = responseBot.replace("[", "").replace("]", "").replace("'", "").replace(", ", ",")

        var stringToList = removeBracket.split(",").toList()


        Request.makeRequestDiseaseCount(stringToList)

        return removeBracket

    }
}