package com.example.jogodavelha

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text="vez do jogadpr  "+playerAtivo+"\n Jogadas Realizadas: "+playsCount

    }
    var playerAtivo = 1
    var activeGame = 1
    fun sair(view: View){
        val buttonClicked = view as Button
        when(buttonClicked.id){
            R.id.button11 -> {
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
    var ganhador = -1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var playsCount = 0

    private fun reiniciar(){
        Toast.makeText(this, "Jogo Reiniciado.", Toast.LENGTH_LONG).show()

        /*
        if(ganhador == 1){
            button.text = "W  I"
            button.setBackgroundColor(Color.LTGRAY)
            button.setTextColor(Color.BLUE)
            button2.text = "N  N"
            button2.setBackgroundColor(Color.LTGRAY)
            button3.text = "E  R"
            button3.setBackgroundColor(Color.LTGRAY)
            button4.text = "P  L"
            button4.setBackgroundColor(Color.LTGRAY)
            button5.text = "A  Y"
            button5.setBackgroundColor(Color.LTGRAY)
            button6.text = "E  R"
            button6.setBackgroundColor(Color.LTGRAY)
            button7.text = "O"
            button7.setBackgroundColor(Color.LTGRAY)
            button8.text = "N"
            button8.setBackgroundColor(Color.LTGRAY)
            button9.text = "E"
            button9.setBackgroundColor(Color.LTGRAY)
        }
        if(ganhador == 2){
            button.text = "W  I"
            button.setBackgroundColor(Color.LTGRAY)
            button2.text = "N  N"
            button2.setBackgroundColor(Color.LTGRAY)
            button3.text = "E  R"
            button3.setBackgroundColor(Color.LTGRAY)
            button4.text = "P  L"
            button4.setBackgroundColor(Color.LTGRAY)
            button5.text = "A  Y"
            button5.setBackgroundColor(Color.LTGRAY)
            button6.text = "E  R"
            button6.setBackgroundColor(Color.LTGRAY)
            button7.text = "T"
            button7.setBackgroundColor(Color.LTGRAY)
            button8.text = "W"
            button8.setBackgroundColor(Color.LTGRAY)
            button9.text = "O"
            button9.setBackgroundColor(Color.LTGRAY)

        }
*/






    }
    var countPlays = 0
    private fun jogar(idCell: Int, buttonClicked: Button) {


        if(activeGame == 0){
            if(ganhador == 4){

                Toast.makeText(this, "Jogo Finalizado:  Ninguem Ganhou!", Toast.LENGTH_LONG).show()

            }
           Toast.makeText(this, "Jogo Finalizado: Jogador " + ganhador + " ganhou !\n Reinicie!", Toast.LENGTH_LONG).show()

        }else{
            if(playerAtivo == 4){

            }
            if (playerAtivo == 1) {
                buttonClicked.text = "X"
                buttonClicked.setBackgroundColor(Color.GRAY)
                player1.add(idCell)
                playerAtivo = 2
                verificarGanhador()
                buttonClicked.isEnabled = false
                playsCount += 1
            }else{
                buttonClicked.text = "O"
                buttonClicked.setBackgroundColor(Color.GREEN)
                player2.add(idCell)
                playerAtivo = 1
                verificarGanhador()
                buttonClicked.isEnabled = false
                playsCount += 1

            }
        }
        textView.text="vez do jogadpr  "+playerAtivo+"\n Jogadas Realizadas: "+playsCount

        }





    private fun verificarGanhador(){

        //Linhas 123
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))//jogador 1
            ganhador = 1
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))//jogador 2
            ganhador = 2
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))//jogador 1
            ganhador = 1
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))//jogador 2
            ganhador = 2

        //Linhas 456
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))//jogador 1
            ganhador = 1
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))//jogador 2
            ganhador = 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))//jogador 1
            ganhador = 1
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))//jogador 2
            ganhador = 2
        //Linhas 789
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))//jogador 1
            ganhador = 1
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))//jogador 2
            ganhador = 2

        //Diagonais
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))//jogador 1
            ganhador = 1
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))//jogador 2
            ganhador = 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))//jogador 1
            ganhador = 1
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))//jogador 2
            ganhador = 2
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))//jogador 1
            ganhador = 1
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))//jogador 2
            ganhador = 2

        if(ganhador == 1){
            Toast.makeText(this, "Parabens, jogador" + ganhador + ". Você venceu!!!", Toast.LENGTH_LONG).show()
            activeGame = 0

        }else if(ganhador == 2){
            Toast.makeText(this, "Parabens, jogador" + ganhador + ". Você venceu!!!", Toast.LENGTH_LONG).show()
            activeGame = 0

        }else if(countPlays == 9 && ganhador == -1){
            Toast.makeText(this, "Ops, ninguem ganhou.", Toast.LENGTH_LONG).show()
            activeGame = 0
        }

    }


}
