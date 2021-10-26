package com.example.linah_alkhurayyif_headsupgamesqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_del_celebritie.*

class Del_Celebritie : AppCompatActivity() {
    private lateinit var db: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_del_celebritie)
        db = DatabaseHandler(this)
        gobaclk.setOnClickListener {
            intent = Intent(applicationContext, ViewCelebritie::class.java)
            startActivity(intent)
        }
        var Celebritie_Id = intent.extras?.getInt("Celebritie_Id")!!
        var Celebritie_Name =intent.extras?.getString("Celebritie_Name")!!
        var Taboo1 =intent.extras?.getString("Taboo1")!!
        var Taboo2 =intent.extras?.getString("Taboo2")!!
        var Taboo3 =intent.extras?.getString("Taboo3")!!
        deletedUser.text = "The user ${Celebritie_Id} successfully deleted !!"
        db.deleteCelebrity(CelebritiesInfo(Celebritie_Id,Celebritie_Name,Taboo1,Taboo2,Taboo3))
    }
}