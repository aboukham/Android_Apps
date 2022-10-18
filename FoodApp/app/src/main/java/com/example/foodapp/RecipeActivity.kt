package com.example.foodapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class RecipeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val intent = intent
        val food = intent.getSerializableExtra("food") as Food
        var nameText = findViewById<TextView>(R.id.name)
        var image = findViewById<ImageView>(R.id.image)
        var recipeText = findViewById<TextView>(R.id.recipe)
        nameText.text = food.name
        image.setImageResource(food.image)
        recipeText.text = food.recipe
    }
}