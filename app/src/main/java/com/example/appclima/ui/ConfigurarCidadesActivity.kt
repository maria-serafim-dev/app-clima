package com.example.appclima.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaCidadeFavoritasAdapter
import com.example.appclima.data.DataSource
import com.google.android.material.appbar.MaterialToolbar


class ConfigurarCidadesActivity : AppCompatActivity() {
    private lateinit var adapter: ClimaCidadeFavoritasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_cidades)

        carregarRecyclerClimaCidadesFavoritas()
        ouvintePesquisa()
        ouvinteMenu()
    }

    private fun ouvinteMenu() {
        val menu: MaterialToolbar = findViewById(R.id.topAppBar)

        menu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu_editar_lista->{
                    adapter.visiliby = true
                    adapter.notifyDataSetChanged()
                    true
                }
                R.id.menu_notificacoes->{
                    adapter.visiliby = false
                    adapter.notifyDataSetChanged()
                    true
                }
                R.id.menu_fahrenheit -> {
                    it.isChecked = true
                    true
                }
                R.id.menu_celsius-> {
                    it.isChecked = true
                    true
                }
                else -> false
            }

        }
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
        adapter = ClimaCidadeFavoritasAdapter(this, DataSource().listaClimaCidadeFavorita)

        recyclerView.adapter = adapter
    }
}