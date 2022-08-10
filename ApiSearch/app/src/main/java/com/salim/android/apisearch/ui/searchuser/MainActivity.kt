package com.salim.android.apisearch.ui.searchuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.salim.android.apisearch.R
import com.salim.android.apisearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val searchUserString = "salim"

        val viewModel= ViewModelProvider(this)[SearchUserViewModel::class.java]
        viewModel.serchUser(searchUserString)
        viewModel.getSearchUser().observe(this){
            Log.i("TAG", "onCreate: $it \n \n \n Nama Usernya ----> ${it.items?.get(0)?.login}")
//            binding.tvNama.text = it.items?.get(0)?.login
            binding.tvNama.text = it.items?.get(1)?.login
        }
    }
}