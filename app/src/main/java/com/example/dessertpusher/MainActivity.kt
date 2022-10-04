package com.example.dessertpusher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dessertpusher.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var revenue = 0
    private var dessertsSold = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("OnCreate Called yo")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.cupcakeButton.setOnClickListener {
            clickCupcake()
        }

        binding.revenue = revenue
        binding.dessertsSold = dessertsSold
    }

    private fun clickCupcake(){
        revenue += 10
        dessertsSold += 1

        binding.revenue = revenue
        binding.dessertsSold = dessertsSold
    }

    override fun onStart(){
        super.onStart()
        Timber.i("onStart Called yo")
    }

    override fun onResume(){
        super.onResume()
        Timber.i("onResume Called yo")
    }

    override fun onPause(){
        super.onPause()
        Timber.i("onPause Called yo")
    }

    override fun onStop(){
        super.onStop()
        Timber.i("onStop Called yo")
    }

    override fun onDestroy(){
        super.onDestroy()
        Timber.i("onDestroy Called yo")
    }

    override fun onRestart(){
        super.onRestart()
        Timber.i("onRestart Called yo")
    }
}