package com.example.sergio.calculadorasergio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var acumulado : Double = 0.0
    var progresivo : Double = 0.0
    var memoria = 0
    var resultado : Double = 0.0
    var operador : String = ""
    var resultadoHex : String = ""
    var totalHex = 0
    //var valorHex : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  botonA.setOnClickListener{
            valorHex = java.lang.Long.parseLong(pantalla.text.toString(), 16)
        }
        botonB.setOnClickListener{
            valorHex = java.lang.Long.parseLong(pantalla.text.toString(), 16)
        }

        botonC.setOnClickListener{
            valorHex = java.lang.Long.parseLong(pantalla.text.toString(), 16)
        }
        botonD.setOnClickListener{
            valorHex = java.lang.Long.parseLong(pantalla.text.toString(), 16)
        }
        botonE.setOnClickListener{
            valorHex = java.lang.Long.parseLong(pantalla.text.toString(), 16)
        }
        botonF.setOnClickListener{
            valorHex = java.lang.Long.parseLong(pantalla.text.toString(), 16)

        }*/

    }

    fun verValor(v : View){

        if (pantalla.text.equals("0")) {
            pantalla.text = ""
        }
        errores.text = ""

        when(v.id){

            R.id.boton0 -> {
                pantalla.text = pantalla.text.toString() + "0"
            }

            R.id.boton1 -> {
                pantalla.text = pantalla.text.toString() + "1"
            }

            R.id.boton2 -> {
                pantalla.text = pantalla.text.toString() + "2"
            }

            R.id.boton3 -> {
                pantalla.text = pantalla.text.toString() + "3"
            }

            R.id.boton4 -> {
                pantalla.text = pantalla.text.toString() + "4"
            }

            R.id.boton5 -> {
                pantalla.text = pantalla.text.toString() + "5"
            }

            R.id.boton6 -> {
                pantalla.text = pantalla.text.toString() + "6"
            }

            R.id.boton7 -> {
                pantalla.text = pantalla.text.toString() + "7"
            }

            R.id.boton8 -> {
                pantalla.text = pantalla.text.toString() + "8"
            }

            R.id.boton9 -> {
                pantalla.text = pantalla.text.toString() + "9"
            }

            R.id.botonA -> {
                pantalla.text = pantalla.text.toString() + "A"
            }

            R.id.botonB -> {
                pantalla.text = pantalla.text.toString() + "B"
            }

            R.id.botonC -> {
                pantalla.text = pantalla.text.toString() + "C"
            }

            R.id.botonD -> {
                pantalla.text = pantalla.text.toString() + "D"
            }

            R.id.botonE -> {
                pantalla.text = pantalla.text.toString() + "E"
            }

            R.id.botonF -> {
                pantalla.text = pantalla.text.toString() + "F"
            }

            R.id.botonPunto -> {
                pantalla.text = pantalla.text.toString() + "."
            }

            R.id.botonSumar -> {
                pantalla.text = pantalla.text.toString() + "+"
            }

            R.id.botonRestar -> {
                pantalla.text = pantalla.text.toString() + "-"
            }

            R.id.botonMultiplicar -> {
                pantalla.text = pantalla.text.toString() + "*"
            }

            R.id.botonDividir -> {
                pantalla.text = pantalla.text.toString() + "/"
            }
        }
    }

    fun operador(v : View){

        when(v.id){

            R.id.botonSumar -> {
                acumulado += pantalla.text.toString().toInt()
                pantalla.setText("")
                operador = "+"
            }

            R.id.botonRestar -> {
                acumulado += pantalla.text.toString().toInt()
                pantalla.setText("")
                operador = "-"
            }

            R.id.botonMultiplicar -> {
                acumulado = (acumulado+1) * pantalla.text.toString().toInt()
                pantalla.setText("")
                operador = "*"
            }

            R.id.botonDividir -> {
                acumulado = pantalla.text.toString().toDouble()
                pantalla.setText("")
                operador = "/"
            }
        }
    }

    fun operacion(v : View){

        progresivo = pantalla.text.toString().toDouble()

        if (operador.equals("+")){
            resultado = acumulado + progresivo
            pantalla.setText(resultado.toString())

        }else if (operador.equals("-")){
            resultado = acumulado - progresivo
            pantalla.setText(resultado.toString())

        }else if (operador.equals("*")){
            resultado = acumulado * progresivo
            pantalla.setText(resultado.toString())

        }else if (operador.equals("/")){
            if(progresivo.toString().equals("0.0")){
                errores.text="No se puede dividir entre 0"
            }
            else {
                resultado = acumulado / progresivo
                pantalla.setText(resultado.toString())
            }
        }
        acumulado = resultado;
    }

    fun operacionHex(v : View){

        when(operador){

            "+"->{
                totalHex = resultadoHex.toInt() + java.lang.Long.parseLong(pantalla.text.toString(), 16).toInt()
                pantalla.setText(java.lang.Integer.toHexString(totalHex))
            }

            "-"->{
                totalHex = resultadoHex.toInt() + java.lang.Long.parseLong(pantalla.text.toString(), 16).toInt()
                pantalla.setText(java.lang.Integer.toHexString(totalHex))
            }

            "*"->{
                totalHex = resultadoHex.toInt() + java.lang.Long.parseLong(pantalla.text.toString(), 16).toInt()
                pantalla.setText(java.lang.Integer.toHexString(totalHex))
            }

            "/"->{
                totalHex = resultadoHex.toInt() + java.lang.Long.parseLong(pantalla.text.toString(), 16).toInt()
                pantalla.setText(java.lang.Integer.toHexString(totalHex))
            }
        }
    }

    fun operadorHex(v : View){

        when(v.id){

            R.id.botonSumar -> {
                resultadoHex = java.lang.Long.parseLong(pantalla.text.toString(), 16).toString()
                pantalla.text = ""
                operador = "+"
            }

            R.id.botonRestar -> {
                resultadoHex = java.lang.Long.parseLong(pantalla.text.toString(), 16).toString()
                pantalla.text = ""
                operador = "-"
            }

            R.id.botonMultiplicar -> {
                resultadoHex = java.lang.Long.parseLong(pantalla.text.toString(), 16).toString()
                pantalla.setText("")
                operador = "*"
            }

            R.id.botonDividir -> {
                resultadoHex = java.lang.Long.parseLong(pantalla.text.toString(), 16).toString()
                pantalla.setText("")
                operador = "/"
            }
        }
    }

    fun borrarPantalla(v : View){
        pantalla.text = "0"
        acumulado = 0.0
        progresivo = 0.0
    }

    fun borrar(v : View){
        val string = pantalla.text.toString()
        if(string.isNotEmpty()){
            pantalla.text = string.substring(0,string.length-1)
        }
    }

    fun borrarMemoria(v : View){
        memoria = 0
    }

    fun agregarMemoria(v : View){
        if (pantalla.text.equals(resultado.toString())){
            memoria += resultado.toInt()
        }else{
            memoria += pantalla.text.toString().toInt()
        }
    }

    fun verMemoria(v : View){
        pantalla.text = memoria.toString()
    }

    fun agregarMemoriaHex(v : View){
        if (pantalla.text.equals(resultadoHex)){
            memoria += java.lang.Long.parseLong(resultadoHex, 16).toInt()
        }else{
            memoria += java.lang.Long.parseLong(pantalla.text.toString(), 16).toInt()
        }
    }

    fun verMemoriaHex(v : View){
        pantalla.text = java.lang.Long.parseLong(memoria.toString(), 16).toString()
    }

}

