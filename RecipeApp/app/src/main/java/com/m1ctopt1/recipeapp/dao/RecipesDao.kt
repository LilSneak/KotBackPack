package com.m1ctopt1.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.Recipes

@Dao
interface RecipesDao {

    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory: List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

}