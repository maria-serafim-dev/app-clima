package com.example.appclima.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuCompat
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaCidadeFavoritasAdapter
import com.example.appclima.data.DataSource


class ConfigurarCidadesActivity : AppCompatActivity() {

    private lateinit var adapter: ClimaCidadeFavoritasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_cidades)

        carregarRecyclerClimaCidadesFavoritas()
        ouvintePesquisa()

        setSupportActionBar(findViewById(R.id.topAppBar))
        supportActionBar?.title = ""

        carregarConfiguracoesModoLandscape()

    }

    private fun carregarConfiguracoesModoLandscape() {
        val orientacao = resources.configuration.orientation
        if(orientacao == 2 ){
            val textFieldProcurar: TextView = findViewById(R.id.tv_titulo_tempo)
            TextViewCompat.setTextAppearance(textFieldProcurar, R.style.TextAppearance_Headline6)

            val lessButtonParams: LinearLayout.LayoutParams = textFieldProcurar.layoutParams as LinearLayout.LayoutParams
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
        val botaoSalvar: Button = findViewById(R.id.btn_salvar)
        botaoSalvar.visibility = View.VISIBLE
        botaoSalvar.setOnClickListener {
            botaoSalvar.visibility = View.GONE
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
        val recyclerView = findViewById<RecyclerView>(R.id.rv_clima_cidades_favoritas)
        adapter = ClimaCidadeFavoritasAdapter(this, DataSource().listaClimaCidadeFavorita)

        recyclerView.adapter = adapter
    }
}