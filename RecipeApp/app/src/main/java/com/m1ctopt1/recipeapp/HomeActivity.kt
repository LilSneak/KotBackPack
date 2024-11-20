package com.m1ctopt1.recipeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.m1ctopt1.recipeapp.adapter.MainCategoryAdapter
import com.m1ctopt1.recipeapp.adapter.SubCategoryAdapter
import com.m1ctopt1.recipeapp.database.RecipeDatabase
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems
import com.m1ctopt1.recipeapp.entities.Recipes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    var arrmainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        getDataFromDb()


        arrSubCategory.add(Recipes(1, "SmashBurger"))
        arrSubCategory.add(Recipes(2, "Roasted Chicken"))
        arrSubCategory.add(Recipes(3, "Coconut Lime Cookies"))
        arrSubCategory.add(Recipes(4, "Fried Porkchops"))

        subCategoryAdapter.setdata(arrSubCategory)



        findViewById<RecyclerView>(R.id.rv_sub_category).layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        findViewById<RecyclerView>(R.id.rv_sub_category).adapter = subCategoryAdapter

    }

    private fun getDataFromDb(){
      GlobalScope.launch {
          this.let {
              var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
              arrmainCategory = cat as ArrayList<CategoryItems>
              arrmainCategory.reverse()
              mainCategoryAdapter.setdata(arrmainCategory)
              findViewById<RecyclerView>(R.id.rv_main_category).layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
              findViewById<RecyclerView>(R.id.rv_main_category).adapter = mainCategoryAdapter
          }
      }
    }
}