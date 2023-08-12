package com.desafiolatam.desafio3

import android.content.Intent
import android.os.Bundle
import com.desafiolatam.desafio3.databinding.ActivityMainBinding

class MainActivity : AbstractActivity() , OnCardClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setShowBackButton(false)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardView1.setOnClickListener {
            //startActivity(Intent(this, SecondActivity::class.java))
            onCardClick(1)
        }

        binding.cardView2.setOnClickListener {
            //startActivity(Intent(this, ThirdActivity::class.java))
            onCardClick(2)
        }

        binding.cardView3.setOnClickListener {
            //startActivity(Intent(this, FourthActivity::class.java))
            onCardClick(3)
        }

        binding.cardView4.setOnClickListener {
            //startActivity(Intent(this, FifthActivity::class.java))
            onCardClick(4)
        }

        showToast("¡Bienvenido!")
    }

    override fun onBackButtonClicked() {
        TODO("Not yet implemented")
    }


    override fun onCardClick(cardNumber: Int) {
        val intent = when (cardNumber) {
            1 -> Intent(this, SecondActivity::class.java)
            2 -> Intent(this, ThirdActivity::class.java)
            3 -> Intent(this, FourthActivity::class.java)
            4 -> Intent(this, FifthActivity::class.java)
            else -> throw IllegalArgumentException("Card number not recognized")
        }
        startActivity(intent)
    }

}