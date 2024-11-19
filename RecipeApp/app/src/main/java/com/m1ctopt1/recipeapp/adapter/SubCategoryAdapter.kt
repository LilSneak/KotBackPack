package com.m1ctopt1.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m1ctopt1.recipeapp.R
import com.m1ctopt1.recipeapp.entities.Recipes


class SubCategoryAdapter:RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var arrSubCategory = ArrayList<Recipes>()
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setdata(arrData: List<Recipes>){
        arrSubCategory = arrData as ArrayList<Recipes>
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int){
        holder.itemView.findViewById<TextView>(R.id.dish_name_1).text = arrSubCategory[position].dishName
    }
}