package com.example.appclima.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaDiaAdapter
import com.example.appclima.adapter.ClimaHoraAdapter
import com.example.appclima.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarRecycleClimaPorHora()
        carregarRecycleClimaPorDia()
    }

    private fun carregarRecycleClimaPorHora() {
        val recyclerViewHora = findViewById<RecyclerView>(R.id.rv_clima_por_hora)
        val adapterHora = ClimaHoraAdapter(this, DataSource().listaClimaHora)
        recyclerViewHora.adapter = adapterHora
    }

    private fun carregarRecycleClimaPorDia() {
        val recyclerViewDia = findViewById<RecyclerView>(R.id.rv_clima_por_dia)
        val adapterDia = ClimaDiaAdapter(this, DataSource().listaClimaDia)
        recyclerViewDia.adapter = adapterDia
    }

}