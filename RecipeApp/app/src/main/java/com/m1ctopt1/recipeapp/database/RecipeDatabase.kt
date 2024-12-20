package com.m1ctopt1.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.m1ctopt1.recipeapp.dao.RecipesDao
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems
import com.m1ctopt1.recipeapp.entities.Meal
import com.m1ctopt1.recipeapp.entities.MealsItems
import com.m1ctopt1.recipeapp.entities.Recipes
import com.m1ctopt1.recipeapp.entities.converter.CategoryListConverter
import com.m1ctopt1.recipeapp.entities.converter.MealListConverter

@Database(entities=[Recipes::class, CategoryItems::class,Category::class,Meal::class,MealsItems::class], version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class,MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{
        var recipeDatabase:RecipeDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if(recipeDatabase == null){
                recipeDatabase= Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipeDatabase!!
        }
    }

    abstract fun recipeDao(): RecipesDao
}