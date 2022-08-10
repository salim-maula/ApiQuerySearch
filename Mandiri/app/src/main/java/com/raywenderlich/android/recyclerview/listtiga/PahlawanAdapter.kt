package com.raywenderlich.android.recyclerview.listtiga

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raywenderlich.android.recyclerview.databinding.ItemPahlawanBinding

class PahlawanAdapter(val ctx: Context, val modelMainList: MutableList<ModelPahlawan>) :
    RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {

    class PahlawanViewHolder(val itemBinding: ItemPahlawanBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
        ItemPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        holder.itemBinding.apply {
            with(modelMainList[position]){
                tvNamaPahlawan.text = nama
                tvNamaLengkap.text = namaLengkap
                Glide.with(imagePahlawan.context).load(image).into(imagePahlawan)
            }
        }
    }

    override fun getItemCount(): Int {
        return modelMainList.size
    }

}