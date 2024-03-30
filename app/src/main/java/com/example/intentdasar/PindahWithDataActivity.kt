package com.example.intentdasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahWithDataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "NAME"
        const val EXTRA_AGE = "AGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_with_data)

        val txtData : TextView = findViewById(R.id.txt_data_move1)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val tampilkan = "Happy birthday $name yang ke-$age"
        txtData.text = tampilkan


    }
}