package mx.edu.itson.asignacion04_00000148520

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.etPeso) as EditText
        val estatura: EditText = findViewById(R.id.etEstatura) as EditText
        val calcImc: Button = findViewById(R.id.btnCalcular) as Button
        val imc: TextView = findViewById(R.id.tvImc) as TextView
        val rango: TextView = findViewById(R.id.tvRango) as TextView

        calcImc.setOnClickListener {
            val imcPeso = peso.text.toString().toDouble()
            val imcEstatura = estatura.text.toString().toDouble()
            val imcCalcular = imcPeso / (imcEstatura * imcEstatura)

            if (imcCalcular < 18.5) {
                rango.setText("Bajo Peso")
                rango.setBackgroundResource(R.color.greenish)
            } else if (imcCalcular >= 18.5 && imcCalcular < 25.0) {
                rango.setText("Normal")
                rango.setBackgroundResource(R.color.green)
            } else if (imcCalcular >= 25.0 && imcCalcular < 30.0) {
                rango.setText("Sobrepeso")
                rango.setBackgroundResource(R.color.brown)
            } else if (imcCalcular >= 30.0 && imcCalcular < 35.0) {
                rango.setText("Obesidad grado 1")
                rango.setBackgroundResource(R.color.yellow)
            } else if (imcCalcular >= 35.0 && imcCalcular < 40.0) {
                rango.setText("Obesisdad grado 2")
                rango.setBackgroundResource(R.color.orange)
            } else {
                rango.setText("Obesidad grado 3")
                rango.setBackgroundResource(R.color.red)
            }
            imc.text = imcCalcular.toString()
        }
    }
}