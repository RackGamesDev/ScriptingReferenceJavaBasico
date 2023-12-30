package varios;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

import java.io.File;

class Reproductor{
    public Clip sonido;
    public String nombre;
    public void cargarSonido(String ruta){//mete el sonido en el reproductor (por ruta del proyecto) (una vez exportado, se tiene que poner el sonido tambien en la carpeta de la build ya que no se enpaquetan)
        try{
            File archivo = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            sonido = AudioSystem.getClip();
            sonido.open(audioStream);
        } catch (Exception e){
            System.out.println("error");
        }
    }
    public void reproducir(int frame){//reproduce el sonido a partir de x sample (0 = inicio)
        if(sonido != null){
            sonido.setFramePosition(frame);
            sonido.start();
        }
    }
    public void detener(){//detiene el sonido del todo
        if(sonido != null && sonido.isRunning()){
            sonido.setFramePosition(0);
            sonido.stop();
        }
    }
    public void cambiarFrame(int frame){//mueve el "cursor" por el audio
        if(sonido != null){
            sonido.setFramePosition(frame);
        }
    }
}

public class Sonido{
    public static void main(String[] args){
        Reproductor player = new Reproductor();
        player.cargarSonido("media/audio.wav");
        player.reproducir(0);
        player.detener();

        JOptionPane.showMessageDialog(null, "ok!");
    }
}
