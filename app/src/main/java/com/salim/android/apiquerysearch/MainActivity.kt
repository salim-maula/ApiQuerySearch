package com.salim.android.apiquerysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.salim.android.apiquerysearch.adapter.AdapterResponse
import com.salim.android.apiquerysearch.data.ResponseItem
import com.salim.android.apiquerysearch.databinding.ActivityMainBinding
import com.salim.android.apiquerysearch.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapterResponse = AdapterResponse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
//        getDataApi(1)

        gerSearch()
    }

    private fun gerSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    getDataApi(it.toInt())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    fun setRecyclerView(data: List<ResponseItem>) {
        binding.rvResponse.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterResponse
            adapterResponse.setResponse(data)
        }
    }




    private fun getDataApi(id : Int) {
        ApiConfig.getApiService().getComment(id).enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                response.body()?.let {
                    setRecyclerView(it)
                }
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }

}