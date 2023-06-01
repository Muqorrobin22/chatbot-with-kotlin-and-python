package com.example.cobaktor.remote

import com.example.chatbot_app_pa.remote.dto.DiseaseResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class DiseaseServiceImpl(
    private val client : HttpClient
) : DiseaseService {
    override suspend fun getDisease(url: String): List<DiseaseResponse> {
        return try {
//             client.get(HttpRoute.BASE_URL_VIRTUAL).body<List<DiseaseResponse>>()
            client.get(HttpRoute.BASE_URL_DYNAMIC + url).body<List<DiseaseResponse>>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList<DiseaseResponse>()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList<DiseaseResponse>()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            emptyList<DiseaseResponse>()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList<DiseaseResponse>()
        }
    }
}