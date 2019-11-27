package com.example.jogodavelha

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_activity)


        btnCadastro.setOnClickListener {
            val bd = SqlHelper(this).writableDatabase

            val contentValues = ContentValues().apply {
                put(TBL_USUARIO_LOGIN, etName.text.toString())
                put(TBL_USUARIO_SENHA, etPass.text.toString())
            }

            val id = bd.insert(
                TBL_USUARIO, null, contentValues
            )
            val contentValues2 = ContentValues().apply {
                put(TBL_USUARIO_IDU, id)
                put(TBL_USUARIO_JOGO_COUNT, 3)

            }
            bd.insert(
                TBL_USUARIO_JOGO, null, contentValues2
            )

            if (id != -1L) {
                Toast.makeText(
                    this, "Usuário inserido com sucesso! \n ID: $id", Toast.LENGTH_LONG
                ).show()
            }

            bd.close()
        }
        btnLogin.setOnClickListener {
            var credit: Int = 0
            var credit_down: Int = 0
            var id: String? = ""
            //DBCON
            val bd = SqlHelper(this).writableDatabase
            //STATEMENT
            val sql =
                "SELECT * FROM $TBL_USUARIO JOIN $TBL_USUARIO_JOGO ON $TBL_USUARIO" + ".$TBL_USUARIO_ID = $TBL_USUARIO_JOGO" + ". $TBL_USUARIO_IDU WHERE $TBL_USUARIO" + ".$TBL_USUARIO_LOGIN = ? AND $TBL_USUARIO" + ".$TBL_USUARIO_SENHA = ?"
            //RESULTSET
            val cursor = bd.rawQuery(sql, arrayOf(etName.text.toString(), etPass.text.toString()))

            if (cursor.moveToFirst()) {

                id = cursor.getString(cursor.getColumnIndex(TBL_USUARIO_ID))
                credit = (cursor.getInt(cursor.getColumnIndex(TBL_USUARIO_JOGO_COUNT)))
                credit_down = (credit-1)
                Toast.makeText(this,"Credits left: " + credit_down
                , Toast.LENGTH_LONG
                ).show()
                if (credit < 1) {
                    Toast.makeText(
                        this,
                        "Numero de jogadas excedidas. Compre ja nossa aplicação",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(this, PaymentActivity::class.java)
                    intent.putExtra("id_user", id.toString())
                    startActivity(intent)
                } else {

                    val contentValues = ContentValues().apply {
                        put(TBL_USUARIO_JOGO_COUNT, credit_down)
                    }
                    bd.update(
                        TBL_USUARIO_JOGO, contentValues, "$TBL_USUARIO_IDU = ?", arrayOf(id)
                    )

                    val intent = Intent(this, MainScreen::class.java)
                    intent.putExtra("jogador",cursor.getString(cursor.getColumnIndex(TBL_USUARIO_LOGIN)))
                    intent.putExtra("jogadorid",cursor.getInt(cursor.getColumnIndex(TBL_USUARIO_ID)))
                    cursor.close()


                    startActivity(intent)

                    bd.close()
                    finish()
                }



            }

        }


    }


}


