package com.azp.recyclerviewkotlintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azp.recyclerviewkotlintest.adapter.FruitsAdapter
import com.azp.recyclerviewkotlintest.adapter.OnItemClickListener
import com.azp.recyclerviewkotlintest.model.Fruits

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.fruits_recycler)

        val fruitArray = ArrayList<Fruits>()
        fruitArray.add(Fruits("Apple",R.drawable.apple))
        fruitArray.add(Fruits("Orange",R.drawable.orange))
        fruitArray.add(Fruits("Blueberry",R.drawable.blueberry))
        fruitArray.add(Fruits("Strawberry",R.drawable.strawberry))

        val fruitsAdapter = FruitsAdapter(fruitArray, this)

//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//
//        recyclerView.adapter = fruitsAdapter
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = fruitsAdapter
        }
    }

    override fun onItemClicked(fruits: Fruits) {
        Toast.makeText(this,"${fruits.name}",Toast.LENGTH_LONG).show()
        val intent = Intent(this, CardActivity::class.java).apply {
            putExtra("NAME",fruits.name)
        }
        startActivity(intent)
    }
}
