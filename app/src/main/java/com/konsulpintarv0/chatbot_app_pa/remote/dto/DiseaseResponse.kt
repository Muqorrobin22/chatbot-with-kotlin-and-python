package com.konsulpintarv0.chatbot_app_pa.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class DiseaseResponse(
    val disease_name: String,
    val value_weight: Int
)