package varios;
import javax.swing.JOptionPane;//(opcional para pausar el programa al final)
import javax.swing.Timer;//ActionListener viene de este paquete
import java.awt.Toolkit;//Para el sonido (opcional)
import java.awt.event.*;//Timer viene de este paquete
import java.util.*;//Date viene de este paquete (opcional)

class AccionOyente implements ActionListener{//Al implementar de la interfaz ActionListener, tendra una funcion llamable desde el Timer
    public void actionPerformed(ActionEvent e){//Funcion que se va a ejecutar
        Date ahora = new Date();//Variable que almacena la hora en la que se crea
        Toolkit.getDefaultToolkit().beep();//Hace un sonido del sistema operativo
        System.out.println("la hora es: " + ahora);
    }
}

public class Temporizador {
    public static void main(String[] args) throws Exception {
        AccionOyente oyente = new AccionOyente();//Crear un listener, desde la clase que implementa de ActionListener
        Timer temporizador = new Timer(5000, oyente);//Crear un temporizador (x milisegundos, listener a ejecutar)
        temporizador.start();//Iniciar el timer, se puede parar con stop
        //while (true) {}//Para que la aplicacion no llegue al final y mate al timer se puede bloquear con un while, pero ocuparia mucho rendimiento
        JOptionPane.showMessageDialog(null, "pulsa para terminar");//Tambien se puede hacer con interfaces graficas
        System.exit(0);
    }
}

