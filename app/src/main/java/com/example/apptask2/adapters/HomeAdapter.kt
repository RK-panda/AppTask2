package com.example.apptask2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptask2.R
import com.example.apptask2.models.PostProduct
import com.example.apptask2.models.ReturnedResults
import com.example.apptask2.models.ShowProducts

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    private var data : ArrayList<ReturnedResults<PostProduct>>?=null

    fun setData(list: ArrayList<ReturnedResults<PostProduct>>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_card_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size?:0
    }

    class HomeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindView(item: ReturnedResults<PostProduct>?){
            val productName = itemView.findViewById(R.id.productName) as TextView
            val productPrice = itemView.findViewById(R.id.productPrice) as TextView

            if (item != null) {
                productName.text = item.data.name
            }
            if (item != null) {
                productPrice.inputType = item.data.price
            }

        }
    }

}
