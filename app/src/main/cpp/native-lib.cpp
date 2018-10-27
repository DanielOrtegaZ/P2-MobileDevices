#include <jni.h>
#include <math.h>

extern "C"
JNIEXPORT jdoubleArray JNICALL
Java_a3cv6_escom_ipn_mx_raizcalculator_MathMotor_raiz(JNIEnv* env, jobject pThis, jdouble a, jdouble b, jdouble c){

    double data[3];
    double aux;
    jdoubleArray resp = env->NewDoubleArray(3);

    data[0] = 0;
    data[1] = 0;
    data[2] = 0;

    if(a==0.0 && b!=0.0){ // Recta Valida
        data[0]=0;
        data[1]=-c/b;

    } else if(a!=0.0){ // Funcion Cuadrática

        aux = b*b-4*a*c;

        if(aux<0){ // Raices Imaginarias
            data[0]=1;

        } else if(aux!=0){  // x1 != x2
            data[0]=2;
            data[1] = (-b+sqrt(aux))/(2*a);
            data[2] = (-b-sqrt(aux))/(2*a);

        } else {            // x1 = x2
            data[0]=3;
            data[1] = (-b+sqrt(aux))/(2*a);
        }

    } else // Entrada Invalida
        data[0]=-1;

    env->SetDoubleArrayRegion(resp,0,3,data);
    return resp;
}