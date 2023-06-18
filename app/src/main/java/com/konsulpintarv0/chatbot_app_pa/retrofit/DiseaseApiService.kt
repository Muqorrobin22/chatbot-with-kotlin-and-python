package com.konsulpintarv0.chatbot_app_pa.retrofit

import com.konsulpintarv0.chatbot_app_pa.retrofit.dto.BotResponseDto
import com.konsulpintarv0.chatbot_app_pa.retrofit.dto.Disease
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL_DISEASE_DYNAMIC_USING_IPHONE = "https://oyster-app-o3ffp.ondigitalocean.app/"

//private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(
    BASE_URL_DISEASE_DYNAMIC_USING_IPHONE).build()


interface DiseaseApiService {
    @GET("disease/{url}")
    suspend fun getDiseases(@Path("url") url: String): MutableList<Disease>

    @GET("bot/{path}")
    suspend fun getBotResponse(@Path("path") path: String): MutableList<BotResponseDto>
}

