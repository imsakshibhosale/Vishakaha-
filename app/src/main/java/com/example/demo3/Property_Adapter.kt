package com.example.demo3

p
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class Property_Adapter (private val PostList:ArrayList<>):RecyclerView.Adapter<Property_Adapter.PropertyViewHolder>()

{

    class PropertyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView :ImageView =itemView.findViewById(R.id.property_post_image)
        val textView:TextView=itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(property_post,parent,false)
        return PropertyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return PostList.size
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val post =PostList[position]
        holder.imageView.setImageResource(post.image)
        holder.textView.text=post.name
    }

}
