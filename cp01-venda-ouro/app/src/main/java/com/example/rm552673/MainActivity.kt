package com.example.rm552673

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rm552673.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalc.setOnClickListener {
            send()
        }
    }

    private fun send() {

        if (validateFields()) {
            binding.tvInvalidFields.visibility = View.GONE
            val qtdGold = binding.etQtdGold.text.toString().toInt();
            val priceGold = binding.etPriceGold.text.toString().toDouble();

            val totalPrice = qtdGold * priceGold;

            binding.tvPriceTotal.text =
                getString(
                    R.string.price_total_gold, totalPrice.toString()
                )

            binding.tvPriceTotal.visibility = View.VISIBLE
        }

    }

    private fun validateFields(): Boolean {
        val qtdGold = binding.etQtdGold.text
        val priceGold = binding.etPriceGold.text

        if (qtdGold.isEmpty() || priceGold.isEmpty()) {
            binding.tvInvalidFields.visibility = View.VISIBLE
            return false;
        }
        if (qtdGold.toString().toInt() <= 0 || priceGold.toString().toDouble() == 0.0) {
            binding.tvInvalidFields.visibility = View.VISIBLE
            return false;
        }
        return true;
    }

}