package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.model.ClimaDia
import com.example.appclima.model.ClimaHora
import com.google.android.material.slider.Slider

class ClimaDiaAdapter (private val context: Context,
private val listClimaDia: List<ClimaDia>): RecyclerView.Adapter<ClimaDiaAdapter.ClimaDiaViewHolder>() {

    class ClimaDiaViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textDiaSemana: TextView = view.findViewById(R.id.tv_dia_semana)
        val textMinPorDia: TextView = view.findViewById(R.id.tv_min_por_dia)
        val textMaxPorDia: TextView = view.findViewById(R.id.tv_max_por_dia)
        val iconeTempoPorDia: ImageView = view.findViewById(R.id.icone_tempo_por_dia)
        val slider: Slider = view.findViewById(R.id.slider_por_dia)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaDiaViewHolder {
        val adapterLayout = LayoutInflater.from(context).inflate(R.layout.item_clima_por_dia, parent, false)
        return ClimaDiaViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ClimaDiaViewHolder, position: Int) {
        val item = listClimaDia[position]
        holder.textMinPorDia.text = context.resources.getString(R.string.text_temperatura_min_por_dia, item.temperaturaMinima.toString())
        holder.textMaxPorDia.text = context.resources.getString(R.string.text_temperatura_min_por_dia, item.temperaturaMaxima.toString())
        holder.textDiaSemana.text = item.dia
        holder.iconeTempoPorDia.setImageResource(item.icone)
        holder.slider.valueFrom = item.temperaturaMinima.toFloat()
        holder.slider.valueTo = item.temperaturaMaxima.toFloat()
        holder.slider.value = (item.temperaturaMaxima.toFloat() + item.temperaturaMinima.toFloat()) / 2
        holder.slider.stepSize = 1.0F
    }

    override fun getItemCount(): Int {
        return  listClimaDia.size
    }
}