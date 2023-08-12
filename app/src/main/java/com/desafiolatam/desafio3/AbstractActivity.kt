package com.desafiolatam.desafio3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity : AppCompatActivity(), BackButtonClickListener {

    private var shouldShowBackButton = true

    fun setShowBackButton(shouldShow: Boolean) {
        shouldShowBackButton = shouldShow
        configureBackButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBackButton()
    }


    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun configureBackButton() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(shouldShowBackButton)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}