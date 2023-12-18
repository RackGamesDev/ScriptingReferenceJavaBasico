import javax.swing.*;
import java.awt.*;

class PanelLayouts extends JPanel{
    public PanelLayouts(){
        setLayout(new FlowLayout(FlowLayout.LEFT, 2,2));//el layout indica como se pondran los elementos automaticamente (alineacion, separacionx, separaciony)
        setLayout(new BorderLayout(10, 10));//este se basa en los puntos cardinales (separacionx, separaciony)
        add(new JButton("boton a"), BorderLayout.SOUTH);//si esta hecho con BorderLayout se especifica donde sale
        setLayout(new GridLayout(4,4));//un layout para cuadriculas (se ordenan de arriba a abajo y luego a la derecha)
        add(new JButton("boton b"));
        add(new JButton("boton c"));
    }
}






class VentanaLayouts extends JFrame{
    public VentanaLayouts(){
        setBounds(600,350,600,300);
        PanelLayouts lamina = new PanelLayouts(); 
        add(lamina);
        pack();//en caso de sobrar espacio, la ventana se redimensiona a menos
        setVisible(true);
    }
}
public class Layouts{
    public static void main(String[] args) throws Exception{
        VentanaLayouts ventana = new VentanaLayouts(); ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
