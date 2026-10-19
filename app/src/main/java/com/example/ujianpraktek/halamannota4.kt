package com.example.ujianpraktek

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ujianpraktek.R

class halamannota4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halamannota4)

        val tvKemasan = findViewById<TextView>(R.id.tvKemasan)
        val tvJenisKopi = findViewById<TextView>(R.id.tvJenisKopi)
        val tvJumlahBayar = findViewById<TextView>(R.id.tvJumlahBayar)

        val nama = intent.getStringExtra("NAMA") ?: "-"
        val kemasan = intent.getStringExtra("KEMASAN") ?: "-"
        val kopi = intent.getStringExtra("KOPI") ?: "-"
        val total = intent.getIntExtra("TOTAL", 0)

        tvKemasan.text = kemasan
        tvJenisKopi.text = kopi
        tvJumlahBayar.text = "Rp $total"
    }
}