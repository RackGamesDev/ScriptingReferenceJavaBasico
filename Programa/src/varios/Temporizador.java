package varios;
import javax.swing.JOptionPane;//(opcional para pausar el programa al final)
import javax.swing.Timer;//ActionListener viene de este paquete
import java.awt.Toolkit;//para el sonido (opcional)
import java.awt.event.*;//Timer viene de este paquete
import java.util.*;//Date viene de este paquete (opcional)

class AccionOyente implements ActionListener{//al implementar de la interfaz ActionListener, tendra una funcion llamable desde el Timer
    public void actionPerformed(ActionEvent e){//funcion que se va a ejecutar
        Date ahora = new Date();//variable que almacena la hora en la que se crea
        Toolkit.getDefaultToolkit().beep();//hace un sonido del sistema operativo
        System.out.println("la hora es: " + ahora);
    }
}

public class Temporizador {
    public static void main(String[] args) throws Exception {
        AccionOyente oyente = new AccionOyente();//crear un listener, desde la clase que implementa de ActionListener
        Timer temporizador = new Timer(5000, oyente);//crear un temporizador (x milisegundos, listener a ejecutar)
        temporizador.start();//iniciar el timer, se puede parar con stop
        //while (true) {}//para que la aplicacion no llegue al final y mate al timer se puede bloquear con un while, pero ocuparia mucho rendimiento
        JOptionPane.showMessageDialog(null, "pulsa para terminar");//tambien se puede hacer con interfaces graficas
        System.exit(0);
    }
}

