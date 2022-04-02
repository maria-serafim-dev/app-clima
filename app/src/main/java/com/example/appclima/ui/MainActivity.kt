package com.example.appclima.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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
        carregarDadosCidade()
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

    private fun carregarDadosCidade(){
        val cidade = DataSource().cidadeParacatu

        val textNomeCidade = findViewById<TextView>(R.id.tv_nome_cidade)
        val textTemperaturaAtual = findViewById<TextView>(R.id.tv_temperatura_atual)
        val textDescricao = findViewById<TextView>(R.id.tv_descricao)
        val textMax = findViewById<TextView>(R.id.tv_max)
        val textMin = findViewById<TextView>(R.id.tv_min)
        val textUmidade = findViewById<TextView>(R.id.tv_umidade)
        val textSensacao = findViewById<TextView>(R.id.tv_sensacao)
        val textVisibilidade = findViewById<TextView>(R.id.tv_visibilidade)
        val textChuva = findViewById<TextView>(R.id.tv_chuva)


        with(cidade){
            textNomeCidade.text = nomeCidade
            textTemperaturaAtual.text = resources.getString(R.string.text_temperatura_atual, temperaturaAtual.toString())
            textDescricao.text = descricao
            textMax.text = resources.getString(R.string.text_minima, temperaturaMinima.toString())
            textMin.text = resources.getString(R.string.text_maxima, temperaturaMaxima.toString())
            textUmidade.text = "$umidade%"
            textSensacao.text = resources.getString(R.string.text_valor_sensacao, sensacao.toString())
            textVisibilidade.text = resources.getString(R.string.text_valor_visibilidade, visibilidade.toString())
            textChuva.text = resources.getString(R.string.text_valor_chuva_numero, chuvaUtlimasTresHoras.toString())
        }

    }

}