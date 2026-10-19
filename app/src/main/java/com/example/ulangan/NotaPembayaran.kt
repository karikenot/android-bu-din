package com.example.ulangan

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ulangan.R

class NotaPembayaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_pembayaran)

        val tvNama = findViewById<TextView>(R.id.tvNamaPembeli)
        val tvKemasan = findViewById<TextView>(R.id.tvKemasan)
        val tvJenisKopi = findViewById<TextView>(R.id.tvJenisKopi)
        val tvJumlahBayar = findViewById<TextView>(R.id.tvJumlahBayar)

        val nama = intent.getStringExtra("NAMA") ?: "-"
        val kemasan = intent.getStringExtra("KEMASAN") ?: "-"
        val kopi = intent.getStringExtra("KOPI") ?: "-"
        val total = intent.getIntExtra("TOTAL", 0)

        tvNama.text = nama
        tvKemasan.text = kemasan
        tvJenisKopi.text = kopi
        tvJumlahBayar.text = "Rp $total"
    }
}