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
    static int variableComun = 2;//esta variable se puede llamar directamente desde la clase, y las instancias no generan una copia de esta
    public static void funcionComun(){//esta funcion se la puede llamar directamente desde la clase, no deberia modificar variables no estaticas ya que no se usa una instancia
        System.out.println("siempre");
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
    public OtroObjeto(String _nombre){//sobrecarga de constructor, se puede instanciar esta clase usando tambien estos parametros
        this(0, _nombre);//se puede usar la funcion this() que llama al constructor principal (o al que coincidan los parametros)
        //nombre = _nombre;
        //tamagno = 0;
    }
}

class ClaseMas{
    int tamagno;
    public void reportar(){
        System.out.println("tiene " + tamagno + "tamagno");
    }
    public ClaseMas(int _tamagno) {
        tamagno = _tamagno;
    }
}
class ClaseMenos extends ClaseMas{//esta clase tendra todas las propiedades y metodos de ClaseMas mas las suyas (la herencia multiple no funciona)
    String nombre;//ademas te esto, tambientendria int tamagno
    public void reportar(){//si tiene una funcion que se llama igual que una en la clase padre, se hace caso a la nueva (polimorfismo)
        super.reportar();//usando super se hace referencia a la clase padre, usandolo para llamar a la funcion de la clase padre
        System.out.println("tiene " + tamagno + "tamagno y nombre " + nombre);
    }
    public ClaseMenos(String _nombre, int _tamagno){//recoge sus propiedades y las de su clase padre
        super(_tamagno);//llama al constructor de la clase padre
        nombre = _nombre;//poniendo tambien las propiedades exclusivas de la clase
    }
}


public class clases {//clase principal del paquete (el orden de declaracion de las clases no importa)
    public static void inicial(){
        Objeto obj = new Objeto();//declarar una variable para ese objeto
        obj.nombre = "aa";//acceder a las propiedades del objeto
        obj.Reportar();//ejecutar un metodo/funcion del objeto
        OtroObjeto obj2 = new OtroObjeto(3, "asdf");//creando una instancia de un contstructor con parametros
        OtroObjeto obj3 = new OtroObjeto("nombre");//usando el otro constructor
    }
}