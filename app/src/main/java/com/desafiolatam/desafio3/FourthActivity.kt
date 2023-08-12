package com.desafiolatam.desafio3

import android.os.Bundle

class FourthActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        showToast("¡Hola desde FourthActivity!")
    }

    override fun onBackButtonClicked() {
        TODO("Not yet implemented")
    }
}