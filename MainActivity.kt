package com.example.testeaplication

import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        pesoTxt?.doAfterTextChanged { text ->

        }

        alturaTxt?.doOnTextChanged { text, _, _,_  ->
        }

        btnCalcular.setOnClickListener {
            calcularIMC(pesoTxt.text.toString(), alturaTxt.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        val dec = DecimalFormat("#.00")
        if ( peso != null && altura != null){
            val imc = peso/ (altura * altura)

            if( imc < 18.5){
                tituloFrequencia.text = "O seu IMC é: "+ dec.format(imc) + "\n Classificando: Magreza"
                tituloFrequencia.setTextColor(Color.BLUE)
            } else if (imc >= 18.5 && imc < 24.9){
                tituloFrequencia.text = "O seu IMC é: " + dec.format(imc) + "\n Classificando: Saudável"
                tituloFrequencia.setTextColor(Color.GREEN)
            } else if (imc >= 25.0 && imc < 29.9){
                tituloFrequencia.text = "O seu IMC é: "+ dec.format(imc) + "\n Classificando: Sobrepeso"
                tituloFrequencia.setTextColor(Color.MAGENTA)
            } else if (imc >= 30.0 && imc < 34.9){
                tituloFrequencia.text = "O seu IMC é: "+ dec.format(imc) + "\n Classficando: Obesidade Grau I"
                tituloFrequencia.setTextColor(Color.GRAY)
            }else if (imc >= 35.0 && imc < 39.9){
                tituloFrequencia.text = "O seu IMC é: "+ dec.format(imc) +"\n Classficando: Obesidade Severa II"
                tituloFrequencia.setTextColor(Color.LTGRAY)
            }else {
                tituloFrequencia.text = "O seu IMC é: "+ dec.format(imc) + "\n Classficando: Obesidade Mórbida III"
                tituloFrequencia.setTextColor(Color.RED)
            }
        } else{
            tituloFrequencia.text = "Oops. Dado Inválido para o cálculo. \n Tente um valor válido!"
        }
    }
}
