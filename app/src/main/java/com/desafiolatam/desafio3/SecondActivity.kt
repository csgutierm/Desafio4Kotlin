package com.desafiolatam.desafio3

import android.os.Bundle

class SecondActivity : AbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showToast("¡Hola desde SecondActivity!")
    }

    override fun onBackButtonClicked() {
        TODO("Not yet implemented")
    }
}