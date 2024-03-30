package com.example.intentdasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var txtResult : TextView
    private val resultLauncer = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
        if (result.resultCode == GetInputActivity.RESULT_CODE && result.data != null){
            val valueIsi = result.data?.getStringExtra(GetInputActivity.EXTRA_INPUT_VALUE)
            txtResult.text = valueIsi
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, main2::class.java)
            startActivity(intent)
        }
        val btnMoveActivity: Button = findViewById(R.id.btn_one)
        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_two)
        val btnMovieWithDataObject : Button = findViewById(R.id.btn_three)
        val btnOpenGallery : Button = findViewById(R.id.btn_four)
        val btnSendMessage: Button = findViewById(R.id.btn_five)

        txtResult = findViewById(R.id.txt_result)



        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMovieWithDataObject.setOnClickListener(this)
        btnOpenGallery.setOnClickListener(this)
        btnSendMessage.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_one -> {
                val pindah = Intent(this@MainActivity,PerpindahanPertamaActivity::class.java)
                startActivity(pindah)
            }

            R.id.btn_two -> {
                val pindahWithData = Intent(this@MainActivity, PindahWithDataActivity::class.java)
                pindahWithData.putExtra(PindahWithDataActivity.EXTRA_NAME, "Maria")
                pindahWithData.putExtra(PindahWithDataActivity.EXTRA_AGE, 21)
                startActivity(pindahWithData)
            }

            R.id.btn_three -> {
                val person = Person(
                    "Mekey",
                    21,
                    "mekey@gmail.com",
                    "Jakarta"
                )
                val pindahWithObject = Intent(this@MainActivity, PindahWithDataObject::class.java)
                pindahWithObject.putExtra(PindahWithDataObject.EXTRA_PERSON,person)
                startActivity(pindahWithObject)
            }

            R.id.btn_four -> {
                val openG = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivity(openG)
            }

            R.id.btn_five -> {
                val moveForResultIntent = Intent(this@MainActivity, GetInputActivity::class.java)
                resultLauncer.launch(moveForResultIntent)
            }
        }
    }
}