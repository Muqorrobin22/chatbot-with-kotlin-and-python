package com.example.chatbot_app_pa.retrofit

import android.util.Log
import com.example.chatbot_app_pa.retrofit.dto.Disease
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log



object DiseaseImplement {

//    val apiService = retrofit.create(DiseaseApiService::class.java)

//    var diseaseContainer = mutableListOf<Disease>()
//
//    fun requestDisease(path: String) {
//        GlobalScope.launch(Dispatchers.Main) {
//
//            val responses = withContext(Dispatchers.IO) {
//                apiService.getDiseases(path)
//            }
//
//            for(response in responses) {
//                diseaseContainer.add(response)
//                Log.v("Datanya dinamis: ", response.toString())
//            }
//
//            Log.v("Data Dinamis bre: ", responses.toString())
//            Log.v("diseaseContainer: ", diseaseContainer.toString())
//        }
//    }
//
//    fun getInferredDisease(): String {
//        return diseaseContainer.toString()
//    }
}