package com.example.demo3

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemTitles= arrayOf("Property Name:","Carpet Area: ")
    private val  itemDetails= arrayOf("This is a very good peoperty!","please do visit our property!")
    private val itemImages= intArrayOf(
        R.drawable.house,
        R.drawable.house3,
        R.drawable.house4,
        R.drawable.house5
    )


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var image:ImageView
        var textTitle :TextView
        var textDes:TextView

        init{
            image=itemView.findViewById(R.id.item_image)
            textTitle=itemView.findViewById(R.id.item_title)
            textDes=itemView.findViewById(R.id.item_details)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v=LayoutInflater.from(parent.context)
           .inflate(R.layout.recyclerview_model,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles [position]
        holder.textDes.text=itemDetails[position]
        holder.image.setImageResource(itemImages [position])

        holder.itemView.setOnClickListener{v: View->
            Toast.makeText(v.context,"Clicked on the item",Toast.LENGTH_SHORT).show()
        }
    }

}