package com.atsalaja.myfirstcarapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.atsalaja.myfirstcarapp.car.Car
import com.bumptech.glide.Glide

class ListCarAdapter(private val listCar: ArrayList<Car>) : RecyclerView.Adapter<ListCarAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCar: ImageView = itemView.findViewById(R.id.img_item_image)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_car, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCar.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val car = listCar[position]
        Glide.with(holder.itemView.context)
            .load(car.image)
            .into(holder.imgCar)
        holder.tvName.text = car.name
        holder.tvDesc.text = car.description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(car)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Car)
    }
}