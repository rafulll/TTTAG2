package com.example.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var playerAtivo = 1
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
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun reiniciar(){
        button.text = ""
        button.setBackgroundColor(Color.LTGRAY)
        button2.text = ""
        button2.setBackgroundColor(Color.LTGRAY)
        button3.text = ""
        button3.setBackgroundColor(Color.LTGRAY)
        button4.text = ""
        button4.setBackgroundColor(Color.LTGRAY)
        button5.text = ""
        button5.setBackgroundColor(Color.LTGRAY)
        button6.text = ""
        button6.setBackgroundColor(Color.LTGRAY)
        button7.text = ""
        button7.setBackgroundColor(Color.LTGRAY)
        button8.text = ""
        button8.setBackgroundColor(Color.LTGRAY)
        button9.text = ""
        button9.setBackgroundColor(Color.LTGRAY)



        player1.clear()
        player2.clear()


    }
    var countPlays = 0
    private fun jogar(idCell: Int, buttonClicked: Button) {

        textView.text="vez do jogadpr  "+playerAtivo

            if (playerAtivo == 1) {
                buttonClicked.text = "X"
                buttonClicked.setBackgroundColor(Color.GRAY)
                player1.add(idCell)
                verificarGanhador()
                playerAtivo = 2

            }else{
                buttonClicked.text = "O"
                buttonClicked.setBackgroundColor(Color.GREEN)
                player2.add(idCell)
                verificarGanhador()
                playerAtivo = 1


            }


        buttonClicked.isEnabled = false

        }





    private fun verificarGanhador(){
        var ganhador = -1
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

        }else if(ganhador == 2){
            Toast.makeText(this, "Parabens, jogador" + ganhador + ". Você venceu!!!", Toast.LENGTH_LONG).show()

        }else{

        }


    }


}
