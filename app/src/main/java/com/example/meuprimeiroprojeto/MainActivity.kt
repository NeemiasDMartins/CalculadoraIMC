package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnCalcular: Button = findViewById(R.id.BtnCalcular)
        val edtPeso : EditText = findViewById(R.id.edttext_peso)
        val edtTextAltura: EditText = findViewById(R.id.edttext_altura)


        BtnCalcular.setOnClickListener {

            val alturaStr = edtTextAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

            val altura : Float = edtTextAltura.text.toString().toFloat()
            val peso: Float = edtPeso.text.toString().toFloat()


            val alturaFinal: Float = altura * altura
            val result: Float = peso / alturaFinal


            val Intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)

                }
            startActivity(Intent)
            }else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }

    }
}