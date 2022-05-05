package com.example.appclima.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.appclima.adapter.SlideCidadesPagerAdapter
import com.example.appclima.data.DataSource
import com.example.appclima.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carregarSlideCidades()
        ouvinteProcurarCidade()
    }

    private fun carregarSlideCidades() {
        val adapter = SlideCidadesPagerAdapter(this, DataSource().listaClimaCidadeFavorita)
        binding.viewPagerActivity.adapter = adapter

        TabLayoutMediator(binding.intoTabLayout, binding.viewPagerActivity)
        { _, _ ->}.attach()
    }

    private fun ouvinteProcurarCidade() {
        binding.imgProcurar.setOnClickListener {
            val intent = Intent( this, ConfigurarCidadesActivity::class.java)
            startActivity(intent)
        }
    }
}