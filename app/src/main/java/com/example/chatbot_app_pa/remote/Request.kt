package com.example.chatbot_app_pa.remote

import android.util.Log
import android.widget.TextView
import com.example.cobaktor.remote.DiseaseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



object Request {
    private val service = DiseaseService.create()
    fun makeRequestDiseaseCount(diseases : List<String>) {

        for (disease in diseases) {
            GlobalScope.launch(Dispatchers.Main) {
                service.getDisease(disease)
//                Log.v("Datanya dinamis: ", service.getDisease(disease).toString())
            }
        }
    }
}