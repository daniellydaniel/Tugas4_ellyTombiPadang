package com.example.intentdasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class GetInputActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnSend : Button
    private lateinit var edtInput : EditText

    companion object {
        const val EXTRA_INPUT_VALUE = "extra_input_value"
        const val RESULT_CODE = 101
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_input)

        btnSend = findViewById(R.id.btn_send)
        edtInput = findViewById(R.id.edt_message)

        btnSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_send) {

            val inputText = edtInput.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_INPUT_VALUE,inputText)
            setResult(RESULT_CODE,resultIntent)
            finish()
        }
    }
}