package com.example.linah_alkhurayyif_headsupgamesqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_celebrities.*

class AddCelebrities : AppCompatActivity() {
    private lateinit var dbHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_celebrities)
        dbHandler = DatabaseHandler(this)
        Abackbtn.setOnClickListener {
            intent = Intent(applicationContext, ViewCelebritie::class.java)
            startActivity(intent)
        }
        Asavebtn.setOnClickListener {
            if(name_et.text.isEmpty() || taboo1_et.text.isEmpty() || taboo2_et.text.isEmpty() || taboo3_et.text.isEmpty()){
                Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()

            }else{
                dbHandler.addCelebrities(name_et.text.toString(),taboo1_et.text.toString(),taboo2_et.text.toString(),taboo3_et.text.toString())
                name_et.setText("")
                taboo1_et.setText("")
                taboo2_et.setText("")
                taboo3_et.setText("")
                Toast.makeText(this, "Celebrity added", Toast.LENGTH_LONG).show()
                intent = Intent(applicationContext, ViewCelebritie::class.java)
                startActivity(intent)
            }

        }
    }}