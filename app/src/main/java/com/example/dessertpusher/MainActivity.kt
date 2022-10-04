package com.example.dessertpusher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dessertpusher.databinding.ActivityMainBinding
import timber.log.Timber

const val KEY_REVENUE = "key_revenue"
const val KEY_DESSERTS_SOLD = "key_desserts_sold"
const val KEY_TIMER_SECS = "key_timer"

class MainActivity : AppCompatActivity() {

    private var revenue = 0
    private var dessertsSold = 0
    private lateinit var dessertTimer: DessertTimer

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("OnCreate Called yo")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.cupcakeButton.setOnClickListener {
            clickCupcake()
        }

        dessertTimer = DessertTimer(this.lifecycle)

        if (savedInstanceState != null){
            revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
            dessertsSold = savedInstanceState.getInt(KEY_DESSERTS_SOLD, 0)
            dessertTimer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECS,0)
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

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(KEY_REVENUE, revenue)
        outState.putInt(KEY_DESSERTS_SOLD, dessertsSold)
        outState.putInt(KEY_TIMER_SECS, dessertTimer.secondsCount)
        super.onSaveInstanceState(outState)
        Timber.i("Instances stored")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Timber.i("Instances restored")
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