package com.m1ctopt1.recipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
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
import com.m1ctopt1.recipeapp.entities.MealsItems
import com.m1ctopt1.recipeapp.entities.Recipes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    var arrmainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<MealsItems>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        getDataFromDb()

        mainCategoryAdapter.setClickListener(onClicked)
        subCategoryAdapter.setClickListener(onClickedSubItem)

    }

    private val onClicked = object:MainCategoryAdapter.OnItemClickListen1{
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }
    private val onClickedSubItem = object:SubCategoryAdapter.OnItemClickListen1{
        override fun onClicked(id: String) {
            var intent = Intent(this@HomeActivity,DetailActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)

        }
    }
    private fun getDataFromDb(){
      GlobalScope.launch {
          this.let {
              var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
              arrmainCategory = cat as ArrayList<CategoryItems>
              arrmainCategory.reverse()
              getMealDataFromDb(arrmainCategory[0].strCategory)
              mainCategoryAdapter.setdata(arrmainCategory)
              findViewById<RecyclerView>(R.id.rv_main_category).layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
              findViewById<RecyclerView>(R.id.rv_main_category).adapter = mainCategoryAdapter
          }
      }
    }

    private fun getMealDataFromDb(categoryName:String){
        findViewById<TextView>(R.id.tvCategory).text = "$categoryName category"
        GlobalScope.launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                subCategoryAdapter.setdata(arrSubCategory)
                findViewById<RecyclerView>(R.id.rv_sub_category).layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                findViewById<RecyclerView>(R.id.rv_sub_category).adapter = subCategoryAdapter
            }
        }
    }
}