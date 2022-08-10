package com.salim.android.apiretrofitcomplex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salim.android.apiretrofitcomplex.data.Geo
import com.salim.android.apiretrofitcomplex.data.ResultUserItem
import com.salim.android.apiretrofitcomplex.databinding.ItemUserBinding

class AdapterUser: RecyclerView.Adapter<AdapterUser.UserViewHolder>() {

    private val listUser = ArrayList<Geo>()

    class UserViewHolder(val  itemUser : ItemUserBinding) : RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]){
                textView.text = lng

            }
        }
    }

    override fun getItemCount() = listUser.size

    fun setUser(user: ArrayList<Geo>){
        this.listUser.clear()
        this.listUser.addAll(user)
    }


}