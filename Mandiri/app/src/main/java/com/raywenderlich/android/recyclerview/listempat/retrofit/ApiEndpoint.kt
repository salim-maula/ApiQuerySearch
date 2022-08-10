package com.raywenderlich.android.recyclerview.listempat.retrofit

import com.raywenderlich.android.recyclerview.listempat.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("data.php")
    fun data(): Call<Post>

}