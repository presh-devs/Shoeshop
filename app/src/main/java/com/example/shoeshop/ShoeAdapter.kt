package com.example.shoeshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class ShoeAdapter(var items : ArrayList<Shoes>, var clickListener: OnShoeItemClickListener) : RecyclerView.Adapter<ShoeViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        lateinit var shoeViewHolder : ShoeViewHolder
        shoeViewHolder = ShoeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view, parent, false))
        return shoeViewHolder
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.shoeName?.text = items.get(position) .name
        holder.shoeDescription?.text = items.get(position) .description
        holder.shoeLogo. setImageResource(items.get(position).logo)
        holder.initialize(items.get(position), clickListener)
    }
}

class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var shoeName = itemView.shoename
    var shoeDescription = itemView.shoedescription
    var shoeLogo = itemView.shoelogo

    fun initialize(item: Shoes, action:OnShoeItemClickListener){
        shoeName.text = item.name
        shoeDescription.text = item.description
        shoeLogo.setImageResource(item.logo)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnShoeItemClickListener{
    fun onItemClick(item: Shoes, position: Int)

}