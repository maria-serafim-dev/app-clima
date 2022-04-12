package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.databinding.ItemClimaCidadeFavoritaBinding
import com.example.appclima.model.ClimaCidade

class ClimaCidadeFavoritasAdapter (private val context: Context,
                                   private val listClimaCidade: List<ClimaCidade>): RecyclerView.Adapter<ClimaCidadeFavoritasAdapter.ClimaCidadeFavoritasHolder>() {


    var visiliby: Boolean? = null

    class ClimaCidadeFavoritasHolder(val binding: ItemClimaCidadeFavoritaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var layout = binding.cardCidade.layoutParams as LinearLayout.LayoutParams
        val marginStart = layout.marginStart
        val marginEnd = layout.marginEnd
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaCidadeFavoritasHolder {
        val binding = ItemClimaCidadeFavoritaBinding.inflate(LayoutInflater.from(context), parent, false)
        return ClimaCidadeFavoritasHolder(binding)
    }

    override fun onBindViewHolder(holder: ClimaCidadeFavoritasHolder, position: Int) {
        val item = listClimaCidade[position]

        with(holder){
            with(item) {
                binding.tvNomeCidade.text = nomeCidade
                binding.tvTemperaturaAtual.text = context.resources.getString(
                    R.string.text_temperatura_atual,
                    temperaturaAtual.toString()
                )

                if (visiliby == null) {
                    binding.tvDescricao.text = descricao
                    binding.tvMax.text = context.resources.getString(
                        R.string.text_minima,
                        temperaturaMinima.toString()
                    )
                    binding.tvMin.text = context.resources.getString(
                        R.string.text_maxima,
                        temperaturaMaxima.toString()
                    )
                } else if (visiliby == true) {
                    binding.imgRemocao.visibility = View.VISIBLE
                    binding.imgMudarPrioridade.visibility = View.VISIBLE
                    binding.tvDescricao.visibility = View.GONE
                    binding.tvMax.visibility = View.GONE
                    binding.tvMin.visibility = View.GONE
                    layout.marginStart = 0
                    layout.marginEnd = 0
                }else {
                    binding.imgRemocao.visibility = View.GONE
                    binding.imgMudarPrioridade.visibility = View.GONE
                    binding.tvDescricao.visibility = View.VISIBLE
                    binding.tvMax.visibility = View.VISIBLE
                    binding.tvMin.visibility = View.VISIBLE
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