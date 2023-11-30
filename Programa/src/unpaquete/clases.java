//esta carpeta es un paquete, cuando se importe se importaran todas las clases de todos los arcihvos de dentro
package unpaquete;//este es el nombre del paquete, convirtiendo este archivo en el principal


class Objeto {//creando una clase que identifica un tipo de variable, solo se puede hacer una clase publica por archivo y tiene que llamarse igual que el archivo
    private int edad;//una propiedad privada de la clase (solo se puede modificar desde dentro) (se suelen usar funciones set y get)
    String nombre;//igual pero se puede usar desde fuera
    public void Reportar(){//una funcin que hace la clase, actua sobre sus propiedades como objeto y puede acceder a propiedades privadas
        System.out.println(nombre); System.out.println(edad);
    }
    public static void Decir(){//una funcion que puede ser llamada sin hacer una variable de la clase (Objeto.Decir();)
        System.out.println("esto viene de una clase");
    }

    public Objeto(){//metodo constructor para especificar el estado inicial de las propiedades
        edad = 0;
        nombre = "n";
    }
}


public class clases {//clase principal del paquete (el orden de declaracion de las clases no importa)
    void inicial(){
        Objeto obj = new Objeto();//declarar una variable para ese objeto
        obj.nombre = "aa";//acceder a las propiedades del objeto
        obj.Reportar();//ejecutar un metodo/funcion del objeto
    }
}