package com.raywenderlich.android.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.android.recyclerview.databinding.ActivityMainBinding
import com.raywenderlich.android.recyclerview.listdua.SecondActivity
import com.raywenderlich.android.recyclerview.listempat.FourthActivity
import com.raywenderlich.android.recyclerview.listlima.FifthActivity
import com.raywenderlich.android.recyclerview.listsatu.FirstActivity
import com.raywenderlich.android.recyclerview.listtiga.ThirdActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewSatu.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerViewDua.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerViewTiga.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerViewEmpat.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }
        binding.recycleViewLima.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
    }

}