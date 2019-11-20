package com.example.jogodavelha

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_sql.*

class SqlActivity : AppCompatActivity() {

    private val sqlHelper = SqlHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql)

        btnSair.setOnClickListener {
            finish()
        }
    }

    fun incluir(view: View) {
        val bd = sqlHelper.writableDatabase

        // val contentValues = ContentValues()
        // contentValues.put(TBL_USUARIO_LOGIN, edtLogin.text.toString())
        // contentValues.put(TBL_USUARIO_SENHA, edtSenha.text.toString())
        val contentValues = ContentValues().apply {
            put(TBL_USUARIO_LOGIN, edtLogin.text.toString())
            put(TBL_USUARIO_SENHA, edtSenha.text.toString())
        }

        val id = bd.insert(
            TBL_USUARIO, null, contentValues
        )
        val contentValues2 = ContentValues().apply {
            put(TBL_USUARIO_IDU, id)
            put(TBL_USUARIO_JOGO_COUNT, 0)

        }
        val id2 = bd.insert(
            TBL_USUARIO_JOGO, null, contentValues2
        )

        if (id != -1L) {
            Toast.makeText(
                this, "Usuário inserido com sucesso! \n ID: $id", Toast.LENGTH_LONG
            ).show()
        }

        bd.close()
    }
    fun incluir2(view: View) {
        val bd = sqlHelper.writableDatabase

        // val contentValues = ContentValues()
        // contentValues.put(TBL_USUARIO_LOGIN, edtLogin.text.toString())
        // contentValues.put(TBL_USUARIO_SENHA, edtSenha.text.toString())
        val contentValues = ContentValues().apply {
            put(TBL_USUARIO_JOGO_COUNT, edtPlays.text.toString().toInt()+1)

        }

        val id = bd.insert(
            TBL_USUARIO_JOGO, null, contentValues
        )

        if (id != -1L) {
            Toast.makeText(
                this, "Usuário inserido com sucesso! \n ID: $id", Toast.LENGTH_LONG
            ).show()
        }

        bd.close()
    }
    fun ler(view: View) {
        var plays:Int = 0

        val bd = sqlHelper.writableDatabase
        val sql = "SELECT * FROM $TBL_USUARIO JOIN $TBL_USUARIO_JOGO ON $TBL_USUARIO"+".$TBL_USUARIO_ID = $TBL_USUARIO_JOGO"+". $TBL_USUARIO_IDU WHERE $TBL_USUARIO"+".$TBL_USUARIO_LOGIN = ? AND $TBL_USUARIO"+".$TBL_USUARIO_SENHA = ?"
        val cursor = bd.rawQuery(sql, arrayOf(edtLogin.text.toString(),edtSenha.text.toString()))

        if (cursor.moveToNext()) {
            edtLogin.setText(
                cursor.getString(
                    cursor.getColumnIndex(TBL_USUARIO_LOGIN)
                )
            )

            edtSenha.setText(
                cursor.getString(
                    cursor.getColumnIndex(TBL_USUARIO_SENHA)
                )
            )
            edtPlays.setText(
                cursor.getString(
                    cursor.getColumnIndex(TBL_USUARIO_JOGO_COUNT)
                )

            )

        }
        plays =  (cursor.getInt(cursor.getColumnIndex(TBL_USUARIO_JOGO_COUNT))+1)
        if(plays == 4){
            Toast.makeText(this, "Numero de jogadas excedidas. Compre ja nossa aplicação", Toast.LENGTH_LONG).show()
        }else{

            val contentValues = ContentValues().apply {
                put(TBL_USUARIO_JOGO_COUNT, plays)

            }


            bd.update(
                TBL_USUARIO_JOGO, contentValues, "$TBL_USUARIO_IDU = ?", arrayOf(edtId.text.toString())
            )
        }



        cursor.close()
        bd.close()
    }

    fun atualizar(view: View) {
        val bd = sqlHelper.writableDatabase
        val sql = "SELECT * FROM $TBL_USUARIO JOIN $TBL_USUARIO_JOGO ON $TBL_USUARIO"+".$TBL_USUARIO_ID = $TBL_USUARIO_JOGO"+". $TBL_USUARIO_IDU WHERE $TBL_USUARIO"+".$TBL_USUARIO_ID = ?"
        val cursor = bd.rawQuery(sql, arrayOf(edtId.text.toString()))
        val contentValues = ContentValues().apply {
            put(TBL_USUARIO_LOGIN, edtLogin.text.toString())
            put(TBL_USUARIO_SENHA, edtSenha.text.toString())

        }


        bd.update(
            TBL_USUARIO, contentValues, "$TBL_USUARIO_ID = ?", arrayOf(edtId.text.toString())
        )

        bd.close()
    }

    fun excluir(view: View) {
        val bd = sqlHelper.writableDatabase

        bd.delete(
            TBL_USUARIO, "$TBL_USUARIO_ID = ?", arrayOf(edtId.text.toString())
        )

        bd.close()
    }

    fun lerTudo(view: View) {
        val bd = sqlHelper.writableDatabase
        val sql = "SELECT * FROM $TBL_USUARIO ORDER BY $TBL_USUARIO_LOGIN"
        val cursor = bd.rawQuery(sql, null)

        var usuarios = ""

        while (cursor.moveToNext()) {
            var id =
                cursor.getString(
                    cursor.getColumnIndex(TBL_USUARIO_ID)
                )
            var login =
                cursor.getString(
                    cursor.getColumnIndex(TBL_USUARIO_LOGIN)
                )
            var senha =
                cursor.getString(
                    cursor.getColumnIndex(TBL_USUARIO_SENHA)
                )

            usuarios += "$id - $login - $senha \n"
        }

        txtUsuarios.text = usuarios

        cursor.close()
        bd.close()
    }

}


