package varios;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> listaString = new ArrayList<String>();//Crear una lista de x clase (array dinamico) (por defecto tiene 0 posiciones)
        listaString.add("cero"); listaString.add("uno");//Agnadir una posicion al final con x valor
        int numero1 = listaString.size();//Es como el .length()
        String sacar = listaString.get(1);//Devuelve el contenido de una posicion
        listaString.set(0, "asdf");//Cambiar una posicion
        for(String texto:listaString){//foreach para las listas
            System.out.println(texto);
        }
        listaString.remove(0);//Elimina una posicion y reduce 1 las que estan adelante
        listaString.addFirst("asd");//Agnade una posicion al principio, desplazando el resto
        listaString.addLast("asdfasf");//Similar al .add() lo agnade al final
        boolean siono = listaString.contains("uno");//Devuelve true si hay una posicion con ese valor
        listaString.clear();//Elimina todas las posiciones
    }
}
