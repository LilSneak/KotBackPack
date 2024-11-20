package com.m1ctopt1.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems
import com.m1ctopt1.recipeapp.entities.Recipes

@Dao
interface RecipesDao {

    @Query("SELECT * FROM categoryitems ORDER BY id DESC")
   suspend fun getAllCategory(): List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: CategoryItems?)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()

}