package com.jamirodev.xmlexercise3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jamirodev.xmlexercise3.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnHelloApp.setOnClickListener{ navigateToHelloApp()}
        btnIMCApp.setOnClickListener { navigateToImcApp() }
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun  navigateToHelloApp() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}