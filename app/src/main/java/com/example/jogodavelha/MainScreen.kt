package com.example.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        //val db = DataBaseAccess(this).login("RAFUL","123")
//        Toast.makeText(this, db.toString(), Toast.LENGTH_LONG).show()
        editText.setText(intent.getStringExtra("player"))
    }

    fun logoff() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun play(view: View) {
        val buttonClicked = view as Button


        when (buttonClicked.id) {
            R.id.btnJogar -> {


                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("player1", editText.text.toString())
                intent.putExtra("player2", editText2.text.toString())
                intent.putExtra("jogador", intent.getStringExtra("jogador"))


                startActivity(intent)
                finish()

            }
            R.id.btnRanking -> {
                val intent = Intent(this, Ranking_Activity::class.java)



                startActivity(intent)
                finish()

            }

        }


    }
}
