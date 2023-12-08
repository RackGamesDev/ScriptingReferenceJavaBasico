import java.awt.*;
import javax.swing.*;//libreria con las cosas de la interfaz, tambien usa java.awt


class UnaVentana extends JFrame{//cada ventana debe alojarse en una clase, que herede de JFrame
    public UnaVentana(){//en el constructor se ponen todas las propiedades de la ventana
        //setSize(500,300);//tamagno de ventana
        //setLocation(100, 100);//posicion de ventana
        setBounds(500,300,500,500);//lo mismo, sizex sizey locationx locationy
        setResizable(false);//si se puede redimensionar
        //setExtendedState(Frame.MAXIMIZED_BOTH);//hace que este en pantalla completa
        setTitle("titulo");//titulo de ventana

        Toolkit pantalla = Toolkit.getDefaultToolkit();//tiene propiedades sobre el sistema grafico
        Dimension tamagnoPantalla = pantalla.getScreenSize();//devuelve como objeto de Dimension el tamagno de la pantalla
        System.out.println("x " + tamagnoPantalla.width + "  y " + tamagnoPantalla.height);//cada valor por separado (pantalla principal)

        Image icono = pantalla.getImage("media/icono.png");//guardar una imagen desde ruta relativa (desde fuera de la carpeta src)
        setIconImage(icono);//establecerlo como icono de ventana
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        UnaVentana ventana = new UnaVentana();//abrir una ventana ya especificada en una clase
        ventana.setVisible(true);//hacerla visible (esto se puede poner en el constructor)
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//especifica que hacer al cerrar la ventana, en este caso cierra el programa (ventana principal) (HIDE_ON_CLOSE para ventanas secundarias) (esto se puede poner en el constructor)

    }
}