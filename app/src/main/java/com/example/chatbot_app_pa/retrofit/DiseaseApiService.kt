package com.example.chatbot_app_pa.retrofit

import com.example.chatbot_app_pa.retrofit.dto.Disease
import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

private const val BASE_URL_DYNAMIC_USING_IPHONE = "http://172.20.10.3:3000/disease/"

//private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(
    BASE_URL_DYNAMIC_USING_IPHONE).build()

interface DiseaseApiService {
    @GET()
    suspend fun getDiseases(@Url url: String): MutableList<Disease>
}

