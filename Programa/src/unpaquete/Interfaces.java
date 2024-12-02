//(Nada que ver con las interfaces graficas ni nada)
package unpaquete;

import java.util.*;

//Esta clase implementa una interfaz, es similar a heredar de una clase abstracta solo que se puede implementar varias interfaces y estas solo tienen constantes y metodos abstractos (entonces la clase debe cumplir x requisitos)
class ObjetoContable implements Comparable{//En este caso implementar de Comparable hace que se pueda tratar la clase como un dato primitivo, en base a una propiedad suya
    String nombre;
    int orden;
    public ObjetoContable(String _nombre, int _orden){
        nombre = _nombre;
        orden = _orden;
    }
    public int compareTo(Object miObjeto){//El requisito de Comparable es tener esta funcion sobreescrita, suele seguir esta estructura (return del -1 al 1)
        ObjetoContable otroObjeto = (ObjetoContable)miObjeto;
        if(this.orden<otroObjeto.orden){//Se usara la variable orden para comparar
            return -1;
        }
        else if(this.orden>otroObjeto.orden){
            return 1;
        }
        else{
            return 0;
        }
    }
}

interface Interfaz {//Se pueden crear interfaces personalizadas para implementarlas en clases (funciona similar a una clase abstracta)
    void ObligatorioCopiar();//Ppor defecto todo lo que haya dentro sera public abstract
}
class DeInterfaz implements Interfaz{
    public void ObligatorioCopiar(){}//Cumpliendo los requisitos de la interfaz
}


public class Interfaces {
    public static void main(String[] args) throws Exception {
        ObjetoContable[] objetosContables = new ObjetoContable[3];
        objetosContables[0] = new ObjetoContable("aa", 3);
        objetosContables[1] = new ObjetoContable("aa", 2);
        objetosContables[2] = new ObjetoContable("aa", 1);
        Arrays.sort(objetosContables);//En este caso lo estara ordenando y comparando con la variable orden
    }
}
