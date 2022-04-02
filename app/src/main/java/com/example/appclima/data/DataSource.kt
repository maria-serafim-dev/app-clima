package com.example.appclima.data

import com.example.appclima.R
import com.example.appclima.model.ClimaCidade
import com.example.appclima.model.ClimaDia
import com.example.appclima.model.ClimaHora

class DataSource {

    val listaClimaHora = listOf<ClimaHora>(
        ClimaHora(0, R.drawable.ic_nuvem, 20),
        ClimaHora(1, R.drawable.ic_nuvem, 18),
        ClimaHora(2, R.drawable.ic_nuvem, 18),
        ClimaHora(3, R.drawable.ic_nuvem, 18),
        ClimaHora(4, R.drawable.ic_nuvem, 20),
        ClimaHora(5, R.drawable.ic_nuvem, 25),
        ClimaHora(6, R.drawable.ic_nuvem, 28),
        ClimaHora(7, R.drawable.ic_sun, 30),
        ClimaHora(8, R.drawable.ic_sun, 30),
        ClimaHora(9, R.drawable.ic_sun, 30),
        ClimaHora(10, R.drawable.ic_sun, 30),
        ClimaHora(11, R.drawable.ic_sun, 30),
        ClimaHora(12, R.drawable.ic_sun, 30),
    )

    val listaClimaDia = listOf<ClimaDia>(
        ClimaDia("Segunda", R.drawable.ic_nuvem, 20, 30),
        ClimaDia("Terça", R.drawable.ic_nuvem, 20, 30),
        ClimaDia("Quarta", R.drawable.ic_nuvem, 20, 30),
        ClimaDia("Quinta", R.drawable.ic_sun, 20, 30),
        ClimaDia("Sexta", R.drawable.ic_sun, 20, 30),
        ClimaDia("Sabado", R.drawable.ic_sun, 20, 30),
        ClimaDia("Domingo", R.drawable.ic_sun, 20, 30),
    )

    val cidadeParacatu = ClimaCidade("Paracatu", 30, "Céu Limpo",
        30, 30, 47, 29, 0, 16 )


    val listaClimaCidadeFavorita = listOf<ClimaCidade>(cidadeParacatu, cidadeParacatu, cidadeParacatu, cidadeParacatu, cidadeParacatu, cidadeParacatu)
}