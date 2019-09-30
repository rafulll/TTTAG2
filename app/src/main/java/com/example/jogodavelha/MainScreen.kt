package com.example.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        textView2.text = "JOGO DA VELHA"
    }
    fun play(view: View){
        val buttonClicked = view as Button

        when(buttonClicked.id){
            R.id.button12 -> {


                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("player1", editText.text.toString())
                intent.putExtra("player2", editText2.text.toString())


                startActivity(intent)
                finish()

            }

        }


    }
}
