package com.salim.android.apiretrofitcomplex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.salim.android.apiretrofitcomplex.data.Geo
import com.salim.android.apiretrofitcomplex.data.ResultUserItem
import com.salim.android.apiretrofitcomplex.databinding.ActivityMainBinding
import com.salim.android.apiretrofitcomplex.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val adapterUser = AdapterUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataApi()
    }

    fun setRecycleView(data : List<Geo>){
        val
        for (i in data.indices){

        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }

    private fun getDataApi(){
        ApiConfig.getApiService().getUsers().enqueue(object : Callback<ArrayList<Geo>> {
            override fun onResponse(
                call: Call<ArrayList<Geo>>,
                response: Response<ArrayList<Geo>>
            ) {

                response.body()?.let {
                    setRecycleView(it)
//                   adapterUser.setUser(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<Geo>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }

        })
    }
}