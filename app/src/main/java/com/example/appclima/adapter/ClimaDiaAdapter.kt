package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.databinding.ItemClimaPorDiaBinding
import com.example.appclima.model.ClimaDia

class ClimaDiaAdapter (private val context: Context,
private val listClimaDia: List<ClimaDia>): RecyclerView.Adapter<ClimaDiaAdapter.ClimaDiaViewHolder>() {

    class ClimaDiaViewHolder(val binding: ItemClimaPorDiaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaDiaViewHolder {
        val binding = ItemClimaPorDiaBinding.inflate(LayoutInflater.from(context), parent, false)
        return ClimaDiaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClimaDiaViewHolder, position: Int) {
        val item = listClimaDia[position]
        
        with(holder.binding){
            tvMinPorDia.text = context.resources.getString(R.string.text_temperatura_min_por_dia, item.temperaturaMinima.toString())
            tvMaxPorDia.text = context.resources.getString(R.string.text_temperatura_min_por_dia, item.temperaturaMaxima.toString())
            tvDiaSemana.text = item.dia
            iconeTempoPorDia.setImageResource(item.icone)
            sliderPorDia.valueFrom = item.temperaturaMinima.toFloat()
            sliderPorDia.valueTo = item.temperaturaMaxima.toFloat()
            sliderPorDia.value = (item.temperaturaMaxima.toFloat() + item.temperaturaMinima.toFloat()) / 2
            sliderPorDia.stepSize = 1.0F
        }
    }

    override fun getItemCount(): Int {
        return  listClimaDia.size
    }
}