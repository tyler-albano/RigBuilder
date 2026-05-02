package com.example.rigbuilder

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rigbuilder.data.BuildManager
import java.util.Locale

class BuildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build)

        findViewById<Button>(R.id.buttonBackToHome).setOnClickListener {
            finish()
        }

        val layoutSelectedParts = findViewById<LinearLayout>(R.id.layoutSelectedParts)
        val textTotalPrice = findViewById<TextView>(R.id.textTotalPrice)
        val textCompatibility = findViewById<TextView>(R.id.textCompatibility)
        val buttonClearBuild = findViewById<Button>(R.id.buttonClearBuild)

        fun updateUI() {
            layoutSelectedParts.removeAllViews()

            if (BuildManager.selectedParts.isEmpty()) {
                val emptyText = TextView(this)
                emptyText.text = "No parts selected yet."
                emptyText.textSize = 16f
                layoutSelectedParts.addView(emptyText)

                textTotalPrice.text = "Total: $0.00"
            } else {
                BuildManager.selectedParts.forEach { part ->
                    val partText = TextView(this)
                    partText.text = "${part.name}\nCategory: ${part.category}\nBrand: ${part.brand}\nPrice: ${
                        String.format(Locale.US, "$%.2f", part.price)
                    }"
                    partText.textSize = 16f
                    partText.setPadding(0, 12, 0, 4)

                    val removeButton = Button(this)
                    removeButton.text = "Remove ${part.category}"
                    removeButton.setOnClickListener {
                        BuildManager.removePart(part.category)
                        updateUI()
                    }

                    layoutSelectedParts.addView(partText)
                    layoutSelectedParts.addView(removeButton)
                }

                textTotalPrice.text = String.format(
                    Locale.US,
                    "Total: $%.2f",
                    BuildManager.getTotalPrice()
                )
            }

            textCompatibility.text = BuildManager.getCompatibilityMessage()
        }

        updateUI()

        buttonClearBuild.setOnClickListener {
            BuildManager.clearBuild()
            updateUI()
        }
    }
}