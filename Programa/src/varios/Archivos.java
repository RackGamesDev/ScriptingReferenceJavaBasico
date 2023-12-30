package varios;

import java.io.*;

public class Archivos {
    public static void main(String[] args) {
        ObjetoGuardar obj1 = new ObjetoGuardar("asdf", 34);//instancia a guardar

        //guardar:
        final String nombreAchivo = "DATOS.bin";//el archivo es .bin
        try{
            OutputStream os = new FileOutputStream(nombreAchivo);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj1);//guardar una instancia en el archivo
            oos.close();
        } catch (Exception e){System.out.println(e.getMessage());}

        //cargar:
        try{
            InputStream is = new FileInputStream(nombreAchivo);
            ObjectInputStream ois = new ObjectInputStream(is);
            ObjetoGuardar objCargado = (ObjetoGuardar) ois.readObject();//devuelve el objeto guardado
            System.out.println(objCargado.nombre);
        } catch (Exception e){System.out.println(e.getMessage());}
    }
}

class ObjetoGuardar implements Serializable{//el objeto a guardar (una estancia de una clase)
    public String nombre;
    public int tamagno;
    public ObjetoGuardar(String _nombre, int _tamagno){
        nombre = _nombre; tamagno = _tamagno;
    }
}