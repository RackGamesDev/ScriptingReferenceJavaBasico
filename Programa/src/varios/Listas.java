package varios;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> listaString = new ArrayList<String>();//crear una lista de x clase (array dinamico) (por defecto tiene 0 posiciones)
        listaString.add("cero"); listaString.add("uno");//agnadir una posicion al final con x valor
        int numero1 = listaString.size();//es como el .length()
        String sacar = listaString.get(1);//devuelve el contenido de una posicion
        listaString.set(0, "asdf");//cambiar una posicion
        for(String texto:listaString){//foreach para las listas
            System.out.println(texto);
        }
        listaString.remove(0);//elimina una posicion y reduce 1 las que estan adelante
        listaString.addFirst("asd");//agnade una posicion al principio, desplazando el resto
        listaString.addLast("asdfasf");//similar al .add() lo agnade al final
        boolean siono = listaString.contains("uno");//devuelve true si hay una posicion con ese valor
        listaString.clear();//elimina todas las posiciones
    }
}
