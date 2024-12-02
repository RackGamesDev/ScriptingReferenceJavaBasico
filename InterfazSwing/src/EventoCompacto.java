import javax.swing.*;
import java.awt.event.*;

//Una manera de hacerlo todo super compacto
public class EventoCompacto {
    private static class VentanaCompacta extends JFrame{
        public VentanaCompacta(){
            JPanel lamina = new JPanel(); 
            JButton boton = new JButton("click");
            boton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("click");
                }
            });
            lamina.add(boton);
            add(lamina);
            setBounds(200,200,200,200); setVisible(true);
        }
    }
    public static void main(String[] args) {
        VentanaCompacta ventana = new VentanaCompacta();
    }
}
