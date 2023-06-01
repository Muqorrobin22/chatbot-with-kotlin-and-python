package com.example.cobaktor.remote

object HttpRoute {

    // Url for real device android with ip:
    const val BASE_URL = "http://192.168.0.18:3000/disease/pilek"

    // Url for AVD ( Android Virtual Device )
    const val BASE_URL_VIRTUAL = "http://10.0.2.2:3000/disease/pilek"

    // Url for Dinamic route base on real device
    const val BASE_URL_DYNAMIC = "http://172.20.10.3:3000/disease/"
}