package com.example.jogodavelha

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



class PaymentActivity : AppCompatActivity() {

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

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(outputStream)
                wr.write(reqParam)

                wr.flush()

                println("URL : $url")
                println("Response Code : $responseCode")

                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = StringBuffer()

                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    it.close()
                    textView3.text = ("Response : $response")
                }
            }
        }
    }

}
