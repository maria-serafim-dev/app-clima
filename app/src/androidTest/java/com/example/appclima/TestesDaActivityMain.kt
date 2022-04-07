package com.example.appclima

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.appclima.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class TestesDaActivityMain {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun recyclerViewClimaPorHoraCarregada() {
        onView(withId(R.id.rv_clima_por_hora))
            .check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewClimaPorDiaCarregada() {
        onView(withId(R.id.rv_clima_por_dia))
            .check(matches(isDisplayed()))
    }



}