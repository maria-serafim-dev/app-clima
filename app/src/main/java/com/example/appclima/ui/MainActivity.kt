package com.example.appclima.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.appclima.R
import com.example.appclima.adapter.ClimaDiaAdapter
import com.example.appclima.adapter.ClimaHoraAdapter
import com.example.appclima.adapter.SlideCidadesPagerAdapter
import com.example.appclima.data.DataSource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarSlideCidades()
        ouvinteProcurarCidade()
        //carregarRecycleClimaPorHora()
        //carregarRecycleClimaPorDia()

    }

    private fun ouvinteProcurarCidade() {
        val imagemProcurar: ImageView = findViewById(R.id.img_procurar)
        imagemProcurar.setOnClickListener {
            val intent = Intent( this, ConfigurarCidadesActivity::class.java)
            startActivity(intent)
        }
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

    private fun carregarSlideCidades() {
        val viewpager: ViewPager2 = findViewById(R.id.view_pager_activity)
        val adapter = SlideCidadesPagerAdapter(this, DataSource().listaClimaCidadeFavorita)
        viewpager.adapter = adapter

        val tabs: TabLayout = findViewById(R.id.into_tab_layout)

        TabLayoutMediator(tabs, viewpager)
        { tab, position ->}.attach()
    }





}