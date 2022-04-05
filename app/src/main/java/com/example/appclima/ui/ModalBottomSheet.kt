package com.example.appclima.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.adapter.ClimaDiaAdapter
import com.example.appclima.adapter.ClimaHoraAdapter
import com.example.appclima.data.DataSource
import com.example.appclima.model.ClimaCidade
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet(private val cidade: ClimaCidade): BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_view_page_conteudo, container, false)

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        carregarDadosCidade(view)
        carregarRecyclerClimaPorHora(view)
        carregarRecyclerClimaPorDia(view)
    }

    private fun carregarDadosCidade(view: View) {
        val textNomeCidade: TextView = view.findViewById(R.id.tv_nome_cidade)
        val textTemperaturaAtual: TextView = view.findViewById(R.id.tv_temperatura_atual)
        val textDescricao: TextView = view.findViewById(R.id.tv_descricao)
        val textMax: TextView = view.findViewById(R.id.tv_max)
        val textMin: TextView = view.findViewById(R.id.tv_min)
        val textUmidade: TextView = view.findViewById(R.id.tv_umidade)
        val textSensacao: TextView = view.findViewById(R.id.tv_sensacao)
        val textChuva: TextView = view.findViewById(R.id.tv_chuva)
        val textVisibilidade: TextView = view.findViewById(R.id.tv_visibilidade)
        val buttonCancelar: Button = view.findViewById(R.id.btn_cancelar)
        val buttonAdicionar: Button = view.findViewById(R.id.btn_adicionar)

        buttonAdicionar.visibility = View.VISIBLE
        buttonCancelar.visibility = View.VISIBLE

        with(cidade) {
            textNomeCidade.text = nomeCidade
            textTemperaturaAtual.text =
                resources.getString(R.string.text_temperatura_atual, temperaturaAtual.toString())
            textDescricao.text = descricao
            textMax.text = resources.getString(R.string.text_minima, temperaturaMinima.toString())
            textMin.text = resources.getString(R.string.text_maxima, temperaturaMaxima.toString())
            val textoUmidade = "$umidade%"
            textUmidade.text = textoUmidade
            textSensacao.text =
                resources.getString(R.string.text_valor_sensacao, sensacao.toString())
            textVisibilidade.text =
                resources.getString(R.string.text_valor_visibilidade, visibilidade.toString())
            textChuva.text = resources.getString(
                R.string.text_valor_chuva_numero,
                chuvaUtlimasTresHoras.toString()
            )
        }
    }


    private fun carregarRecyclerClimaPorHora(view: View) {
        val recyclerViewHora = view.findViewById<RecyclerView>(R.id.rv_clima_por_hora)
        val adapterHora = ClimaHoraAdapter(view.context, DataSource().listaClimaHora)
        recyclerViewHora.adapter = adapterHora
    }

    private fun carregarRecyclerClimaPorDia(view: View) {
        val recyclerViewDia = view.findViewById<RecyclerView>(R.id.rv_clima_por_dia)
        val adapterDia = ClimaDiaAdapter(view.context, DataSource().listaClimaDia)
        recyclerViewDia.adapter = adapterDia
    }
}