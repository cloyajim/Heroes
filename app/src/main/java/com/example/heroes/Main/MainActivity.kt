package com.example.heroes.Main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.heroes.Interfaz.RetrofitServices
import com.example.heroes.Model.HeroeResponse
import com.example.heroes.Retrofit.RetrofitClient
import com.example.heroes.Retrofit.RetrofitClient.getClient
import com.example.heroes.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener { v -> callServiceGetUsers() }

    }

    private fun callServiceGetUsers() {
        val userServise: RetrofitServices = RetrofitClient.getClient()
            .create(RetrofitServices::class.java)
        val call: Call<MutableList<HeroeResponse>> = userServise.getHeroList()

        call.enqueue(object : Callback<MutableList<HeroeResponse>> {
            override fun onResponse(
                call: Call<MutableList<HeroeResponse>>,
                response: Response<MutableList<HeroeResponse>>
            ) {
                Toast.makeText(this@MainActivity,"Error", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<MutableList<HeroeResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Ok", Toast.LENGTH_LONG).show()
            }


        })
    }

    private fun searchByName(query:Boolean){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getClient().create<RetrofitServices>(RetrofitServices::class.java)
                .getHeroList()

        }
    }


}



