package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.model.ClimaHora

class ClimaHoraAdapter(
    private val context: Context,
    private val listClimaHora: List<ClimaHora>): RecyclerView.Adapter<ClimaHoraAdapter.ClimaHoraViewHolder>() {

    class ClimaHoraViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textHora: TextView = view.findViewById(R.id.tv_hora)
        val textTemperatura: TextView = view.findViewById(R.id.tv_temperatura_hora)
        val iconeTempo: ImageView = view.findViewById(R.id.icone_tempo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaHoraViewHolder {
        val adapterLayout = LayoutInflater.from(context).inflate(R.layout.item_clima_por_hora, parent, false)
        return ClimaHoraViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ClimaHoraViewHolder, position: Int) {
        val item = listClimaHora[position]
        holder.textTemperatura.text = context.resources.getString(R.string.text_temperatura_por_hora, item.temperatura.toString())
        holder.textHora.text = item.hora.toString()
        holder.iconeTempo.setImageResource(item.icon)
    }

    override fun getItemCount(): Int {
       return  listClimaHora.size
    }
}