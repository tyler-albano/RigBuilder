package com.example.rigbuilder

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rigbuilder.data.BuildManager
import com.example.rigbuilder.data.PCPart

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name") ?: ""
        val category = intent.getStringExtra("category") ?: ""
        val brand = intent.getStringExtra("brand") ?: ""
        val price = intent.getDoubleExtra("price", 0.0)
        val specs = intent.getStringExtra("specs") ?: ""
        val socket = intent.getStringExtra("socket") ?: ""

        findViewById<TextView>(R.id.textName).text = name
        findViewById<TextView>(R.id.textCategory).text = "Category: $category"
        findViewById<TextView>(R.id.textBrand).text = "Brand: $brand"
        findViewById<TextView>(R.id.textPrice).text = "Price: $$price"
        findViewById<TextView>(R.id.textSpecs).text = "Specs: $specs"

        findViewById<Button>(R.id.buttonAddToBuild).setOnClickListener {
            val part = PCPart(
                id = 0,
                name = name,
                category = category,
                brand = brand,
                price = price,
                specs = specs,
                socket = socket
            )

            val alreadyExists = BuildManager.selectedParts.any { it.category == category }

            BuildManager.addOrReplacePart(part)

            val message = if (alreadyExists) {
                "$category replaced in build"
            } else {
                "$name added to build"
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}