package com.example.appclima.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaHoraAdapter
import com.example.appclima.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarRecycleClimaPorHora()
    }

    private fun carregarRecycleClimaPorHora() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_clima_por_hora)
        val adapter = ClimaHoraAdapter(this, DataSource().listaClimaHora)
        recyclerView.adapter = adapter
    }
}