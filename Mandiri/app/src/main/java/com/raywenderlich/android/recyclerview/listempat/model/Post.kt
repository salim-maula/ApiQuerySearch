package com.raywenderlich.android.recyclerview.listempat.model

data class Post(val result: ArrayList<Result>) {
    data class Result(
        val id: Int, val title: String, val image: String
    )
}