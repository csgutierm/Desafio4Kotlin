package com.desafiolatam.desafio3

import android.os.Bundle

class ThirdActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        showToast("¡Hola desde ThirdActivity!")

    }

    override fun onBackButtonClicked() {
        onBackPressed()
    }
}