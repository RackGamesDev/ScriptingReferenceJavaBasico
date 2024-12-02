package varios;

import java.io.*;
import java.util.Scanner;

public class Archivos {
    public static void main(String[] args) {
        ObjetoGuardar obj1 = new ObjetoGuardar("asdf", 34);//Instancia a guardar

        //Guardar:
        final String nombreAchivo = "DATOS.bin";//El archivo es .bin
        try{
            OutputStream os = new FileOutputStream(nombreAchivo);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj1);//Guardar una instancia en el archivo
            oos.close();
        } catch (Exception e){System.out.println(e.getMessage());}

        //Cargar:
        try{
            InputStream is = new FileInputStream(nombreAchivo);
            ObjectInputStream ois = new ObjectInputStream(is);
            ObjetoGuardar objCargado = (ObjetoGuardar) ois.readObject();//Devuelve el objeto guardado
            System.out.println(objCargado.nombre);
        } catch (Exception e){System.out.println(e.getMessage());}
    }






    public static boolean Borrar(String nombre) throws Exception{//Borra un archivo, devuelve false si no existe o falla
        File obj = new File(nombre);
        return obj.delete();
    }
    public static boolean ArchivoExiste(String nombre) throws Exception{//true si el archivo existe
        try{
            File obj = new File(nombre);
            return obj.exists();
        } catch (Exception e){
            return false;
        }
    }
    public static void GuardarTexto(String archivo, String contenido) throws Exception{//Guardar texto en un archivo
        if(!ArchivoExiste(archivo)){
            File obj = new File(archivo);
            obj.createNewFile();
        }
        FileWriter writer = new FileWriter(archivo);
        writer.write(contenido);
        writer.close();
    }
    public static String CargarTexto(String archivo) throws Exception{//Cargar texto de un archivo
        if(ArchivoExiste(archivo)){
            File obj = new File(archivo);
            Scanner reader = new Scanner(obj);
            String contenido = "";
            while(reader.hasNextLine()){
                contenido+=reader.nextLine() + "\n";
            }
            reader.close();
            return contenido;
        } else {
            return "";
        }
    }
}




class ObjetoGuardar implements Serializable{//El objeto a guardar (una estancia de una clase)
    public String nombre;
    public int tamagno;
    public ObjetoGuardar(String _nombre, int _tamagno){
        nombre = _nombre; tamagno = _tamagno;
    }
}
