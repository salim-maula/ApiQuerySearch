package com.raywenderlich.android.recyclerview.listempat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raywenderlich.android.recyclerview.databinding.ItemMovieBinding
import com.raywenderlich.android.recyclerview.listempat.model.Post

class MovieAdapter(var result: ArrayList<Post.Result>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(val itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemMovieBinding.apply {
            with(result[position]) {
                textView.text = title
                Glide.with(imageView.context).load(image).centerCrop().into(imageView)
            }
        }
    }

    override fun getItemCount() = result.size

    fun setData (data: List<Post.Result>){
        this.result.clear()
        this.result.addAll(data)
        notifyDataSetChanged()
    }
}