package com.m1ctopt1.recipeapp.interfaces


import com.m1ctopt1.recipeapp.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("/categories.php")
    fun getCategoryList(): Call<List<Category>>
}