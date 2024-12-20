package com.m1ctopt1.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.MealsItems

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItems>):String?{
        if(category == null){
            return(null)
        }else{
            val gson = Gson()
            val type= object: TypeToken<MealsItems>(){

            }.type
            return gson.toJson(category,type)
        }
    }
    @TypeConverter
    fun toCategoryList(categoryString: String): List<MealsItems>?{
        if(categoryString == null){
            return(null)
        }else{
            val gson = Gson()
            val type = object: TypeToken<MealsItems>(){

            }.type
            return gson.fromJson(categoryString,type)
        }
    }
}