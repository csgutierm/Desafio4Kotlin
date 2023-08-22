package com.desafiolatam.desafio3

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import com.desafiolatam.desafio3.databinding.ActivityMainBinding

class MainActivity : AbstractActivity() , OnCardClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mediaPlayer: MediaPlayer

    private val completionListener = MediaPlayer.OnCompletionListener {
        mediaPlayer.seekTo(0)
        mediaPlayer.start()
        isPlaying = true
        handler.post(updateCurrentTimeRunnable)
    }

    private val handler = Handler()

    private val updateCurrentTimeRunnable = object : Runnable {
        override fun run() {
            if (mediaPlayer.isPlaying) {
                showCurrentTime()
                handler.postDelayed(this, 1000) // Actualizar cada 1 segundo
            }
        }
    }


    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setShowBackButton(false)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
        binding.cardView1.setOnClickListener {
            onCardClick(1)
        }

        binding.cardView2.setOnClickListener {
            onCardClick(2)
        }

        binding.cardView3.setOnClickListener {
            onCardClick(3)
        }

        binding.cardView4.setOnClickListener {
            onCardClick(4)
        }

        binding.cardView5.setOnClickListener {
            onCardClick(5)
        }
*/
        for (i in 1..5) {
            val cardView = when (i) {
                1 -> binding.cardView1
                2 -> binding.cardView2
                3 -> binding.cardView3
                4 -> binding.cardView4
                5 -> binding.cardView5
                else -> null
            }

            cardView?.setOnClickListener {
                onCardClick(i)
            }
        }

        showToast("¡Bienvenido!")

        mediaPlayer = MediaPlayer.create(this, R.raw.song)
        mediaPlayer.setOnCompletionListener(completionListener)//completada la canción
        mediaPlayer.setVolume(1f, 1f)
        mediaPlayer.start()
        handler.post(updateCurrentTimeRunnable)

        binding.playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                isPlaying = true
                handler.post(updateCurrentTimeRunnable)
            }
        }

        binding.pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
                handler.removeCallbacks(updateCurrentTimeRunnable)
            }
        }

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
            5 -> Intent(this, SixthActivity::class.java)
            else -> throw IllegalArgumentException("Card number not recognized")
        }
        startActivity(intent)
    }

    private fun showCurrentTime() {
        val currentPosition = mediaPlayer.currentPosition
        val minutes = currentPosition / 1000 / 60
        val seconds = currentPosition / 1000 % 60
        val timerText = String.format("%02d:%02d", minutes, seconds)
        binding.timerTextView.text = timerText
    }


}