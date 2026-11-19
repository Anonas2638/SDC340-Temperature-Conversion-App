package com.example.temperatureconversion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

// Anosha Naseri
// PA 2.4 - Temperature Conversion App
// November 19, 2026

class MainActivity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.editTextTemperature)
        result = findViewById(R.id.txtResult)

        val btnFtoC = findViewById<Button>(R.id.btnFtoC)
        val btnCtoF = findViewById<Button>(R.id.btnCtoF)

        btnFtoC.setOnClickListener {
            convertTemperature(true)
        }

        btnCtoF.setOnClickListener {
            convertTemperature(false)
        }
    }

    private fun convertTemperature(isFahrenheit: Boolean) {
        val value = input.text.toString().trim().toDoubleOrNull()

        if (value == null || !value.isFinite()) {
            result.text = "Please enter a valid temperature."
            Toast.makeText(
                this,
                "Enter a valid number",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        if (isFahrenheit) {
            if (value < -100 || value > 250) {
                result.text = "Fahrenheit must be between -100 and 250."
                Toast.makeText(
                    this,
                    "Fahrenheit must be between -100 and 250",
                    Toast.LENGTH_LONG
                ).show()
                return
            }

            val converted = (value - 32) * 5 / 9
            result.text = String.format(
                Locale.US,
                "%.2f °F = %.2f °C",
                value,
                converted
            )

        } else {
            if (value < -75 || value > 125) {
                result.text = "Celsius must be between -75 and 125."
                Toast.makeText(
                    this,
                    "Celsius must be between -75 and 125",
                    Toast.LENGTH_LONG
                ).show()
                return
            }

            val converted = (value * 9 / 5) + 32
            result.text = String.format(
                Locale.US,
                "%.2f °C = %.2f °F",
                value,
                converted
            )
        }
    }
}
