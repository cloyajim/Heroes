package com.example.heroes.Common

import com.example.heroes.Interfaz.RetrofitServices
import com.example.heroes.Retrofit.RetrofitClient

object Common {
    private const val token = 5002349733202132
    private val BASE_URL = "https://superheroapi.com/api/$token/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}