//Esta carpeta es un paquete, cuando se importe se importaran todas las clases de todos los arcihvos de dentro
package unpaquete;//Este es el nombre del paquete, convirtiendo este archivo en el principal


class Objeto {//Creando una clase que identifica un tipo de variable, solo se puede hacer una clase publica por archivo y tiene que llamarse igual que el archivo (se crea un .class por cada clase utilizada)
    private int edad;//Una propiedad privada de la clase (solo se puede modificar desde dentro) (se suelen usar funciones set y get)
    String nombre;//Igual pero se puede usar desde fuera
    protected int otraPropiedad;//Esto solo sera accesible desde la clase y subclases
    public void Reportar(){//Una funcin que hace la clase, actua sobre sus propiedades como objeto y puede acceder a propiedades privadas
        System.out.println(nombre); System.out.println(edad);
    }
    public static void Decir(){//Una funcion que puede ser llamada sin hacer una variable de la clase (Objeto.Decir();)
        System.out.println("esto viene de una clase");
    }
    public void setEdad(int edad){//Metodos getter y setter para propiedades privadas
        this.edad = edad;//Usando this. se hace referencia al de la clase y no al parametro de la funcion
    }
    static int variableComun = 2;//Esta variable se puede llamar directamente desde la clase, y las instancias no generan una copia de esta
    public static void funcionComun(){//Esta funcion se la puede llamar directamente desde la clase, no deberia modificar variables no estaticas ya que no se usa una instancia
        System.out.println("siempre");
    }

    public Objeto(){//Metodo constructor para especificar el estado inicial de las propiedades
        edad = 0;
        nombre = "n";
    }
}
class OtroObjeto{
    int tamagno;
    String nombre;
    public OtroObjeto(int _tamagno, String _nombre){//Poniendo parametros en el constructor se hace que al estanciar la clase se necesiten valores
        tamagno = _tamagno;//Tambien se podria usar el this.x
        nombre = _nombre;
    }
    public OtroObjeto(String _nombre){//Sobrecarga de constructor, se puede instanciar esta clase usando tambien estos parametros
        this(0, _nombre);//Se puede usar la funcion this() que llama al constructor principal (o al que coincidan los parametros)
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
class ClaseMenos extends ClaseMas{//Esta clase tendra todas las propiedades y metodos de ClaseMas mas las suyas (la herencia multiple no funciona) (todas las clases derivan de Object)
    String nombre;//Ademas te esto, tambientendria int tamagno
    public void reportar(){//Si tiene una funcion que se llama igual que una en la clase padre, se hace caso a la nueva (polimorfismo)
        super.reportar();//Usando super se hace referencia a la clase padre, usandolo para llamar a la funcion de la clase padre
        System.out.println("tiene " + tamagno + "tamagno y nombre " + nombre);
    }
    public ClaseMenos(String _nombre, int _tamagno){//Recoge sus propiedades y las de su clase padre
        super(_tamagno);//Llama al constructor de la clase padre
        nombre = _nombre;//Poniendo tambien las propiedades exclusivas de la clase
    }
}
final class Inheredable{//Poniendo final class hace que ninguna clase pueda heredar de esta
    final void irrepetible(){}//Por otro lado, poniendo final void hace que no se  pueda sobreescribir esa funcion en clases heredadas (no polimorfismo)
    public Inheredable(){}
}


class ClaseFuera{
    private class ClaseDentro{//Esta clase esta dentro de otra (inner class), seria accesible solo desde su clase de fuera, pues cuenta como propiedad privada
        public void DecirD(){
            ClaseFuera obj = new ClaseFuera();//Accediendo a la clase de fuera
            obj.DecirF();
        }
    }
    public void DecirF(){
        ClaseDentro obj = new ClaseDentro();//Usando la innerclass
        obj.DecirD();//Accediendo como de normal, todo esto es solo posible desde aqui
    }
    public void Metodo(){
        class OtraClaseDentro{//Tambien se puede hacer una inner class dentro de una funcion, entonces solo se podra usar dentro de esa funcion
            String nombre;
            public OtraClaseDentro(String _nombre){
                nombre = _nombre;
            }
        }
        OtraClaseDentro obj = new OtraClaseDentro("a");

    }
}


abstract class Plantilla{//Las clases abstractas solo sirven para que otras clases hereden de estas, sirviendo como plantilla
    String nombre;
    public void reportarse(){//Esta funcion funcionaria como de normal
        System.out.println(nombre);
    }
    public abstract void reportarseDescripcion();//Esta funcion seria obligatorio sobreescribirla en subclases
}
class DePlantilla extends Plantilla{
    public void reportarseDescripcion(){//Sobreescribiendo obligatoriamente la funcion abstracta
        System.out.println(nombre + "asfdasd");
    }
    public DePlantilla(String _nombre){
        nombre = _nombre;
    }
}



public class Clases {//Clase principal del paquete (el orden de declaracion de las clases no importa)
    public static void main(String[] args) throws Exception {
        Objeto obj = new Objeto();//Declarar una variable para ese objeto
        obj.nombre = "aa";//Acceder a las propiedades del objeto
        obj.Reportar();//Ejecutar un metodo/funcion del objeto
        boolean siono = obj instanceof Objeto;//Devuelve true si es instancia de x clase o su clase hereda de esa clase

        ClaseMas objm = new ClaseMas(0);
        //ClaseMenos objmm = (ClaseMenos)objm;//Se puede transformar la clase padre en la clase hija con casting (se usan nulls)

        OtroObjeto obj2 = new OtroObjeto(3, "asdf");//Creando una instancia de un contstructor con parametros
        OtroObjeto obj3 = new OtroObjeto("nombre");//Usando el otro constructor

        Plantilla objmmm = new DePlantilla("asdf");//Creando un objeto de clase abstarcta desde un new con clase heredada de esta


        Objeto textoModificado = new Objeto(){//Crear unaclase anonima, es usar una clase pero hacerle modificaciones
            public void reportar(){//Las modificaciones
                super.Reportar();
                System.out.println("nuevo codigo");
            }
        };
    }
}
