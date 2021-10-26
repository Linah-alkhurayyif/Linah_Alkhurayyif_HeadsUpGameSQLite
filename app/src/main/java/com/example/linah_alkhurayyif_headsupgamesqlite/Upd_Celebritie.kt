package com.example.linah_alkhurayyif_headsupgamesqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_upd_celebritie.*

class Upd_Celebritie : AppCompatActivity() {
    private lateinit var db: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upd_celebritie)
        db = DatabaseHandler(this)
        var Celebritie_Id = intent.extras?.getInt("Celebritie_Id")!!
        var Celebritie_Name =intent.extras?.getString("Celebritie_Name")!!
        var Taboo1 =intent.extras?.getString("Taboo1")!!
        var Taboo2 =intent.extras?.getString("Taboo2")!!
        var Taboo3 =intent.extras?.getString("Taboo3")!!
        UCelebritie_id.text = "Celebrity ${Celebritie_Id}"
        UName.hint = Celebritie_Name
        UTaboo1.hint = Taboo1
        UTaboo2.hint = Taboo2
        UTaboo3.hint = Taboo3

        babkbtn.setOnClickListener {
            intent = Intent(applicationContext, ViewCelebritie::class.java)
            startActivity(intent)
        }
        Usavebtn.setOnClickListener {
            var CelebritieName =Celebritie_Name
            var Taboo_1 =Taboo1
            var Taboo_2 =Taboo2
            var Taboo_3 =Taboo3
            if(UName.text.toString() != ""){
                CelebritieName=UName.text.toString()
            }
            if(UTaboo1.text.toString() != ""){
                Taboo_1= UTaboo1.text.toString()
            }
            if(UTaboo2.text.toString() != ""){
                Taboo_2= UTaboo2.text.toString()
            }
            if(UTaboo3.text.toString() != ""){
                Taboo_3= UTaboo3.text.toString()
            }
            db.updateCelebrities(CelebritiesInfo(Celebritie_Id,CelebritieName,Taboo_1,Taboo_2,Taboo_3))
            nextPage()
        }
    }
    private fun nextPage(){
        intent = Intent(applicationContext, ViewCelebritie::class.java)
        startActivity(intent)
    }
}