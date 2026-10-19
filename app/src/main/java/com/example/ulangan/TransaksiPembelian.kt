package com.example.ulangan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ulangan.R

class TransaksiPembelian : AppCompatActivity() {

    private var nama = ""
    private var totalBayar = 0
    private var kemasanPilihan = ""
    private var kopiPilihan = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi_pembelian)


        val etNama = findViewById<EditText>(R.id.etNama)
        val rgKemasan = findViewById<RadioGroup>(R.id.rgKemasan)
        val rbHot = findViewById<RadioButton>(R.id.rbHot)
        val rbIce = findViewById<RadioButton>(R.id.rbIce)
        val cbRobusta = findViewById<CheckBox>(R.id.cbRobusta)
        val cbArabika = findViewById<CheckBox>(R.id.cbArabika)
        val cbGayo = findViewById<CheckBox>(R.id.cbGayo)
        val tvTotalBayar = findViewById<TextView>(R.id.tvTotalBayar)

        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        // Tombol Hitung
        btnHitung.setOnClickListener {
            totalBayar = 0
            kopiPilihan = ""

            kemasanPilihan = when {
                rbHot.isChecked -> "Hot"
                rbIce.isChecked -> "Ice"
                else -> "-"
            }

            if (cbRobusta.isChecked) {
                totalBayar += 15000
                kopiPilihan += "Robusta "
            }
            if (cbArabika.isChecked) {
                totalBayar += 18000
                kopiPilihan += "Arabika "
            }
            if (cbGayo.isChecked) {
                totalBayar += 20000
                kopiPilihan += "Gayo "
            }

            tvTotalBayar.text = "Total Bayar : Rp $totalBayar"
        }

        // Tombol Home -> Balik ke Menu
        btnHome.setOnClickListener {
            val intent = Intent(this, HalamanMenu::class.java)
            startActivity(intent)
            finish()
        }

        // Tombol Kirim / Next -> Ke Nota Pembayaran
        btnKirim.setOnClickListener {
            if (totalBayar == 0) {
                Toast.makeText(this, "Hitung dulu total bayarnya!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nama = etNama.text.toString().trim()
            val intent = Intent(this, NotaPembayaran::class.java).apply {
                putExtra("NAMA", nama)
                putExtra("KEMASAN", kemasanPilihan)
                putExtra("KOPI", kopiPilihan)
                putExtra("TOTAL", totalBayar)
            }
            startActivity(intent)
        }
    }
}