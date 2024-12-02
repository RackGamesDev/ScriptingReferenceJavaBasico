//El programa debe tener un archivo .java inicial con una clase llamada igual que el archivo, se compila con "javac archivo.java" y se ejecuta con "java archivo.class"

//Por defecto se importa el paquete java.javalang
import java.util.*;//Importar un paquete (vienen de java.x javax.x org.x jdk.x o de personalizados) (en este caso importa lo necesario para introducir datos por consola)
import unpaquete.*;//Importando paquete ya creado (en este paquete se explican las clases)
import javax.swing.*;//Paquete para interfaces graficas (casi obsoleto) (* importa todo el paquete)

import java.io.IOError;




public class Programa {//Clase llamada igual que el archivo, esta es la que inicia el programa
    enum Enumerador {ARRIBA, ABAJO, DERECHA, IZQUIERDA};//Como strings, pero solo x estados disponibles
    public static void main(String[] args) throws Exception {//Funcion main que inicia el programa
        //Comentarios
        /*
         * Comentarios multilinea
         */

        System.out.println("hola\naa");//Imprimir una linea en consola (\n para salto de linea, hay mas usos para \)

        int numero1, numero4;//Declarar variables
        numero1 = 2;//No se pueden usar hasta que no tenga un valor
        byte numero2 = 2; long numero3 = 999l;
        System.out.println(numero1);//No hace falta poner texto en el println
        float decimal = 1.3f;//Numeros decimales
        double decimalPreciso = 3.222222d;//Mas preciso aun
        boolean siono = true;//bool
        final int constante = 33;//Declarar constantes, mas optimizadas pero no se pueden cambiar
        numero2 = (byte)numero1;//Intenta transformar de una variable a otra

        numero1++;//Suma 1, -- par restar
        numero1 = numero2 + 4;//   + - * /
        numero1+=3;//Opera la variable con x   += *= /= -?
        siono = numero1 > 0;//Operadores booleanos (< > <> != ==)
        siono = (numero1 == 1) && (numero2 < 4);//Operadores de condiciones   && || !| !&

        decimalPreciso = Math.sqrt(25);//Raiz cuadrada (de la clase math, devuelve un double)
        numero1 = Math.round(decimal);//Convierte float a int
        numero1 = (int)Math.pow(2,4);//Raiz cuadrada (devuelve double)
        numero1 = (int)Math.random() * 10;//Genera un numero aleatorio entre 0 y x
        numero1 = Integer.parseInt("3");//Intenta transformar de string a int (devuelve double)
        

        char caracter = 'a';//Guarda un caracter
        String texto = "textoo";//En realidad es un array de char, y no es una variable primitiva.    "" devuelve char[]
        numero1 = texto.length();//Devuelve
        caracter = texto.charAt(2);//Devuelve el caracter en x posicion
        siono = texto.equals("textoo");//Sirve para comparar cadenas
        siono = texto.equalsIgnoreCase("Texto");//Igual pero no casesensitive
        siono = texto == "a";//Esto tambien funciona, pero equals viene con la clase
        texto = texto + "aasdf";//Concatenar strings
        texto = texto.trim();//Elimina los espacios al final y al principio
        texto = texto.substring(1, 3);//Devuelve los caracteres entre las posiciones x1 y x2
        texto = Integer.toString(3);//Cambia de numeros a string
        System.out.printf("%1.4f", decimalPreciso);//Imprime decimales precisos con formatos (x.xxxx en este caso)

        Scanner entrada = new Scanner(System.in);//Crear un escaner para introducir datos por consola (necesita importacion)
        texto = entrada.nextLine();//Recibe texto desde la consola, nextInt() recibe un numero, si no se introduce un numero da error, hay una funcion por cada dato primitivo4
        //texto = JOptionPane.showInputDialog("introduce datos");//Sale una ventana para introducir texto (javax.swing) (bugueable)

        Enumerador posicion = Enumerador.ABAJO;//Usando el enumerador deeclarado afuera de la funcion
        System.out.println(posicion.name());//Devuelve como string el estado del enum

        //Hay muchisimas mas clases y funciones en la API, aqui solo se muestra un poco


        if(siono){//if tipico, el () debe devolver bool

        } else if(texto == "a"){//Concatenar ifs

        } else {//else final

        }
        switch (numero1) {//Comprobar el estado de una variable
            case 0://En caso de que sea x ejecuta este codigo
                
                break;//break para dejar de evaluar
            case 1:
                break;
            default://Similar al else
                break;
        }
        texto = siono ? "es true" : "es false";//El operador ternario, dependiendo si la variable es true o false asigna un valor u otro

        while (numero1 < 10) {//Ejecuta el codigo una y otra vez mientras x sea true
            numero1++;//Se suele usar un contador para salir
            break;//break aborta el scope (sale de los {}), util aqui
        }
        do{//Similar al while, pero ejecuta su contenido almenos una vez
            numero1++;
        }while(numero1<10);
        for(int i=0;i<10;i++){//Bucle for: sentencia inicial ; condicion que se debe cumplir para la repeticion ; sentencia que se ejecuta al terminar

        }

        try{
            //Codigo peligroso
        }
        catch(IOError e){//Si el codigo del try da error llega a esta parte y sigue con el programa, e hace referencia a la variable con el error
            System.out.println("error " + e.getMessage());
        }


        int[] matriz = new int[10];//Declara un array, una variable de x tipo con x posiciones
        matriz[2] = 4;//Acceder a cada posicion
        int[] matriz2 = {0,1,2,3};//Declarar un array con valores predefinidos
        numero4 = matriz.length;//Devuelve el numero de posiciones del array
        for(int elemento:matriz){//Bucle foreach, usa un array y ejecuta su contenido por cada posicion del array, donde x vale lo de esa posicion
            elemento = 0;//Elemento seria matriz[x]
        }
        Arrays.sort(matriz);//Ordena un array dependiendo de su tipo (numeros mayor a menor, alfabeticamente)
        int[][] dimensiones = new int [8][8];//Declara un array de mas dimensiones
        int[][] dimensiones2 = {{0,1,2,3}, {4,5,6,7}};//Otra forma de declarar arrays de varias dimensiones
        dimensiones[3][6] = 2;//Acceder a x posicion dentro de x posicion dentro de... 

        funcion1();//Ejecutando una funcion (como es estatica se puede ejecutar sin instanciar una clase)
        funcion2(1,5);//Con parametros
        numero1 = funcion3(3, 6);//Funcion que devuelve un dato


        //java.util:
        GregorianCalendar calendario = new GregorianCalendar(2023, 0, 23);//Guarda un calendario (enero es 0)
        System.out.println(calendario.YEAR);//Tiene sus funciones y propiedades
        Date fecha = calendario.getTime();//Guarda una fecha, este objeto tambien tiene sus funciones y demas

    }

    static void funcion1(){//Una funcion que ejecuta lineas de codigo
        System.out.println("hola");
    }
    static void funcion2(int num1, int num2){//Pueden recibir parametros al llamarse
        System.out.println(num1+num2);
    }
    static int funcion3(int num1, int num2){
        return num1+num2;//Si las funciones no son void devuelven algo, usando return
    }
}
