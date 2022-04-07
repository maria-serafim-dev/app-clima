package com.example.appclima

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.appclima.ui.ConfigurarCidadesActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@MediumTest
class TesteDaConfigurarCidadesActivity {

    @get:Rule
    var activityRule: ActivityScenarioRule<ConfigurarCidadesActivity>
            = ActivityScenarioRule(ConfigurarCidadesActivity::class.java)

    @Test
    fun recyclerViewCidadesFavoritasCarregada() {
        onView(withId(R.id.rv_clima_cidades_favoritas))
            .check(matches(isDisplayed()))
    }

}