package com.raywenderlich.android.recyclerview.listsatu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.recyclerview.databinding.ItemAnimalBinding

class AnimalAdapter(private val animalList: Array<String>): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(private val itemBinding: ItemAnimalBinding): RecyclerView.ViewHolder(itemBinding.root){
        //kita akan membuat sebuah fungsi yang akan menghubungkan
        //data yg diterima dari class DataSource ke sebuah item layout
        fun bind(word: String){
            itemBinding.animalText.text = word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemBinding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val word = animalList[position]
        holder.bind(word)
    }

    override fun getItemCount(): Int {
       return animalList.size
    }

}