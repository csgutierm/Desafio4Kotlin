package com.desafiolatam.desafio3

import android.os.Bundle

class FifthActivity : AbstractActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        showToast("¡Hola desde FifthActivity!")
    }

    override fun onBackButtonClicked() {
        TODO("Not yet implemented")
    }
}