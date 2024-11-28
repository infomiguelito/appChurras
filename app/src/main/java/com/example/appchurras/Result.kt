package com.example.appchurras

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appchurras.R.id.result

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activty_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(result)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvCarne = findViewById<TextView>(R.id.tv_total_conta_meat)
        val tvCerveja = findViewById<TextView>(R.id.tv_total_conta_beer)
        val tvRefri = findViewById<TextView>(R.id.tv_total_conta_refrigerator)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        val totalCarne = intent.getDoubleExtra("totalCarne",0.0)
        val totalCerveja = intent.getDoubleExtra("totalCerveja",0.0)
        val totalRefri = intent.getDoubleExtra("totalRefri", 0.0)

        val totalCarneFormatted = String.format("%.2f", totalCarne)
        val totalCervejaFormatted = String.format("%.0f", totalCerveja)
        val totalRefriFormatted = String.format("%.0f", totalRefri)


        tvCarne.text = "$totalCarneFormatted"
        tvCerveja.text = "$totalCervejaFormatted"
        tvRefri.text = "$totalRefriFormatted"


        btnVoltar.setOnClickListener {
            finish()
        }

    }
}