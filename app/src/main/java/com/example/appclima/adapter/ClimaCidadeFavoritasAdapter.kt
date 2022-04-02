package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.model.ClimaCidade

class ClimaCidadeFavoritasAdapter (private val context: Context,
                                   private val listClimaCidade: List<ClimaCidade>): RecyclerView.Adapter<ClimaCidadeFavoritasAdapter.ClimaCidadeFavoritasHolder>() {

    class ClimaCidadeFavoritasHolder(view: View): RecyclerView.ViewHolder(view) {
        val textNomeCidade: TextView = view.findViewById(R.id.tv_nome_cidade)
        val textTemperaturaAtual: TextView  = view.findViewById(R.id.tv_temperatura_atual)
        val textDescricao: TextView  = view.findViewById(R.id.tv_descricao)
        val textMax: TextView  = view.findViewById(R.id.tv_max)
        val textMin: TextView  = view.findViewById(R.id.tv_min)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaCidadeFavoritasHolder {
        val adapterLayout = LayoutInflater.from(context).inflate(R.layout.item_clima_cidade_favorita, parent, false)
        return ClimaCidadeFavoritasHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ClimaCidadeFavoritasHolder, position: Int) {
        val item = listClimaCidade[position]

        with(holder){
            with(item){
                textNomeCidade.text = nomeCidade
                textTemperaturaAtual.text = context.resources.getString(R.string.text_temperatura_atual, temperaturaAtual.toString())
                textDescricao.text = descricao
                textMax.text = context.resources.getString(R.string.text_minima, temperaturaMinima.toString())
                textMin.text = context.resources.getString(R.string.text_maxima, temperaturaMaxima.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return  listClimaCidade.size
    }
}