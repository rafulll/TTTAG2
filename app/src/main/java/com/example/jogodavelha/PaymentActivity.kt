package com.example.jogodavelha

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_payment.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import android.os.StrictMode
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.login_activity.*


class PaymentActivity : AppCompatActivity() {
    private val sqlHelper = SqlHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        button12.setOnClickListener {

            var reqParam = URLEncoder.encode("numero_cartao", "UTF-8") + "=" + URLEncoder.encode(editText4.text.toString(), "UTF-8")
            reqParam += "&" + URLEncoder.encode("nome_cliente", "UTF-8") + "=" + URLEncoder.encode(editText5.text.toString(), "UTF-8")
            reqParam += "&" + URLEncoder.encode("cod_seguranca", "UTF-8") + "=" + URLEncoder.encode(editText6.text.toString(), "UTF-8")
            reqParam += "&" + URLEncoder.encode("parcelas", "UTF-8") + "=" + URLEncoder.encode(editText7.text.toString(), "UTF-8")
            reqParam += "&" + URLEncoder.encode("valor_em_centavos", "UTF-8") + "=" + URLEncoder.encode(1000.toString(), "UTF-8")
            val mURL = URL("https://ws-branks.herokuapp.com/v1/pay")
            var cartao = editText4.text.toString()
            var cliente = editText5.text.toString()
            var cod = editText6.text.toString()
            var parc = editText7.text.toString()

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(outputStream)
                wr.write(reqParam)

                wr.flush()
                println("cartao : $cartao")
                println("cliente : $cliente")
                println("cod segur : $cod")
                println("parcelas : $parc")

                println("URL : $url")
                println("Response Code : $responseCode")
                if(responseCode.equals(200)){
                    val bd = sqlHelper.writableDatabase


                    var id = intent.getStringExtra("id_user")


                        val contentValues = ContentValues().apply {
                            put(TBL_USUARIO_JOGO_COUNT,20)
                        }
                        bd.update(
                            TBL_USUARIO_JOGO, contentValues, "$TBL_USUARIO_IDU = ?", arrayOf(id)
                        )
                        BufferedReader(InputStreamReader(inputStream)).use {
                            val response = StringBuffer()

                            var inputLine = it.readLine()
                            while (inputLine != null) {
                                response.append(inputLine)
                                inputLine = it.readLine()
                            }
                            it.close()
                            textView3.text = ("OK: $responseCode \nResponse : $response")
                        }


                }else if(responseCode.equals(503)){
                    textView3.text = ("Error: $responseCode \nTempo de Solicitação expirou. Tente novamente.")

                }else if(responseCode.equals(401)){
                    textView3.text = ("Error: $responseCode \nVerifique atenciosamente seus dados e tente novamente.")

                }else{
                    textView3.text = ("Error: $responseCode \nVerifique atenciosamente seus dados e tente novamente.")

                }



            }
        }
    }

}
