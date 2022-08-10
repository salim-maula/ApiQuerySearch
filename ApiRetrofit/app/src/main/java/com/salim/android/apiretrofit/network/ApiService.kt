package com.salim.android.apiretrofit.network

import com.salim.android.apiretrofit.data.UserItem
import com.salim.android.apiretrofit.data.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getListUsers() : Call<ArrayList<UsersItem>>

    @GET("users")
    fun getListUser()
            : Call<List<UserItem>>

}