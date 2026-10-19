package com.example.ulangan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ulangan.R

class kelompok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelompok)

        val btnNekt = findViewById<Button>(R.id.btnNekt)

        btnNekt.setOnClickListener {
            val intent = Intent(this, TransaksiPembelian::class.java)
            startActivity(intent)
        }
    }
}