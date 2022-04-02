package com.example.appclima.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaCidadeFavoritasAdapter
import com.example.appclima.data.DataSource

class ConfigurarCidadesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_cidades)

        carregarRecycleClimaCidadesFavoritas()
    }

    private fun carregarRecycleClimaCidadesFavoritas() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_clima_cidades_favoritas)
        val adapter = ClimaCidadeFavoritasAdapter(this, DataSource().listaClimaCidadeFavorita)
        recyclerView.adapter = adapter
    }
}