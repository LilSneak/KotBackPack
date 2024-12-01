package com.m1ctopt1.recipeapp.adapter

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.m1ctopt1.recipeapp.entities.CategoryItems
import org.junit.Assert
import org.junit.jupiter.api.Assertions.*

class MainCategoryAdapterTest {
    data class CategoryItems(
        @PrimaryKey(autoGenerate = true)
        var id:Int,

        @ColumnInfo(name = "idCategory")
        @Expose
        @SerializedName("idCategory")
        val idCategory: String,

        @ColumnInfo(name = "strCategory")
        @Expose
        @SerializedName("strCategory")
        val strCategory: String,

        @ColumnInfo(name = "strCategoryDescription")
        @Expose
        @SerializedName("strCategoryDescription")
        val strCategoryDescription: String,

        @ColumnInfo(name = "strCategoryThumb")
        @Expose
        @SerializedName("strCategoryThumb")
        val strCategoryThumb: String
    )
    val testerItem = CategoryItems(1, "Bef","Beef","Hamburger", "Picture of Burger")
    val testerItem2 = CategoryItems(2, "Chick","Chicken","Fried Chicken", "Picture of chicken tender")
    val testerList = ArrayList<CategoryItems>()
    var arrMainCategory = ArrayList<CategoryItems>()

    fun setdata(arrData: List<CategoryItems>): List<CategoryItems>{
        arrMainCategory = arrData as ArrayList<CategoryItems>
        return arrMainCategory
    }
    fun getItemCount(arrData: List<CategoryItems>): Int {
        return arrData.size
    }

    @org.junit.jupiter.api.Test
    fun setdata() {
        testerList.add(testerItem)
        testerList.add(testerItem2)
        assertEquals(testerList, setdata(testerList))
    }

    @org.junit.jupiter.api.Test
    fun getItemCount(){
        assertEquals(testerList.size, getItemCount(arrMainCategory))
    }
}