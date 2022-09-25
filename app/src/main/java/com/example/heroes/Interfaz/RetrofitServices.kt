package com.example.heroes.Interfaz


import com.example.heroes.Model.HeroeResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("id")
    fun getHeroList(): Call<MutableList<HeroeResponse>>


}