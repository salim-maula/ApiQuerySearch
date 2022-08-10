package com.salim.android.apiretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.salim.android.apiretrofit.R
import com.salim.android.apiretrofit.adapter.AdapterUser
import com.salim.android.apiretrofit.data.UserItem
import com.salim.android.apiretrofit.data.UsersItem
import com.salim.android.apiretrofit.databinding.ActivityMainBinding
import com.salim.android.apiretrofit.network.ApiConfig
import com.salim.android.apiretrofit.network.ApiService
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

        //getApi
        getDataApi()

        //setLayout
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = adapterUser
//        }


    }

    fun setRecycleView(data : List<UserItem>){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }

    private fun getDataApi(){
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<List<UserItem>>{
            override fun onResponse(
                call: Call<List<UserItem>>,
                response: Response<List<UserItem>>
            ) {
                response.body()?.let {
//                    adapterUser.setUser(it)
                    setRecycleView(it)
                }
            }

            override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }

        })
//        {
//            override fun onResponse(
//                call: Call<ArrayList<UsersItem>>,
//                response: Response<ArrayList<UsersItem>>
//            ) {
//
//               response.body()?.let {
//                   setRecycleView(it)
////                   adapterUser.setUser(it)
//               }
//            }
//
//            override fun onFailure(call: Call<ArrayList<UsersItem>>, t: Throwable) {
//                Log.e("TAG", "onFailure: $t", )
//            }
//
//        }

    }
}