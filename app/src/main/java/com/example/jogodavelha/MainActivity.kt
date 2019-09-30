package com.example.jogodavelha

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    var playerAtivo = 1
    var activeGame = 1
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
    fun reStart(view: View){
        reiniciar()
        val buttonClicked = view as Button
        when(buttonClicked.id) {
            R.id.button10 -> {
                playerAtivo = 4
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
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
    var ganhador = 4
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var playsCount = 0

    private fun reiniciar(){
        Toast.makeText(this, "Jogo Reiniciado.", Toast.LENGTH_LONG).show()
    }

    private fun jogar(idCell: Int, buttonClicked: Button) {
        if(activeGame != 0){
            playsCount += 1
        }

        if(activeGame == 0){
           Toast.makeText(this, "Jogo Finalizado: Jogador " + ganhador + " ganhou !\n Reinicie!", Toast.LENGTH_LONG).show()

        }else{

            if (playerAtivo == 1) {
                buttonClicked.text = "X"
                player1.add(idCell)
                playerAtivo = 2
                verificarGanhador()
                buttonClicked.isEnabled = false


            }else if(playerAtivo == 2){

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
        if(playerAtivo == 1){
            var turn = "vez do  "+intent.getStringExtra("player1")+"\n Jogadas Realizadas: "+playsCount
            textView.text=turn

        }else if(playerAtivo == 2){
            var turn = "vez do  "+intent.getStringExtra("player2")+"\n Jogadas Realizadas: "+playsCount
            textView.text=turn

        }

        }





    private fun verificarGanhador(){

        //Linhas 123
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))//jogador 1
        {   ganhador = 1
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        activeGame = 0
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)}
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))//jogador 2
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
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))//jogador 1
        {

            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))//jogador 2
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
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))//jogador 2
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
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button2.setBackgroundColor(Color.TRANSPARENT)
            button3.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))//jogador 2
        {
            activeGame = 0
            ganhador = 2
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button6.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
            button9.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))//jogador 1
        {
            activeGame = 0
            ganhador = 1
            button.setBackgroundColor(Color.TRANSPARENT)
            button2.setBackgroundColor(Color.TRANSPARENT)
            button4.setBackgroundColor(Color.TRANSPARENT)
            button5.setBackgroundColor(Color.TRANSPARENT)
            button7.setBackgroundColor(Color.TRANSPARENT)
            button8.setBackgroundColor(Color.TRANSPARENT)
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))//jogador 2
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
        if(ganhador == 1){
            Toast.makeText(this, "Parabens, Player" + intent.getStringExtra('player1') + ". Você venceu!!!", Toast.LENGTH_LONG).show()
            activeGame = 0

        }else if(ganhador == 2){
            Toast.makeText(this, "Parabens, " + intent.getStringExtra('player2') + ". Você venceu!!!", Toast.LENGTH_LONG).show()
            activeGame = 0

        }else if(playsCount > 8 && ganhador == 4){
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


}
