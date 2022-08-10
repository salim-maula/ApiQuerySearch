package com.salim.android.apiretrofitcomplex.network

import com.salim.android.apiretrofitcomplex.data.Geo
import com.salim.android.apiretrofitcomplex.data.ResultUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("users")
    fun getUsers(): Call<ArrayList<ResultUserItem>>
}