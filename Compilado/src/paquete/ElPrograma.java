package paquete;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import otropaquete.ClaseLejos;

public class ElPrograma{//Programa simple que usa paquetes y otras cosas
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in); String txt = entrada.nextLine(); entrada.close();
        System.out.println(txt);
        UnaClase cla = new UnaClase();
        ClaseLejos cla2 = new ClaseLejos();
        JOptionPane.showMessageDialog(null, "hola");
        MultieventoVentana ven = new MultieventoVentana(); ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MultieventoVentana extends JFrame{
    public MultieventoVentana(){
        setBounds(200,200,200,200);
        setVisible(true);
    }
}
//Para compilar a .jar hace falta hacer el manifest.txt junto al script principal
//windows: agregar variable de entorno al sistema con la ruta del compilador (en el array de path) "C:\Program Files\Java\jdk-21\bin" (cambiando la version)
//Usar el comando "jar cvfm ElPrograma.jar src/manifest.txt bin/*" en la raiz del proyecto (con cmd, no con powershell)
//Alternativamente se puede usar el boton de abajo a la izquierda en visual studio (para eso hay que hacer la carpeta .settings)

//Para compilar a .exe se transforma el .jar a .exe con launch4j
