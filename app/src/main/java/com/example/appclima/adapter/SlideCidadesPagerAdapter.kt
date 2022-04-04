package com.example.appclima.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appclima.fragment.ViewPageConteudoFragment
import com.example.appclima.model.ClimaCidade

class SlideCidadesPagerAdapter(
    fragment: FragmentActivity,
    val listaCidade: List<ClimaCidade>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return listaCidade.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPageConteudoFragment(listaCidade.get(position))
        return fragment
    }
}