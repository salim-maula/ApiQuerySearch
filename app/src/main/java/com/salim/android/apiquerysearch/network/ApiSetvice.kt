package com.salim.android.apiquerysearch.network

import com.salim.android.apiquerysearch.data.ResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSetvice {

    @GET("{word}")
    fun getComment(@Path("word") word: String) : Call<List<ResponseItem>>

}