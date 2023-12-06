//esta carpeta es un paquete, cuando se importe se importaran todas las clases de todos los arcihvos de dentro
package unpaquete;//este es el nombre del paquete, convirtiendo este archivo en el principal


class Objeto {//creando una clase que identifica un tipo de variable, solo se puede hacer una clase publica por archivo y tiene que llamarse igual que el archivo (se crea un .class por cada clase utilizada)
    private int edad;//una propiedad privada de la clase (solo se puede modificar desde dentro) (se suelen usar funciones set y get)
    String nombre;//igual pero se puede usar desde fuera
    protected int otraPropiedad;//esto solo sera accesible desde la clase y subclases
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
class ClaseMenos extends ClaseMas{//esta clase tendra todas las propiedades y metodos de ClaseMas mas las suyas (la herencia multiple no funciona) (todas las clases derivan de Object)
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
final class Inheredable{//poniendo final class hace que ninguna clase pueda heredar de esta
    final void irrepetible(){}//por otro lado, poniendo final void hace que no se  pueda sobreescribir esa funcion en clases heredadas (no polimorfismo)
    public Inheredable(){}
}


class ClaseFuera{
    private class ClaseDentro{//esta clase esta dentro de otra (inner class), seria accesible solo desde su clase de fuera, pues cuenta como propiedad privada
        public void DecirD(){
            ClaseFuera obj = new ClaseFuera();//accediendo a la clase de fuera
            obj.DecirF();
        }
    }
    public void DecirF(){
        ClaseDentro obj = new ClaseDentro();//usando la innerclass
        obj.DecirD();//accediendo como de normal, todo esto es solo posible desde aqui
    }
    public void Metodo(){
        class OtraClaseDentro{//tambien se puede hacer una inner class dentro de una funcion, entonces solo se podra usar dentro de esa funcion
            String nombre;
            public OtraClaseDentro(String _nombre){
                nombre = _nombre;
            }
        }
        OtraClaseDentro obj = new OtraClaseDentro("a");

    }
}


abstract class Plantilla{//las clases abstractas solo sirven para que otras clases hereden de estas, sirviendo como plantilla
    String nombre;
    public void reportarse(){//esta funcion funcionaria como de normal
        System.out.println(nombre);
    }
    public abstract void reportarseDescripcion();//esta funcion seria obligatorio sobreescribirla en subclases
}
class DePlantilla extends Plantilla{
    public void reportarseDescripcion(){//sobreescribiendo obligatoriamente la funcion abstracta
        System.out.println(nombre + "asfdasd");
    }
    public DePlantilla(String _nombre){
        nombre = _nombre;
    }
}



public class Clases {//clase principal del paquete (el orden de declaracion de las clases no importa)
    public static void main(String[] args) throws Exception {
        Objeto obj = new Objeto();//declarar una variable para ese objeto
        obj.nombre = "aa";//acceder a las propiedades del objeto
        obj.Reportar();//ejecutar un metodo/funcion del objeto
        boolean siono = obj instanceof Objeto;//devuelve true si es instancia de x clase o su clase hereda de esa clase

        ClaseMas objm = new ClaseMas(0);
        //ClaseMenos objmm = (ClaseMenos)objm;//se puede transformar la clase padre en la clase hija con casting (se usan nulls)

        OtroObjeto obj2 = new OtroObjeto(3, "asdf");//creando una instancia de un contstructor con parametros
        OtroObjeto obj3 = new OtroObjeto("nombre");//usando el otro constructor

        Plantilla objmmm = new DePlantilla("asdf");//creando un objeto de clase abstarcta desde un new con clase heredada de esta
    }
}