package com.salim.android.apisearch.ui.searchuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salim.android.apisearch.data.UsersResponse
import com.salim.android.apisearch.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUserViewModel : ViewModel() {
    private val listUser = MutableLiveData<UsersResponse>()

    fun serchUser(username : String){
        ApiConfig.getApiService().searchUser(username).enqueue(object : Callback<UsersResponse>{
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }

        })
    }

    fun getSearchUser(): LiveData<UsersResponse> = listUser
}