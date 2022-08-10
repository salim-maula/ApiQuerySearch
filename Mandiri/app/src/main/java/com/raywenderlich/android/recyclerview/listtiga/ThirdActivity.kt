package com.raywenderlich.android.recyclerview.listtiga

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.recyclerview.R
import com.raywenderlich.android.recyclerview.databinding.ActivityThirdBinding
import com.raywenderlich.android.recyclerview.listdua.AdapterPortofolio
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class ThirdActivity : AppCompatActivity() {

    private var modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
    lateinit var mainAdapter: PahlawanAdapter

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val listPahlawan  = DataPahlawan(this).getPahlawanList()
//        modelPahlawan = listPahlawan

        binding.rvListPahlawan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ThirdActivity)
//            adapter = PahlawanAdapter(this@ThirdActivity, listPahlawan)
        }
        mainAdapter = PahlawanAdapter(this, modelPahlawan)
        binding.rvListPahlawan.adapter = mainAdapter

        getListPahlawan()

    }

    private fun getListPahlawan() {

        val strContent = getJSONObject()
            try {
                val jsonObject = JSONObject(strContent)
                val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")
                for (i in 0 until jsonArray.length()) {
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = ModelPahlawan()
                    dataApi.nama = jsonObjectData.getString("nama")
                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
                    dataApi.kategori = jsonObjectData.getString("kategori")
                    dataApi.image = jsonObjectData.getString("img")
                    dataApi.asal = jsonObjectData.getString("asal")
                    dataApi.usia = jsonObjectData.getString("usia")
                    dataApi.lahir = jsonObjectData.getString("lahir")
                    dataApi.gugur = jsonObjectData.getString("gugur")
                    dataApi.lokasimakam = jsonObjectData.getString("lokasimakam")
                    dataApi.history = jsonObjectData.getString("history")
                    modelPahlawan.add(dataApi)
                }

            } catch (e: JSONException) {
                e.printStackTrace()
//                Log.e("Error", e.toString())
            }
    }

    private fun getJSONObject(): String? {
        val stream: String
        try {
             stream = assets.open("pahlawan_nasional.json").bufferedReader().use { it.readText() }
//            val size = stream.available()
//            val buffer = ByteArray(size)
//            stream.read(buffer)
//            stream.close()
            //
//            strContent = String(StandardCharsets.UTF_8)
        } catch (e: IOException) {
            Log.e("TAG", "getJSONObject: $e")
            return null
        }
        return stream
    }

    fun AssetManager.readAssetsFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }
}