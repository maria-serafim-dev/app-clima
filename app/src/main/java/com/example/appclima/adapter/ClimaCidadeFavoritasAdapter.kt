package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.model.ClimaCidade

class ClimaCidadeFavoritasAdapter (private val context: Context,
                                   private val listClimaCidade: List<ClimaCidade>): RecyclerView.Adapter<ClimaCidadeFavoritasAdapter.ClimaCidadeFavoritasHolder>() {


    var visiliby: Boolean? = null

    class ClimaCidadeFavoritasHolder(view: View): RecyclerView.ViewHolder(view) {
        val textNomeCidade: TextView = view.findViewById(R.id.tv_nome_cidade)
        val textTemperaturaAtual: TextView  = view.findViewById(R.id.tv_temperatura_atual)
        val textDescricao: TextView  = view.findViewById(R.id.tv_descricao)
        val textMax: TextView  = view.findViewById(R.id.tv_max)
        val textMin: TextView  = view.findViewById(R.id.tv_min)
        val imgRemocao: ImageView = view.findViewById(R.id.img_remocao)
        val imgMudarPrioridade: ImageView = view.findViewById(R.id.img_mudar_prioridade)
        var cardCidades: CardView = view.findViewById(R.id.card_cidade)
        var layout = cardCidades.layoutParams as LinearLayout.LayoutParams
        val marginStart = layout.marginStart
        val marginEnd = layout.marginEnd
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

                if (visiliby == null){
                    textDescricao.text = descricao
                    textMax.text = context.resources.getString(R.string.text_minima, temperaturaMinima.toString())
                    textMin.text = context.resources.getString(R.string.text_maxima, temperaturaMaxima.toString())
                } else if (visiliby == true){
                    imgRemocao.visibility = View.VISIBLE
                    imgMudarPrioridade.visibility = View.VISIBLE
                    textDescricao.visibility = View.GONE
                    textMax.visibility = View.GONE
                    textMin.visibility = View.GONE
                    layout.marginStart = 0
                    layout.marginEnd = 0
                }else{
                    imgRemocao.visibility = View.GONE
                    imgMudarPrioridade.visibility = View.GONE
                    textDescricao.visibility = View.VISIBLE
                    textMax.visibility = View.VISIBLE
                    textMin.visibility = View.VISIBLE
                    layout.marginStart = marginStart
                    layout.marginEnd = marginEnd
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return  listClimaCidade.size
    }

}