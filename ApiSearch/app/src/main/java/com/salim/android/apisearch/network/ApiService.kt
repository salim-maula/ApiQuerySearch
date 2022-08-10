package com.salim.android.apisearch.network

import com.salim.android.apisearch.data.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun searchUser(@Query("q") username: String) : Call<UsersResponse>
}