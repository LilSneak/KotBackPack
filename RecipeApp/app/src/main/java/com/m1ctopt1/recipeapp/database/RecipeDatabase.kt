package com.m1ctopt1.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.m1ctopt1.recipeapp.dao.RecipesDao
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems
import com.m1ctopt1.recipeapp.entities.Recipes
import com.m1ctopt1.recipeapp.entities.converter.CategoryListConverter

@Database(entities=[Recipes::class, CategoryItems::class,Category::class,CategoryListConverter::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{
        var recipeDatabase:RecipeDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if(recipeDatabase != null){
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