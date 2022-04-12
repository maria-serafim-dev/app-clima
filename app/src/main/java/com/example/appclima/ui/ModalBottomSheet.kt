package com.example.appclima.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.appclima.R
import com.example.appclima.adapter.ClimaDiaAdapter
import com.example.appclima.adapter.ClimaHoraAdapter
import com.example.appclima.data.DataSource
import com.example.appclima.databinding.FragmentViewPageConteudoBinding
import com.example.appclima.model.ClimaCidade
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.shape.CornerFamily


class ModalBottomSheet(private val cidade: ClimaCidade): BottomSheetDialogFragment() {

    private var _binding : FragmentViewPageConteudoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentViewPageConteudoBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        carregarDadosCidade()
        carregarRecyclerClimaPorHora(view)
        carregarRecyclerClimaPorDia(view)
    }

    private fun carregarDadosCidade() {
        configurarImagemBackground()

        binding.btnAdicionar.visibility = View.VISIBLE
        binding.btnCancelar.visibility = View.VISIBLE

        with(binding){
            with(cidade) {
                tvNomeCidade.text = nomeCidade
                tvTemperaturaAtual.text = resources.getString(R.string.text_temperatura_atual, temperaturaAtual.toString())
                tvDescricao.text = descricao
                tvMax.text = resources.getString(R.string.text_minima, temperaturaMinima.toString())
                tvMin.text = resources.getString(R.string.text_maxima, temperaturaMaxima.toString())
                val textoUmidade = "$umidade%"
                tvUmidade.text = textoUmidade
                tvSensacao.text = resources.getString(R.string.text_valor_sensacao, sensacao.toString())
                tvVisibilidade.text = resources.getString(R.string.text_valor_visibilidade, visibilidade.toString())
                tvChuva.text = resources.getString(
                    R.string.text_valor_chuva_numero,
                    chuvaUtlimasTresHoras.toString()
                )
            }
        }
    }

    private fun configurarImagemBackground() {
        val radius = resources.getDimension(R.dimen.shape_radius_bottom_sheet)
        binding.imgBackground.shapeAppearanceModel = binding.imgBackground.shapeAppearanceModel
            .toBuilder()
            .setTopRightCorner(CornerFamily.ROUNDED, radius)
            .setTopLeftCorner(CornerFamily.ROUNDED, radius)
            .build()
    }

    private fun carregarRecyclerClimaPorHora(view: View) {
        val adapterHora = ClimaHoraAdapter(view.context, DataSource().listaClimaHora)
        binding.rvClimaPorHora.adapter = adapterHora
    }

    private fun carregarRecyclerClimaPorDia(view: View) {
        val adapterDia = ClimaDiaAdapter(view.context, DataSource().listaClimaDia)
        binding.rvClimaPorDia.adapter = adapterDia
        binding.rvClimaPorDia.addItemDecoration(
            DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        )
    }
}