package com.raywenderlich.android.recyclerview.listempat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.recyclerview.databinding.ActivityFourthBinding
import com.raywenderlich.android.recyclerview.listempat.model.Post
import com.raywenderlich.android.recyclerview.listempat.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourthActivity : AppCompatActivity() {

    private  val TAG: String = "Check"

    private lateinit var movieAdapter: MovieAdapter

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerview()
        getDataFromApi()
    }

    private fun setUpRecyclerview(){
        movieAdapter = MovieAdapter(arrayListOf())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }

    private fun getDataFromApi(){
        showLoading(true)
        ApiService.endpoint.data()
            .enqueue(object : Callback<Post>{
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    showLoading(false)
                    if (response.isSuccessful){
                        showResult(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    showLoading(false)
                }

            })
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> binding.progressBar.visibility = View.VISIBLE
            false -> binding.progressBar.visibility = View.GONE
        }
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showResult(results: Post){
        for (result in results.result) printLog( "title: ${result.title}" )
        movieAdapter.setData(results.result)
    }
}