package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity: AppCompatActivity() {
    var percentual: Double = 0.7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc = findViewById<Button>(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            Log.d("PDM23","No btCalcular, $percentual")

            val edGasolina = findViewById<EditText>(R.id.edGasolina)
            val tvAlcool = findViewById<TextView>(R.id.tvAlcool)
            val valorAlcool = percentual * edGasolina.text.toString().toDouble()
            tvAlcool.text = "Preço Competitivo R\$%.2f".format(valorAlcool)
        })

        val swPercentual = findViewById<Switch>(R.id.swPercentual)
        swPercentual.setOnCheckedChangeListener { _, checked ->
            Log.d("PDM23", "No swPercentual change")

            percentual = if (checked) 0.75 else 0.7
            swPercentual.text = "%d%%".format((percentual * 100.0).toInt())
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("PDM23","No onResume, $percentual")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PDM23","No onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PDM23","No onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PDM23","No onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PDM23","No onResume")
    }
}