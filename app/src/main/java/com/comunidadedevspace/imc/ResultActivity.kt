package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        var classificacao: String? = null
        var corResultado: Int = 0

        if (result <= 18.5f) {
            classificacao = "MAGREZA"
            corResultado = R.color.blue
        } else if (result > 18.5f && result <= 24.99f) {
            classificacao = "NORMAL"
            corResultado = R.color.green
        } else if (result > 25.00f && result <= 29.99f) {
            classificacao = "SOBREPESO"
            corResultado = R.color.red_light
        } else if (result > 30.00f && result <= 39.99f) {
            classificacao = "OBESIDADE"
            corResultado = R.color.orange_red
        } else {
            classificacao = "OBESIDADE GRAVE"
            corResultado = R.color.super_red
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(getColor(corResultado))

    }
}