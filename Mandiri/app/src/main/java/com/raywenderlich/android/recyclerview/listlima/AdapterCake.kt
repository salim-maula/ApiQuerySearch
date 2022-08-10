package com.raywenderlich.android.recyclerview.listlima

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.recyclerview.databinding.ItemCakeBinding

class AdapterCake(val cakeList: ArrayList<BatterItem>): RecyclerView.Adapter<AdapterCake.CakeViewHolder>() {
    class CakeViewHolder(val itemCake : ItemCakeBinding): RecyclerView.ViewHolder(itemCake.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CakeViewHolder(
        ItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.itemCake.apply {
            with(cakeList[position]){
                idCake.text = id
                typeCake.text = type
            }
        }
    }

    override fun getItemCount() = cakeList.size
}