package com.salim.android.apiquerysearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salim.android.apiquerysearch.data.ResponseItem
import com.salim.android.apiquerysearch.databinding.ItemResponseBinding

class AdapterResponse: RecyclerView.Adapter<AdapterResponse.ResponseViewHolder>() {

    private val listResponse = mutableListOf<ResponseItem>()

    class ResponseViewHolder(val itemResponse : ItemResponseBinding): RecyclerView.ViewHolder(itemResponse.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ResponseViewHolder(
        ItemResponseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        holder.itemResponse.apply {
            with(listResponse[position]){
                tvEmail.text = email
            }
        }
    }

    override fun getItemCount() = listResponse.size

    fun setResponse(response : List<ResponseItem>){
        this.listResponse.clear()
        this.listResponse.addAll(response)
    }

}