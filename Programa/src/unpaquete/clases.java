//esta carpeta es un paquete, cuando se importe se importaran todas las clases de todos los arcihvos de dentro
package unpaquete;//este es el nombre del paquete, convirtiendo este archivo en el principal


class Objeto {//creando una clase que identifica un tipo de variable, solo se puede hacer una clase publica por archivo y tiene que llamarse igual que el archivo (se crea un .class por cada clase utilizada)
    private int edad;//una propiedad privada de la clase (solo se puede modificar desde dentro) (se suelen usar funciones set y get)
    String nombre;//igual pero se puede usar desde fuera
    public void Reportar(){//una funcin que hace la clase, actua sobre sus propiedades como objeto y puede acceder a propiedades privadas
        System.out.println(nombre); System.out.println(edad);
    }
    public static void Decir(){//una funcion que puede ser llamada sin hacer una variable de la clase (Objeto.Decir();)
        System.out.println("esto viene de una clase");
    }
    public void setEdad(int edad){//metodos getter y setter para propiedades privadas
        this.edad = edad;//usando this. se hace referencia al de la clase y no al parametro de la funcion
    }

    public Objeto(){//metodo constructor para especificar el estado inicial de las propiedades
        edad = 0;
        nombre = "n";
    }
}
class OtroObjeto{
    int tamagno;
    String nombre;
    public OtroObjeto(int _tamagno, String _nombre){//poniendo parametros en el constructor se hace que al estanciar la clase se necesiten valores
        tamagno = _tamagno;//tambien se podria usar el this.x
        nombre = _nombre;
    }
}


public class clases {//clase principal del paquete (el orden de declaracion de las clases no importa)
    void inicial(){
        Objeto obj = new Objeto();//declarar una variable para ese objeto
        obj.nombre = "aa";//acceder a las propiedades del objeto
        obj.Reportar();//ejecutar un metodo/funcion del objeto
        OtroObjeto obj2 = new OtroObjeto(3, "asdf");//creando una instancia de un contstructor con parametros
        
    }
}