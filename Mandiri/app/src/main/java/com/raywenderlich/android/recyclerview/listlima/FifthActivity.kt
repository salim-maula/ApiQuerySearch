package com.raywenderlich.android.recyclerview.listlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.android.recyclerview.databinding.ActivityFifthBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class FifthActivity : AppCompatActivity() {

    private var modelCake = ArrayList<BatterItem>()

    private var _binding : ActivityFifthBinding? = null
    private val binding get() = _binding as ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getButterJson()

        val cakeAdapter = AdapterCake(modelCake)
        binding.rvItemCake.adapter = cakeAdapter


    }

    private fun getButterJson(){
        val json = getJsonFromAsset()
        try {
            val getRootJson = JSONArray(json)
            for (i in 0 until getRootJson.length()){
                val jsonObjectData = getRootJson.getJSONObject(i)
                val getBatters = jsonObjectData.getJSONObject("batters")
                val getBatter = getBatters.getJSONArray("batter")
                for (u in 0 until getBatter.length()){
                    val batterItem = getBatter.getJSONObject(u)
                    val dataJson = BatterItem(
                        id = batterItem.getString("id"),
                        type = batterItem.getString("type")
                    )
                    modelCake.add(dataJson)
                }

            }
        }catch (e: JSONException) {
            e.printStackTrace()
//                Log.e("Error", e.toString())
        }
    }

    fun getJsonFromAsset(): String? {
        val stream: String
        try {
            stream = assets.open("cake.json").bufferedReader().use { it.readText() }

        } catch (e: IOException) {
            Log.e("TAG", "getJSONObject: $e")
            return null
        }
        return stream
    }
}