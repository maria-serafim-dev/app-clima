package com.example.appclima.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaCidadeFavoritasAdapter
import com.example.appclima.data.DataSource

class ConfigurarCidadesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_cidades)

        carregarRecyclerClimaCidadesFavoritas()
        ouvintePesquisa()
    }

    private fun ouvintePesquisa() {
        val textFieldProcurar: TextView = findViewById(R.id.tv_titulo_tempo)
        textFieldProcurar.setOnClickListener {
            val modalBottomSheet = ModalBottomSheet(DataSource().listaClimaCidadeFavorita[0])
            modalBottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)
        }
    }

    private fun carregarRecyclerClimaCidadesFavoritas() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_clima_cidades_favoritas)
        val adapter = ClimaCidadeFavoritasAdapter(this, DataSource().listaClimaCidadeFavorita)
        recyclerView.adapter = adapter
    }
}