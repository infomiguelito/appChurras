package com.example.appchurras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appchurras.Result
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val tieNumberAdult = findViewById<TextInputEditText>(R.id.tie_number_adult_title)
        val tieNumberKids = findViewById<TextInputEditText>(R.id.tie_number_kids_title)
        val tieDuration = findViewById<TextInputEditText>(R.id.tie_duration)
        val btnClean = findViewById<Button>(R.id.btn_clean)

        btnCalculate.setOnClickListener {
            val textNumberAdult = tieNumberAdult.text.toString()
            val textNumberKids = tieNumberKids.text.toString()
            val textDuration = tieDuration.text.toString()

            if (textNumberAdult?.isEmpty() == true ||
                textNumberKids?.isEmpty() == true ||
                textDuration?.isEmpty() == true
            ) {
                Snackbar.make(tieNumberAdult, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val NumberAdult: Double = textNumberAdult.toDouble()
                val numberKids: Double = textNumberKids.toDouble()
                val carneAdulto = 400
                val carneCrianca = 200
                val cervejaAdulto = 4
                val refriAdulto = 0.5
                val refriCrianca = 0.7
                val totalCarne = (NumberAdult * carneAdulto) + (numberKids * carneCrianca)
                val totalCerveja = NumberAdult * cervejaAdulto
                val totalRefrigerante = (NumberAdult * refriAdulto) + (numberKids * refriCrianca)


                val intent = Intent(this, Result::class.java)
                intent.apply {
                    putExtra("totalCarne", totalCarne)
                    putExtra("totalCerveja", totalCerveja)
                    putExtra("totalRefri", totalRefrigerante)
                }
                startActivity(intent)
            }
        }
        btnClean.setOnClickListener {
            tieNumberAdult.setText("")
            tieDuration.setText("")
            tieNumberKids.setText("")
        }

    }

}