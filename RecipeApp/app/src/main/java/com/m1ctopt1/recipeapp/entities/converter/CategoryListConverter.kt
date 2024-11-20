package com.m1ctopt1.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<Category>):String?{
        if(category == null){
            return(null)
        }else{
            val gson = Gson()
            val type= object: TypeToken<Category>(){

            }.type
            return gson.toJson(category,type)
        }
    }
    @TypeConverter
    fun toCategoryList(categoryString: String): List<CategoryItems>?{
        if(categoryString == null){
            return(null)
        }else{
            val gson = Gson()
            val type = object: TypeToken<CategoryItems>(){

                }.type
                return gson.fromJson(categoryString,type)
        }
    }
}