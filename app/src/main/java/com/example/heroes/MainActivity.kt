package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroes.Adapter.MyHeroAdapter
import com.example.heroes.Common.Common
import com.example.heroes.Interfaz.RetrofitServices
import com.example.heroes.Model.HeroeResponse
import com.example.heroes.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyHeroAdapter
    //lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mService = Common.retrofitService
        binding.recyclerHeroList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerHeroList.layoutManager = layoutManager// <-- aqui esta el error
        //dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllHeroList()
    }

    private fun getAllHeroList() {
        //dialog.show()
        mService.getHeroList().enqueue(object : Callback<MutableList<HeroeResponse>> {
            override fun onFailure(call: Call<MutableList<HeroeResponse>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<HeroeResponse>>,
                                    response: Response<MutableList<HeroeResponse>>) {
                adapter = MyHeroAdapter(baseContext, response.body() as MutableList<HeroeResponse>)
                adapter.notifyDataSetChanged()
                binding.recyclerHeroList.adapter = adapter

                //dialog.dismiss()
            }
        })
    }
}