package com.example.foodapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var foods = ArrayList<Food>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foods.add(Food("Coffee", "   Coffee preparation is the process of turning coffee beans into a beverage. While the " +
                "particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee " +
                "beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain" +
                " time (brewed), and finally the liquid coffee must be separated from the used grounds", R.drawable.coffee_pot))
        foods.add(Food("Espresso", "   Espresso’s authentic formula is clear and basic, its proper execution a matter of training, experience" +
                " and natural talent. A jet of hot water at 88°-93°C (190°-200°F) passes under a pressure of nine or more atmospheres through a seven-gram (.25 oz)" +
                " cake-like layer of ground and tamped coffee. Done right, the result is a concentrate of not more than 30 ml (one oz) of pure sensorial pleasure", R.drawable.espresso))
        foods.add(Food("French Fires", "   Heat a few inches of vegetable oil to 300 degrees F in a heavy pot. In 3 or 4 batches, fry the potatoes " +
                    "about 4 to 5 minutes per batch, or until soft. They should not be brown at all at this point-you just want to start the cooking process. " +
                    "Remove each batch and drain them on new, dry paper towels", R.drawable.french_fries))
        foods.add(Food("Honey", "   While it is less likely that anyone would do this on their own if they are not a beekeeper, this might be useful for " +
                "those who aspire to become one. Bees are really great and easy to keep, even in the urban environment! As Novella Carpenter calls them, bees are " +
                "animal for urban. All you need is some space in the backyard/deck. The process of honey harvesting and extraction most likely happens on a separate " +
                "days. These are the tools required.", R.drawable.honey))

        foods.add(Food("Strawberry", "   Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, " +
                "stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice " +
                "cream maker.", R.drawable.strawberry_ice_cream))
        foods.add(Food("Sugar cubes",
                "   Sugar cubes are extremely simple to make at home - all you need is sugar and water. In addition to standard cubes, you can add color and " +
                        "flavor to add fun flair to a tea party or another gathering. Learn how to make sugar cubes using two different methods: using a pan in the oven or" +
                        " an ice cube tray you leave out overnight.", R.drawable.sugar_cubes))
        var rcv= findViewById<RecyclerView>(R.id.recyclerView1)
        rcv.layoutManager = GridLayoutManager(this, 2)
        //rcv.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(foods)
        rcv.adapter = adapter

    }

    fun click(view : View){
        val name = view.findViewById<TextView>(R.id.name).text.toString()
        var f : Food? = null
        for (food : Food in foods) {
            if (food.name.equals(name)) {
                f = food
                break
            }
        }
        if (f != null){
            val intent : Intent = Intent(this, RecipeActivity::class.java)
            intent.putExtra("food", f)
            startActivity(intent)
        }else{
            Toast.makeText(this, "the food not found", Toast.LENGTH_LONG).show()
        }
    }
}