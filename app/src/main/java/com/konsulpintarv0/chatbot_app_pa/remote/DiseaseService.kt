package com.konsulpintarv0.cobaktor.remote

import com.konsulpintarv0.chatbot_app_pa.remote.dto.DiseaseResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

interface DiseaseService {
    suspend fun getDisease(url: String): List<DiseaseResponse>

    companion object {
        fun create(): DiseaseService {
            return DiseaseServiceImpl (
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation) {
                        json(Json{
                            prettyPrint = true
                            isLenient = true
                        })
                    }
                }
            )
        }
    }
}