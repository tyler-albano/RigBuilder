package com.example.rigbuilder

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rigbuilder.adapter.PCPartAdapter
import com.example.rigbuilder.data.MockPartsData
import com.example.rigbuilder.data.PCPart

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextSearch: EditText

    private var selectedCategory: String = "All"
    private var searchQuery: String = ""

    private fun updatePartsList() {
        var filteredParts = MockPartsData.parts

        if (selectedCategory != "All") {
            filteredParts = filteredParts.filter { part ->
                part.category == selectedCategory
            }
        }

        if (searchQuery.isNotBlank()) {
            filteredParts = filteredParts.filter { part ->
                part.name.contains(searchQuery, ignoreCase = true) ||
                        part.brand.contains(searchQuery, ignoreCase = true) ||
                        part.category.contains(searchQuery, ignoreCase = true)
            }
        }

        recyclerView.adapter = PCPartAdapter(filteredParts) { part ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", part.name)
            intent.putExtra("category", part.category)
            intent.putExtra("brand", part.brand)
            intent.putExtra("price", part.price)
            intent.putExtra("specs", part.specs)
            intent.putExtra("socket", part.socket)
            startActivity(intent)
        }
    }

    private fun setCategory(category: String) {
        selectedCategory = category
        updatePartsList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSearch = findViewById(R.id.editTextSearch)

        findViewById<Button>(R.id.buttonViewBuild).setOnClickListener {
            val intent = Intent(this, BuildActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerViewParts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        updatePartsList()

        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                searchQuery = s.toString()
                updatePartsList()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        findViewById<Button>(R.id.buttonAll).setOnClickListener {
            setCategory("All")
        }

        findViewById<Button>(R.id.buttonCPU).setOnClickListener {
            setCategory("CPU")
        }

        findViewById<Button>(R.id.buttonGPU).setOnClickListener {
            setCategory("GPU")
        }

        findViewById<Button>(R.id.buttonRAM).setOnClickListener {
            setCategory("RAM")
        }

        findViewById<Button>(R.id.buttonStorage).setOnClickListener {
            setCategory("Storage")
        }

        findViewById<Button>(R.id.buttonMotherboard).setOnClickListener {
            setCategory("Motherboard")
        }

        findViewById<Button>(R.id.buttonPSU).setOnClickListener {
            setCategory("PSU")
        }
    }
}