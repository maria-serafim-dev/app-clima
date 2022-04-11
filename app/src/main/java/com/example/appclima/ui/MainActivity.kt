package com.example.appclima.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.example.appclima.R
import com.example.appclima.adapter.SlideCidadesPagerAdapter
import com.example.appclima.data.DataSource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarSlideCidades()
        ouvinteProcurarCidade()
    }

    private fun carregarSlideCidades() {
        val viewpager: ViewPager2 = findViewById(R.id.view_pager_activity)
        val adapter = SlideCidadesPagerAdapter(this, DataSource().listaClimaCidadeFavorita)
        viewpager.adapter = adapter

        val tabs: TabLayout = findViewById(R.id.into_tab_layout)

        TabLayoutMediator(tabs, viewpager)
        { tab, position ->}.attach()
    }

    private fun ouvinteProcurarCidade() {
        val imagemProcurar: ImageView = findViewById(R.id.img_procurar)
        imagemProcurar.setOnClickListener {
            val intent = Intent( this, ConfigurarCidadesActivity::class.java)
            startActivity(intent)
        }
    }
}