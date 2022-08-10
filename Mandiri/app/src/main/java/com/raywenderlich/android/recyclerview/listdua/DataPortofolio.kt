package com.raywenderlich.android.recyclerview.listdua

import com.raywenderlich.android.recyclerview.R

object DataPortofolio {

    val namaPortofolio = arrayOf(
        "Membuat Aplikasi Running",
        "Membuat Aplikasi Recipe",
    )

    val imagePortofolio = intArrayOf(
        R.drawable.satu,
        R.drawable.dua,
    )

    val detailPortofolio = arrayOf(
        "Membuat Aplikasi Arimatika perhitungan matematika dll",
        "Membuat Aplikasi Portofolio untuk menampung portofolio pernah dibuat",
    )

    val listData : ArrayList<ModelPortofolio>
        get() {
            val list =ArrayList<ModelPortofolio>()
            for(posisi in namaPortofolio.indices){
                val modelPortofolio = ModelPortofolio()
                modelPortofolio.namaPortofolio = namaPortofolio[posisi]
                modelPortofolio.imagePortofolio = imagePortofolio[posisi]
                modelPortofolio.detail = detailPortofolio[posisi]
                list.add(modelPortofolio)
            }
            return list
        }
}