package com.raywenderlich.android.recyclerview.listtiga

import android.content.Context
import android.widget.Toast
import com.raywenderlich.android.recyclerview.databinding.ActivityThirdBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets


//class DataPahlawan(val ctx: Context) {
//
//
//    lateinit var pahlawanAdapter: PahlawanAdapter
//    lateinit var binding: ActivityThirdBinding
//    fun getPahlawanList(): MutableList<ModelPahlawan> {
//         val modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
//         try {
//            val stream = ctx.assets.open("pahlawan_nasional.json")
//            val size = stream.available()
//            val buffer = ByteArray(size)
//            stream.read(buffer)
//            stream.close()
//            val strContent = String(buffer, StandardCharsets.UTF_8)
//            try {
//                val jsonObject = JSONObject(strContent)
//                val jsonArray = jsonObject.getJSONArray("daftar-pahlawan")
//                for (i in 0 until jsonArray.length()) {
//                    val jsonObjectData = jsonArray.getJSONObject(i)
//                    val dataApi = ModelPahlawan()
//                    dataApi.nama = jsonObjectData.getString("nama")
//                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
//                    dataApi.kategori = jsonObjectData.getString("kategori")
//                    dataApi.image = jsonObjectData.getString("img")
//                    dataApi.asal = jsonObjectData.getString("asal")
//                    dataApi.usia = jsonObjectData.getString("usia")
//                    dataApi.lahir = jsonObjectData.getString("lahir")
//                    dataApi.gugur = jsonObjectData.getString("gugur")
//                    dataApi.lokasimakam = jsonObjectData.getString("lokasimakam")
//                    dataApi.history = jsonObjectData.getString("history")
//                    modelPahlawan.add(dataApi)
//                }
//                pahlawanAdapter = PahlawanAdapter(ctx, modelPahlawan)
//                binding.rvListPahlawan.adapter = pahlawanAdapter
//            } catch (e: JSONException) {
//                e.printStackTrace()
//            }
//        } catch (ignored: IOException) {
//            Toast.makeText(ctx, "Ops ada data yang tidak beres", Toast.LENGTH_LONG).show()
//        }
//       return modelPahlawan
//    }
//}