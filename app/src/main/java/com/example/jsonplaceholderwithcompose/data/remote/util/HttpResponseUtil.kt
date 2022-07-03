package com.example.jsonplaceholderwithcompose.data.remote.util

import io.ktor.client.features.*

suspend fun <T> generalResponse(request: suspend () -> T): T? {
    return try {
        request()
    } catch (e: Exception) {
        when (e) {
            is RedirectResponseException -> {
                println("Error: ${e.response.status.description}")
            }
            is ClientRequestException -> {
                println("Error: ${e.response.status.description}")
            }
            is ServerResponseException -> {
                println("Error: ${e.response.status.description}")
            }
        }
        null
    }
}