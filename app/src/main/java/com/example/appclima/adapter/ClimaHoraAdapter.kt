package com.example.appclima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclima.R
import com.example.appclima.databinding.ItemClimaPorHoraBinding
import com.example.appclima.model.ClimaHora

class ClimaHoraAdapter(
    private val context: Context,
    private val listClimaHora: List<ClimaHora>): RecyclerView.Adapter<ClimaHoraAdapter.ClimaHoraViewHolder>() {

    class ClimaHoraViewHolder(val binding: ItemClimaPorHoraBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClimaHoraViewHolder {
        val binding = ItemClimaPorHoraBinding.inflate(LayoutInflater.from(context), parent, false)
        return ClimaHoraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClimaHoraViewHolder, position: Int) {
        val item = listClimaHora[position]
        
        with(holder.binding){
            tvTemperaturaHora.text = context.resources.getString(R.string.text_temperatura_por_hora, item.temperatura.toString())
            tvHora.text = item.hora.toString()
            iconeTempo.setImageResource(item.icon)
        }
    }

    override fun getItemCount(): Int {
       return  listClimaHora.size
    }
}