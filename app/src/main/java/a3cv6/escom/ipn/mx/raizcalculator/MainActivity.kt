package a3cv6.escom.ipn.mx.raizcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var eta : EditText
    private lateinit var etb : EditText
    private lateinit var etc : EditText
    private lateinit var x1 : TextView
    private lateinit var x2 : TextView
    private lateinit var statuslbl : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eta = findViewById<EditText>(R.id.aInput)
        etb = findViewById<EditText>(R.id.bInput)
        etc = findViewById<EditText>(R.id.cInput)
        x1  = findViewById<TextView>(R.id.x1Output)
        x2  = findViewById<TextView>(R.id.x2Output)
        statuslbl  = findViewById<TextView>(R.id.statuslbl)
    }

    fun onClickButton(view: View?) {

        var a: Double? = eta.text.toString().toDoubleOrNull()
        var b: Double? = etb.text.toString().toDoubleOrNull()
        var c: Double? = etc.text.toString().toDoubleOrNull()

        if(a==null) a=0.0
        if(b==null) b=0.0
        if(c==null) c=0.0

        var motor = MathMotor()
        var data : DoubleArray = motor.raiz(a,b,c)

        if( data[0]==0.0 ){
            statuslbl.text = "La recta cruza el eje X en x1"
            x1.text = "x1:= " + data[1]
            x2.text = ""

        } else if( data[0]==1.0 )   {
            statuslbl.text = "Func. Cuadratica con Raices Imaginarias"
            x1.text = "x1:= NaN"
            x2.text = "x2:= NaN"

        } else if( data[0]==2.0 ) {
            statuslbl.text = "Func. Cuadratica con Raices Distintas"
            x1.text = "x1:= " + data[1]
            x2.text = "x2:= " + data[2]

        } else if( data[0]==3.0 ) {
            statuslbl.text = "Func. Cuadratica con Raices Iguales"
            x1.text = "x1:= " + data[1]
            x2.text = ""

        } else
            statuslbl.text = "Error: Datos Invalidos"

    }

}
