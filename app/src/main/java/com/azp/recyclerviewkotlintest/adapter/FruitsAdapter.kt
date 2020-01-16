package com.azp.recyclerviewkotlintest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azp.recyclerviewkotlintest.R
import com.azp.recyclerviewkotlintest.model.Fruits
import kotlinx.android.synthetic.main.fruit_item.view.*

class FruitsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var fruitName = itemView.findViewById<TextView>(R.id.fruit_name)
    var fruitImage = itemView.findViewById<ImageView>(R.id.fruit_image)
    var itemCount = itemView.findViewById<TextView>(R.id.item_count)
    var btnCount = itemView.findViewById<Button>(R.id.btn_count)

    fun bind(fruits: Fruits, clickListener: OnItemClickListener){

        itemView.setOnClickListener {
            clickListener.onItemClicked(fruits)
        }
    }

}

class FruitsAdapter(val fruitsList: ArrayList<Fruits>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<FruitsViewHolder>() {

    private lateinit var onItemClickListener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item,parent,false)
        return FruitsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.fruitName.text = fruitsList[position].name
        holder.fruitImage.setImageResource(fruitsList[position].image)
        holder.btnCount.setOnClickListener {
            var count: Int = holder.itemCount.text.toString().toInt()
            count++
            holder.itemCount.text = count.toString()
        }
        holder.bind(fruitsList[position],itemClickListener)
    }
}

interface OnItemClickListener{
    fun onItemClicked(fruits: Fruits)
}

