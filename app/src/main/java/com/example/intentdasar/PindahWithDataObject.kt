package com.example.intentdasar

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PindahWithDataObject : AppCompatActivity() {

    companion object{
        val EXTRA_PERSON ="extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_with_data_object)

        val txtObject : TextView = findViewById(R.id.txt_data_object)

        val person = if(Build.VERSION.SDK_INT >= 33){
                intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DESPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null ){
            val tampilkan = "Hello \n My Name is ${person.name} \nI'm ${person.age} years old\nMy email : ${person.email}\nI'm from ${person.city}"
            txtObject.text = tampilkan
        }

    }
}