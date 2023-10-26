package com.example.abubakir_turakulov_hw_5_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abubakir_turakulov_hw_5_3.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0
    private var isIncrementing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnMath.setOnClickListener {
            if (isIncrementing) {
                count++
            } else {
                count--
            }

            if (count == 10) {
                binding.btnMath.text = "-1"
                isIncrementing = false
            } else if (count == 0) {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                count = 0
                binding.btnMath.text = "+1"
                isIncrementing = true
            } else if (count < 0) {
                count = 0
            }

            binding.tvText.text = count.toString()
        }
    }
}