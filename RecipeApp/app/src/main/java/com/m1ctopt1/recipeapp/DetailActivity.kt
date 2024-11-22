package com.m1ctopt1.recipeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.m1ctopt1.recipeapp.adapter.MainCategoryAdapter
import com.m1ctopt1.recipeapp.adapter.SubCategoryAdapter
import com.m1ctopt1.recipeapp.entities.Category
import com.m1ctopt1.recipeapp.entities.CategoryItems
import com.m1ctopt1.recipeapp.entities.Meal
import com.m1ctopt1.recipeapp.entities.MealResponse
import com.m1ctopt1.recipeapp.entities.MealsItems
import com.m1ctopt1.recipeapp.interfaces.GetDataService
import com.m1ctopt1.recipeapp.retrofitclient.RetrofitClientInstance
import com.makeramen.roundedimageview.RoundedImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : BaseActivity() {

 var youtubeLink = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)


        var id= intent.getStringExtra("id")
        getSpecificItem(id!!)

        findViewById<ImageButton>(R.id.imgToolbarBtnBack).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnYoutube).setOnClickListener{
            val uri: Uri = Uri.parse(youtubeLink)

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
    fun getSpecificItem(id: String){
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
        val call = service.getSpecificItem(id)
        call.enqueue(object: Callback<MealResponse>{
            override fun onFailure(call: Call<MealResponse>, t:Throwable){
                Toast.makeText(this@DetailActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }
            override fun onResponse(
                call: Call<MealResponse>,
                response: Response<MealResponse>
            ){
                Glide.with(this@DetailActivity).load(response.body()!!.mealsEntity[0].strMealThumb).into(findViewById<RoundedImageView>(R.id.imgItem))

                findViewById<TextView>(R.id.tvCategory).text = response.body()!!.mealsEntity[0].strMeal

                var ingredient = "${response.body()!!.mealsEntity[0].strIngredient1} ${response.body()!!.mealsEntity[0].strMeasure1}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient2} ${response.body()!!.mealsEntity[0].strMeasure2}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient3} ${response.body()!!.mealsEntity[0].strMeasure3}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient4} ${response.body()!!.mealsEntity[0].strMeasure4}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient5} ${response.body()!!.mealsEntity[0].strMeasure5}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient6} ${response.body()!!.mealsEntity[0].strMeasure6}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient7} ${response.body()!!.mealsEntity[0].strMeasure7}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient8} ${response.body()!!.mealsEntity[0].strMeasure8}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient9} ${response.body()!!.mealsEntity[0].strMeasure9}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient10} ${response.body()!!.mealsEntity[0].strMeasure10}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient11} ${response.body()!!.mealsEntity[0].strMeasure11}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient12} ${response.body()!!.mealsEntity[0].strMeasure12}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient13} ${response.body()!!.mealsEntity[0].strMeasure13}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient14} ${response.body()!!.mealsEntity[0].strMeasure14}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient15} ${response.body()!!.mealsEntity[0].strMeasure15}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient16} ${response.body()!!.mealsEntity[0].strMeasure16}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient17} ${response.body()!!.mealsEntity[0].strMeasure17}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient18} ${response.body()!!.mealsEntity[0].strMeasure18}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient19} ${response.body()!!.mealsEntity[0].strMeasure19}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient20} ${response.body()!!.mealsEntity[0].strMeasure20}\n"

                findViewById<TextView>(R.id.tvIngredients).text = ingredient
                findViewById<TextView>(R.id.tvInstructions).text = response.body()!!.mealsEntity[0].strInstructions

                if(response.body()!!.mealsEntity[0].strSource != null){
                    youtubeLink = response.body()!!.mealsEntity[0].strSource
                }else{
                    findViewById<Button>(R.id.btnYoutube).visibility = View.GONE
                }
            }
        })
    }


}
