package com.example.linah_alkhurayyif_headsupgamesqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_upd_celebritie.*
import kotlinx.android.synthetic.main.activity_view_celebritie.*

class ViewCelebritie : AppCompatActivity() {
    private lateinit var db: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_celebritie)
        addNewCelebrity.setOnClickListener {
            intent = Intent(applicationContext, AddCelebrities::class.java)
            startActivity(intent)
        }
        vbabkbtn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        db = DatabaseHandler(this)
        if(getItemsList().isNotEmpty()){
            initializeRV()
        }

    }
    private fun getItemsList(): ArrayList<CelebritiesInfo>{
        return db.viewCelebritiesInfo()
    }
    private fun initializeRV(){
        recyclerView.adapter = CelebritiesAdapter(this@ViewCelebritie, getItemsList())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}