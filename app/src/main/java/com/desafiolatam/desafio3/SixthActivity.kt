package com.desafiolatam.desafio3

import android.os.Bundle

class SixthActivity : AbstractActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)

        showToast("¡Hola desde SixthActivity!")
    }

    override fun onBackButtonClicked() {
        TODO("Not yet implemented")
    }
}