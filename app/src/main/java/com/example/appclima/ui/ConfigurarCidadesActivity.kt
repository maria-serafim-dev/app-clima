package com.example.appclima.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuCompat
import androidx.core.widget.TextViewCompat
import com.example.appclima.R
import com.example.appclima.adapter.ClimaCidadeFavoritasAdapter
import com.example.appclima.data.DataSource
import com.example.appclima.databinding.ActivityConfigurarCidadesBinding


class ConfigurarCidadesActivity : AppCompatActivity() {

    private lateinit var adapter: ClimaCidadeFavoritasAdapter
    private lateinit var binding: ActivityConfigurarCidadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigurarCidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carregarRecyclerClimaCidadesFavoritas()
        ouvintePesquisa()

        setSupportActionBar(binding.topAppBar)
        supportActionBar?.title = ""

        carregarConfiguracoesModoLandscape()

    }

    private fun carregarConfiguracoesModoLandscape() {
        val orientacao = resources.configuration.orientation
        if(orientacao == 2 ){
            TextViewCompat.setTextAppearance(binding.tvTituloTempo, R.style.TextAppearance_Headline6)
            val lessButtonParams: LinearLayout.LayoutParams = binding.tvTituloTempo.layoutParams as LinearLayout.LayoutParams
            lessButtonParams.topMargin = resources.getDimension(R.dimen.text_landscape).toInt()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
                R.id.menu_editar_lista->{
                    adapter.visiliby = true
                    adapter.notifyDataSetChanged()
                    configurarBotaoSalvar()
                    true
                }
                R.id.menu_notificacoes->{
                    true
                }
                R.id.menu_fahrenheit -> {
                    item.isChecked = true
                    true
                }
                R.id.menu_celsius -> {
                    item.isChecked = true
                    true
                }
                else -> false
            }

    }

    private fun configurarBotaoSalvar() {
        binding.btnSalvar.visibility = View.VISIBLE
        binding.btnSalvar.setOnClickListener {
            binding.btnSalvar.visibility = View.GONE
            adapter.visiliby = false
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_configuracoes_cidades, menu)
        menu.findItem(R.id.menu_celsius).isChecked = true
        MenuCompat.setGroupDividerEnabled(menu, true)
        return true
    }

    private fun ouvintePesquisa() {
        val textFieldProcurar: TextView = findViewById(R.id.tv_titulo_tempo)
        textFieldProcurar.setOnClickListener {
            val modalBottomSheet = ModalBottomSheet(DataSource().listaClimaCidadeFavorita[0])
            modalBottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)
        }
    }

    private fun carregarRecyclerClimaCidadesFavoritas() {
       adapter = ClimaCidadeFavoritasAdapter(this, DataSource().listaClimaCidadeFavorita)
       binding.rvClimaCidadesFavoritas.adapter = adapter
    }
}