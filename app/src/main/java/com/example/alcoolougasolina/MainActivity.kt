package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity: AppCompatActivity() {
    var percentual: Double = 0.7
    var valorGasolina: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")
        valorGasolina = savedInstanceState?.getDouble("valor")
        if (valorGasolina != null && valorGasolina != -0.0) {
            Log.d("PDM23","Value recuperated: $valorGasolina")
            findViewById<EditText>(R.id.edGasolina).setText(valorGasolina.toString())
            findViewById<TextView>(R.id.tvAlcool).text = "Preço Competitivo R\$%.2f".format(percentual * valorGasolina!!)
        }
        findViewById<Switch>(R.id.swPercentual).isChecked = savedInstanceState?.getBoolean("checked") ?: false

        val btCalc = findViewById<Button>(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            Log.d("PDM23","No btCalcular, $percentual")

            val edGasolina = findViewById<EditText>(R.id.edGasolina)
            val tvAlcool = findViewById<TextView>(R.id.tvAlcool)
            try {
                valorGasolina = edGasolina.text.toString().toDouble()
                val valorGasolina = percentual * valorGasolina!!
                tvAlcool.text = "Preço Competitivo R\$%.2f".format(valorGasolina)
            } catch (ex: Exception) {
                tvAlcool.text = "Valor inválido!"
            }
        })

        val swPercentual = findViewById<Switch>(R.id.swPercentual)
        swPercentual.setOnCheckedChangeListener { _, checked ->
            Log.d("PDM23", "No swPercentual change")

            percentual = if (checked) 0.75 else 0.7
            swPercentual.text = "%d%%".format((percentual * 100.0).toInt())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PDM23","Save value: ${valorGasolina ?: -0.0}")
        outState.putDouble("valor", valorGasolina ?: -0.0)
        outState.putBoolean("checked", findViewById<Switch>(R.id.swPercentual).isChecked)
        super.onSaveInstanceState(outState)
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