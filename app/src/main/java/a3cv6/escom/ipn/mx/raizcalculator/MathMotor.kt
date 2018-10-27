package a3cv6.escom.ipn.mx.raizcalculator

class MathMotor{

    external fun add(a : Int, b: Int): Int
    external fun raiz(a:Double,b:Double,c:Double): DoubleArray

    companion object {

        init {
            System.loadLibrary("native-lib")
        }
    }

}