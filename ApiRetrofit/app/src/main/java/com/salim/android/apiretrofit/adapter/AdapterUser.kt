package com.salim.android.apiretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salim.android.apiretrofit.data.UserItem
import com.salim.android.apiretrofit.data.UsersItem
import com.salim.android.apiretrofit.databinding.ItemUserBinding

class AdapterUser: RecyclerView.Adapter<AdapterUser.UserViewHolder>() {

    private val listUser = mutableListOf<UserItem>()

    class UserViewHolder(val  itemUser : ItemUserBinding) : RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.itemUser.apply {
           with(listUser[position]){
               textView.text = address.geo.lat
//               Glide.with(imageView.context).load(avatarUrl).into(imageView)
           }
       }
    }

    override fun getItemCount() = listUser.size

    fun setUser(user: List<UserItem>){
        this.listUser.clear()
        this.listUser.addAll(user)
    }


}