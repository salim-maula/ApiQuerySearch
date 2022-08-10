package com.salim.android.viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//Dalam menyimpan datanya kita akan menggunakan live data

class GetScoreViewModel : ViewModel() {

    private val scoreA: MutableLiveData<Int>? = MutableLiveData()
    private val scoreB: MutableLiveData<Int>? = MutableLiveData()
    //Selain MutableLiveData-> tambahakan data, kita juga punya LiveData()->Hanya baca saja

    fun addScoreA() {
        //disini value = setValue
        val result = getScoreA()?.value?.plus(1)
        //disini value = getValue
        scoreA?.value = result
    }

    fun addScoreB() {
        val result = getScoreB()?.value?.plus(1)
        scoreB?.value = result
    }

    fun minScoreA() {
        val result = getScoreA()?.value?.minus(1)
        if (result!! < 0){
            scoreA?.value = 0
        }else{
            scoreA?.value = result
        }
    }

    fun minScoreB() {
        val result = getScoreB()?.value?.minus(1)
        if (result!! < 0){
            scoreB?.value = 0
        }else{
            scoreB?.value = result
        }
    }

    fun resetScore() {
        scoreA?.value = 0
        scoreB?.value = 0
    }

    fun getScoreA(): LiveData<Int>?{
        if (scoreA?.value == null){
            //ini merupakan cara untuk menyimpan data ke live data
            //Main Thread/UI Thread
            scoreA?.value = 0

            //kalau seandainya berada di Background thread kita menggunakan
//            scoreA?.postValue(0)
        }
        return scoreA
    }

    fun getScoreB(): LiveData<Int>?{
        if (scoreB?.value == null){
            //ini merupakan cara untuk menyimpan data ke live data
            //Main Thread/UI Thread
            scoreB?.value = 0
        }
        return scoreB
    }
}