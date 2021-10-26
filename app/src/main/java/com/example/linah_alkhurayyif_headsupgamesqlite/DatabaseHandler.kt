package com.example.linah_alkhurayyif_headsupgamesqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context, "celebrities.db", null, 1){
    var sqlDb: SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            db.execSQL("CREATE TABLE celebrities (id integer primary key autoincrement,Name text, Taboo1 text, Taboo2 text, Taboo3 text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}
    fun addCelebrities(name: String, taboo1: String, taboo2: String, taboo3: String): Long{

        val contentValues = ContentValues()
        contentValues.put("Name", name)
        contentValues.put("Taboo1", taboo1)
        contentValues.put("Taboo2", taboo2)
        contentValues.put("Taboo3", taboo3)
        val success = sqlDb.insert("celebrities", null, contentValues)
        return success
    }
    @SuppressLint("Range")
    fun viewCelebritiesInfo(): ArrayList<CelebritiesInfo>{
        val celebritiesList: ArrayList<CelebritiesInfo> = ArrayList()
        val selectQuery = "SELECT * FROM celebrities"

        var cursor: Cursor? = null

        try {
            cursor = sqlDb.rawQuery(selectQuery, null)
        } catch (e: SQLiteException){
            sqlDb.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var taboo1: String
        var taboo2: String
        var taboo3: String
        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                name = cursor.getString(cursor.getColumnIndexOrThrow("Name"))
                taboo1 = cursor.getString(cursor.getColumnIndexOrThrow("Taboo1"))
                taboo2 = cursor.getString(cursor.getColumnIndexOrThrow("Taboo2"))
                taboo3 = cursor.getString(cursor.getColumnIndexOrThrow("Taboo3"))


                val celebrities = CelebritiesInfo(id,name,taboo1,taboo2,taboo3)
                celebritiesList.add(celebrities)
            } while (cursor.moveToNext())
        }

        return celebritiesList
    }
    fun updateCelebrities(celebrities: CelebritiesInfo): Int {
        val contentValues = ContentValues()

        contentValues.put("Name", celebrities.name)
        contentValues.put("Taboo1", celebrities.taboo1)
        contentValues.put("Taboo2", celebrities.taboo2)
        contentValues.put("Taboo3", celebrities.taboo3)
        val success = sqlDb.update("celebrities", contentValues, "id = ${celebrities.id}", null)
        return success
    }
    fun deleteCelebrity(celebrities: CelebritiesInfo): Int{
        val contentValues = ContentValues()
        contentValues.put("id", celebrities.id)
        val success = sqlDb.delete("celebrities", "id = ${celebrities.id}", null)
        return success
    }
}