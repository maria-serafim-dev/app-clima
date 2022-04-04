package com.example.appclima.data

import com.example.appclima.R
import com.example.appclima.model.ClimaCidade
import com.example.appclima.model.ClimaDia
import com.example.appclima.model.ClimaHora

class DataSource {

    val listaClimaHora: List<ClimaHora> = listOf(
        ClimaHora(0, R.drawable.ic_nuvem, 20),
        ClimaHora(1, R.drawable.ic_nuvem, 18),
        ClimaHora(2, R.drawable.ic_nuvem, 18),
        ClimaHora(3, R.drawable.ic_nuvem, 18),
        ClimaHora(4, R.drawable.ic_nuvem, 20),
        ClimaHora(5, R.drawable.ic_nuvem, 25),
        ClimaHora(6, R.drawable.ic_nuvem, 28),
        ClimaHora(7, R.drawable.ic_sol, 30),
        ClimaHora(8, R.drawable.ic_sol, 30),
        ClimaHora(9, R.drawable.ic_sol, 30),
        ClimaHora(10, R.drawable.ic_sol, 30),
        ClimaHora(11, R.drawable.ic_sol, 30),
        ClimaHora(12, R.drawable.ic_sol, 30),
    )

    val listaClimaDia: List<ClimaDia> = listOf(
        ClimaDia("Segunda", R.drawable.ic_nuvem, 20, 30),
        ClimaDia("Terça", R.drawable.ic_nuvem, 20, 30),
        ClimaDia("Quarta", R.drawable.ic_nuvem, 20, 30),
        ClimaDia("Quinta", R.drawable.ic_sol, 20, 30),
        ClimaDia("Sexta", R.drawable.ic_sol, 20, 30),
        ClimaDia("Sabado", R.drawable.ic_sol, 20, 30),
        ClimaDia("Domingo", R.drawable.ic_sol, 20, 30),
    )

    val listaClimaCidadeFavorita: List<ClimaCidade> = listOf(
        ClimaCidade("Paracatu", 30, "Céu Limpo",
            30, 30, 47, 29, 0, 16 ),
        ClimaCidade("Patos", 20, "Chuva",
        30, 30, 47, 29, 0, 16 ),
        ClimaCidade("Patrocínio", 18, "Chuva intensa",
            30, 30, 47, 29, 0, 16 )
    )
}