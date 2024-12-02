package varios;
import java.util.*;

public class TemporizadorSimple {
    static void temporizador(){
        Timer temporizador = new Timer();
        TimerTask tarea = new TimerTask() {
            public void run(){//funcion a ejecutar
                System.out.println("mensaje ocurrido en " + new Date());
            }
        };
        temporizador.schedule(tarea, 0, 1000);//Iniciar el temporizador (funcion run(), cuanto tarda en empezar, cada cuanto se ejecuta (0 para solo una vez))
    }
}
