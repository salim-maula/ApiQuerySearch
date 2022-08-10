package com.raywenderlich.android.recyclerview.listsatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.android.recyclerview.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalList = DataSource(this).getAnimalList()
        binding.recyclerView.adapter = AnimalAdapter(animalList)

    }
}