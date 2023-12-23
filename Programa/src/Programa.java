//el programa debe tener un archivo .java inicial con una clase llamada igual que el archivo, se compila con "javac archivo.java" y se ejecuta con "java archivo.class"

//por defecto se importa el paquete java.javalang
import java.util.*;//importar un paquete (vienen de java.x javax.x org.x jdk.x o de personalizados) (en este caso importa lo necesario para introducir datos por consola)
import unpaquete.*;//importando paquete ya creado (en este paquete se explican las clases)
import javax.swing.*;//paquete para interfaces graficas (casi obsoleto) (* importa todo el paquete)

import java.io.IOError;




public class Programa {//clase llamada igual que el archivo, esta es la que inicia el programa
    enum Enumerador {ARRIBA, ABAJO, DERECHA, IZQUIERDA};//como strings, pero solo x estados disponibles
    public static void main(String[] args) throws Exception {//funcion main que inicia el programa
        //comentarios
        /*
         * comentarios multilinea
         */

        System.out.println("hola\naa");//imprimir una linea en consola (\n para salto de linea, hay mas usos para \)

        int numero1, numero4;//declarar variables
        numero1 = 2;//no se pueden usar hasta que no tenga un valor
        byte numero2 = 2; long numero3 = 999l;
        System.out.println(numero1);//no hace falta poner texto en el println
        float decimal = 1.3f;//numeros decimales
        double decimalPreciso = 3.222222d;//mas preciso aun
        boolean siono = true;//bool
        final int constante = 33;//declarar constantes, mas optimizadas pero no se pueden cambiar
        numero2 = (byte)numero1;//intenta transformar de una variable a otra

        numero1++;//suma 1, -- par restar
        numero1 = numero2 + 4;//   + - * /
        numero1+=3;//opera la variable con x   += *= /= -?
        siono = numero1 > 0;//operadores booleanos (< > <> != ==)
        siono = (numero1 == 1) && (numero2 < 4);//operadores de condiciones   && || !| !&

        decimalPreciso = Math.sqrt(25);//raiz cuadrada (de la clase math, devuelve un double)
        numero1 = Math.round(decimal);//convierte float a int
        numero1 = (int)Math.pow(2,4);//raiz cuadrada (devuelve double)
        numero1 = (int)Math.random() * 10;//genera un numero aleatorio entre 0 y x
        numero1 = Integer.parseInt("3");//intenta transformar de string a int (devuelve double)
        

        char caracter = 'a';//guarda un caracter
        String texto = "textoo";//en realidad es un array de char, y no es una variable primitiva.    "" devuelve char[]
        numero1 = texto.length();//devuelve
        caracter = texto.charAt(2);//devuelve el caracter en x posicion
        siono = texto.equals("textoo");//sirve para comparar cadenas
        siono = texto.equalsIgnoreCase("Texto");//igual pero no casesensitive
        siono = texto == "a";//esto tambien funciona, pero equals viene con la clase
        texto = texto + "aasdf";//concatenar strings
        texto = texto.trim();//elimina los espacios al final y al principio
        texto = texto.substring(1, 3);//devuelve los caracteres entre las posiciones x1 y x2
        texto = Integer.toString(3);//cambia de numeros a string
        System.out.printf("%1.4f", decimalPreciso);//imprime decimales precisos con formatos (x.xxxx en este caso)

        Scanner entrada = new Scanner(System.in);//crear un escaner para introducir datos por consola (necesita importacion)
        texto = entrada.nextLine();//recibe texto desde la consola, nextInt() recibe un numero, si no se introduce un numero da error, hay una funcion por cada dato primitivo4
        //texto = JOptionPane.showInputDialog("introduce datos");//sale una ventana para introducir texto (javax.swing) (bugueable)

        Enumerador posicion = Enumerador.ABAJO;//usando el enumerador deeclarado afuera de la funcion
        System.out.println(posicion.name());//devuelve como string el estado del enum


        if(siono){//if tipico, lo del () debe devolver bool

        } else if(texto == "a"){//concatenar ifs

        } else {//else final

        }
        switch (numero1) {//comprobar el estado de una variable
            case 0://en caso de que sea x ejecuta este codigo
                
                break;//break para dejar de evaluar
            case 1:
                break;
            default://similar al else

                break;
        }
        texto = siono ? "es true" : "es false";//el operador ternario, dependiendo si la variable es true o false asigna un valor u otro

        while (numero1 < 10) {//ejecuta el codigo una y otra vez mientras x sea true
            numero1++;//se suele usar un contador para salir
            break;//break aborta el scope (sale de los {}), util aqui
        }
        do{//similar al while, pero ejecuta su contenido almenos una vez
            numero1++;
        }while(numero1<10);
        for(int i=0;i<10;i++){//bucle for: sentencia inicial ; condicion que se debe cumplir para la repeticion ; sentencia que se ejecuta al terminar

        }

        try{
            //codigo peligroso
        }
        catch(IOError e){//si el codigo del try da error llega a esta parte y sigue con el programa, e hace referencia a la variable con el error
            System.out.println("error " + e.getMessage());
        }


        int[] matriz = new int[10];//declara un array, una variable de x tipo con x posiciones
        matriz[2] = 4;//acceder a cada posicion
        int[] matriz2 = {0,1,2,3};//declarar un array con valores predefinidos
        numero4 = matriz.length;//devuelve el numero de posiciones del array
        for(int elemento:matriz){//bucle foreach, usa un array y ejecuta su contenido por cada posicion del array, donde x vale lo de esa posicion
            elemento = 0;//elemento seria matriz[x]
        }
        Arrays.sort(matriz);//ordena un array dependiendo de su tipo (numeros mayor a menor, alfabeticamente)
        int[][] dimensiones = new int [8][8];//declara un array de mas dimensiones
        int[][] dimensiones2 = {{0,1,2,3}, {4,5,6,7}};//otra forma de declarar arrays de varias dimensiones
        dimensiones[3][6] = 2;//acceder a x posicion dentro de x posicion dentro de... 

        funcion1();//ejecutando una funcion (como es estatica se puede ejecutar sin instanciar una clase)
        funcion2(1,5);//con parametros
        numero1 = funcion3(3, 6);//funcion que devuelve un dato


        //java.util:
        GregorianCalendar calendario = new GregorianCalendar(2023, 0, 23);//guarda un calendario (enero es 0)
        System.out.println(calendario.YEAR);//tiene sus funciones y propiedades
        Date fecha = calendario.getTime();//guarda una fecha, este objeto tambien tiene sus funciones y demas

    }

    static void funcion1(){//una funcion que ejecuta lineas de codigo
        System.out.println("hola");
    }
    static void funcion2(int num1, int num2){//pueden recibir parametros al llamarse
        System.out.println(num1+num2);
    }
    static int funcion3(int num1, int num2){
        return num1+num2;//si las funciones no son void devuelven algo, usando return
    }
}
