package com.example.jogodavelha

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ranking.*

class Ranking_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        try {
            val db = SqlHelper(this).writableDatabase
            val cursor = db.rawQuery(
                "SELECT $TBL_JOGO_WINNER, COUNT(*) as wins FROM $TBL_JOGO GROUP BY $TBL_JOGO_WINNER ORDER BY wins DESC;",
                null
            )
            while (cursor.moveToNext()) {

                jogador1.append(cursor.getString(cursor.getColumnIndex(TBL_JOGO_WINNER)) + "\n")
                vitorias1.append(cursor.getString(cursor.getColumnIndex("wins")) + "\n")
            }
            db.close()
        }catch (e:SQLiteException){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }
    }

    fun voltar(view:View){
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }
}


