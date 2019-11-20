package com.example.jogodavelha

import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_screen.*
import kotlinx.android.synthetic.main.activity_sql.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    var ganhador = 4
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var playsCount = 0
    var playerAtivo = 1
    var activeGame = 1
    fun verificarGanhador() {

        //Linhas 123
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))//jogador 1
        {
            ganhador = 1
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
            activeGame = 0
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player1.contains(1) && player1.contains(4) && player1.contains(7))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        //Linhas 456
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6))//jogador 1
        {

            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player1.contains(2) && player1.contains(5) && player1.contains(8))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        //Linhas 789
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
        }
        //Diagonais
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        } else if (player1.contains(3) && player1.contains(5) && player1.contains(7))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        } else if (player1.contains(3) && player1.contains(6) && player1.contains(9))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        }

        if (ganhador == 1) {
            Toast.makeText(
                this,
                "Parabens, " + intent.getStringExtra("player$ganhador") + ". Você venceu!!!",
                Toast.LENGTH_LONG
            ).show()
            activeGame = 0

            try {
                val bd = SqlHelper(this).writableDatabase

                // val contentValues = ContentValues()
                // contentValues.put(TBL_USUARIO_LOGIN, edtLogin.text.toString())
                // contentValues.put(TBL_USUARIO_SENHA, edtSenha.text.toString())
                val contentValues = ContentValues().apply {
                    put(TBL_JOGO_WINNER, intent.getStringExtra("player$ganhador"))
                }

                bd.insert(
                    TBL_JOGO, null, contentValues
                )


                bd.close()
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }

        } else if (ganhador == 2) {
            Toast.makeText(
                this,
                "Parabens, " + intent.getStringExtra("player$ganhador") + ". Você venceu!!!",
                Toast.LENGTH_LONG
            ).show()
            activeGame = 0
            try {
                val bd = SqlHelper(this).writableDatabase

                // val contentValues = ContentValues()
                // contentValues.put(TBL_USUARIO_LOGIN, edtLogin.text.toString())
                // contentValues.put(TBL_USUARIO_SENHA, edtSenha.text.toString())
                val contentValues = ContentValues().apply {
                    put(TBL_JOGO_WINNER, intent.getStringExtra("player$ganhador"))
                }

                bd.insert(
                    TBL_JOGO, null, contentValues
                )


                bd.close()
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }

        } else if (playsCount > 8 && ganhador == 4) {
            Toast.makeText(this, "Ops, ninguem ganhou.", Toast.LENGTH_LONG).show()
            activeGame = 0
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)


        }


    }

    fun reiniciar() {
        Toast.makeText(this, "Jogo Reiniciado.", Toast.LENGTH_LONG).show()
    }

    fun reStart(view: View) {
        reiniciar()
//        val buttonClicked = view as Button
//        when(buttonClicked.id) {
//            R.id.button10 -> {
//                playerAtivo = 4
//                val intent = Intent(this, MainScreen::class.java)
//
//
//                intent.putExtra("player1", intent.getStringExtra("player1"))
//                intent.putExtra("player1", intent.getStringExtra("player1"))
//                startActivity(intent)
//
//                finish()
//            }
//        }
        player1.clear()
        player2.clear()

        activeGame = 1
        playerAtivo = 1
        playsCount = 0
        ganhador = 4
        button.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        button.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        button.setBackgroundResource(android.R.drawable.btn_default)
        button2.setBackgroundResource(android.R.drawable.btn_default)
        button3.setBackgroundResource(android.R.drawable.btn_default)
        button4.setBackgroundResource(android.R.drawable.btn_default)
        button5.setBackgroundResource(android.R.drawable.btn_default)
        button6.setBackgroundResource(android.R.drawable.btn_default)
        button7.setBackgroundResource(android.R.drawable.btn_default)
        button8.setBackgroundResource(android.R.drawable.btn_default)
        button9.setBackgroundResource(android.R.drawable.btn_default)
    }
    fun marcar(view: View){
        val buttonClicked = view as Button
        var idCell = 0

        when(buttonClicked.id){
            R.id.button -> idCell = 1
            R.id.button2 -> idCell = 2
            R.id.button3 -> idCell = 3
            R.id.button4 -> idCell = 4
            R.id.button5 -> idCell = 5
            R.id.button6 -> idCell = 6
            R.id.button7 -> idCell = 7
            R.id.button8 -> idCell = 8
            R.id.button9 -> idCell = 9

        }
        //Toast.makeText(this, ("Id da celula: " + idCell), Toast.LENGTH_LONG).show()
        jogar(idCell, buttonClicked)



    }



    fun sair(view: View){
        val buttonClicked = view as Button
        when(buttonClicked.id){
            R.id.button11 -> {
                val intent = Intent(this, MainScreen::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
        fun jogar(idCell: Int, buttonClicked: Button) {
            if (activeGame != 0) {
                playsCount += 1
            }

            if (activeGame == 0) {
                Toast.makeText(
                    this,
                    "Jogo Finalizado: " + intent.getStringExtra("player$ganhador") + " ganhou !\n Reinicie!",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                if (playerAtivo == 1) {
                    buttonClicked.text = "X"
                    player1.add(idCell)
                    playerAtivo = 2
                    verificarGanhador()
                    buttonClicked.isEnabled = false


                } else if (playerAtivo == 2) {

                    buttonClicked.text = "O"
                    player2.add(idCell)
                    playerAtivo = 1
                    verificarGanhador()
                    buttonClicked.isEnabled = false


                }
//            else if(playerAtivo==2 && playsCount == 9 && ganhador == 4){
//                activeGame = 0
//                ganhador = -1
//
//            }
            }
            if (playerAtivo == 1) {
                var turn =
                    "vez do  " + intent.getStringExtra("player1") + "\n Jogadas Realizadas: " + playsCount
                textView.text = turn

            } else if (playerAtivo == 2) {
                var turn =
                    "vez do  " + intent.getStringExtra("player2") + "\n Jogadas Realizadas: " + playsCount
                textView.text = turn

            }

        }


    }

