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
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems
import com.m1ctopt1.recipeapp.entities.Recipes


class MainCategoryAdapter:RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {
    var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClicked(categoryName:String)
    }

    var ctx: Context? = null
    var arrMainCategory = ArrayList<CategoryItems>()
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setdata(arrData: List<CategoryItems>){
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }
    fun setClickListener(listener1: MainCategoryAdapter.OnItemClickListener){
        listener = listener1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int){
        holder.itemView.findViewById<TextView>(R.id.dish_name_1).text = arrMainCategory[position].strCategory

        Glide.with(ctx!!).load(arrMainCategory[position].strCategoryThumb).into(holder.itemView.findViewById(R.id.img_dish))

        holder.itemView.rootView.setOnClickListener{
            listener!!.onClicked(arrMainCategory[position].strCategory)
        }
    }

}
