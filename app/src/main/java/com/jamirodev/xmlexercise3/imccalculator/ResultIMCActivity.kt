package com.jamirodev.xmlexercise3.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.jamirodev.xmlexercise3.R
import com.jamirodev.xmlexercise3.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

@Suppress("DEPRECATION")
class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result) {
            in 0.00..18.50 -> { //BAJO PESO
                tvResult.text = getString(R.string.bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo)
            }
            in 18.51..24.99 -> { //NORMAL
                tvResult.text = getString(R.string.peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_normal)
            }
            in 25.00..29.99-> { //SOBREPESO
                tvResult.text = getString(R.string.sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00-> { //OBESIDAD
                tvResult.text = getString(R.string.obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> {   //ERROR
                tvIMC.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnRecalculate)

    }

}