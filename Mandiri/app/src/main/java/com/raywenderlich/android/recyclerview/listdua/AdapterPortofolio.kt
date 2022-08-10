package com.raywenderlich.android.recyclerview.listdua

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raywenderlich.android.recyclerview.databinding.ItemPortofolioBinding

class AdapterPortofolio(val listPortofolio: ArrayList<ModelPortofolio>): RecyclerView.Adapter<AdapterPortofolio.ViewHolder>() {

    class ViewHolder(val itemBinding: ItemPortofolioBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPortofolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.apply {
            with(listPortofolio[position]){
                tvJudul.text = namaPortofolio
                Glide.with(imgPortofolio.context).load(imagePortofolio).into(imgPortofolio)
            }
        }
    }

    override fun getItemCount(): Int {
        return listPortofolio.size
    }


}