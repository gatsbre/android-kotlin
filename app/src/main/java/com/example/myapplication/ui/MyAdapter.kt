package com.example.myapplication.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.home.Recipe
import java.util.*
import kotlin.collections.ArrayList

class MyAdapter(private var recipeList : ArrayList<Recipe>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = recipeList[position]

        holder.recipeTitle.text = currentItem.recipeTitle
        holder.recipeIngredients.text = currentItem.recipeIngredients

        val btnShare = holder.itemView.findViewById<ImageButton>(R.id.btnShare)

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this recipe:\n${currentItem.recipeTitle}\n(${currentItem.recipeIngredients})\n ")
            holder.itemView.context.startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }


    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recipeTitle : TextView = itemView.findViewById(R.id.recipeTitle)
        val recipeIngredients : TextView = itemView.findViewById(R.id.recipeIngredients)
    }
}
