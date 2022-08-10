package com.raywenderlich.android.recyclerview.listlima

data class ModelCake(
    var id: String = "",
    val type: String? = null,
    val batters: Batters
)

data class Batters(
    val batter: ArrayList<BatterItem>
)

data class BatterItem(
    val id: String?,
    val type: String?
)