package com.m1ctopt1.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.m1ctopt1.recipeapp.R
import com.m1ctopt1.recipeapp.adapter.MainCategoryAdapter.OnItemClickListen1
import com.m1ctopt1.recipeapp.entities.MealsItems
import com.m1ctopt1.recipeapp.entities.Recipes


class SubCategoryAdapter:RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListen1? = null

    var ctx: Context? = null
    var arrSubCategory = ArrayList<MealsItems>()

    interface OnItemClickListen1 {
        fun onClicked(id:String)
    }

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setdata(arrData: List<MealsItems>){
        arrSubCategory = arrData as ArrayList<MealsItems>
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx= parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }
    fun setClickListener(listener1: SubCategoryAdapter.OnItemClickListen1){
        listener = listener1
    }
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int){
        holder.itemView.findViewById<TextView>(R.id.dish_name_1).text = arrSubCategory[position].strMeal

        Glide.with(ctx!!).load(arrSubCategory[position].strMealThumb).into(holder.itemView.findViewById(R.id.img_dish))

        holder.itemView.rootView.setOnClickListener{
            listener!!.onClicked(arrSubCategory[position].idMeal)
        }
    }

}