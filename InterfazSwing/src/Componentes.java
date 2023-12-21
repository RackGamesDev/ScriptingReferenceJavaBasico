import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;//para cuadros de texto y Document

class LaminaComponentes extends JPanel{
    public LaminaComponentes(){
        JTextField texto = new JTextField("texto por defecto", 10);//sitio para escribir (texto por defecto, anchura)
        add(texto);
        String txt = texto.getText();//recibir el texto que tiene
        texto.setText("asdfas");//establecer texto
        texto.setEnabled(true);//si es interactuable
        Document midoc = texto.getDocument();//devuelve el Document del texto (todos los componentes de introduccion de texto tienen uno)
        midoc.addDocumentListener(new EscuchaTexto());//suscribir el Document del textfield para que escuche eventos

        JPasswordField contrasegna = new JPasswordField(10);add(contrasegna);//igual que jtextfield pero no se ven los caracteres
        char [] caracteres = contrasegna.getPassword();//en lugar de getText, lo devuelve como array de char y no como string
        JTextArea areaTexto = new JTextArea(10,2);//igual que jtextfield pero multilinea (letras, columnas)
        areaTexto.setLineWrap(false);//quiere decir que si el texto no cabe se pondra abajo (si no, el ancho se autoagrandara)

        JScrollPane laminaBarras = new JScrollPane(areaTexto);//poniendo barras de scroll a un componente
        add(laminaBarras);//en lugar de poner el componente se pone solo la lamina

        JButton boton = new JButton("click"); add(boton);//un boton (eventos ya explicados en App.java)
        JLabel label = new JLabel("textooo"); add(label);//un texto sin mas
    }
    private class EscuchaTexto implements DocumentListener{//clase de escucha de eventos preparada para cuadros de texto
        public void insertUpdate(DocumentEvent e){//cuando se inserta texto
        }
        public void removeUpdate(DocumentEvent e){//cuando se borra texto
        }
        public void changedUpdate(DocumentEvent e){//cuando cambia el contenido
        }
    }
}



class VentanaComponentes extends JFrame{
    public VentanaComponentes(){
        add(new LaminaComponentes());
        setBounds(100, 100, 700, 700);
        setVisible(true);
    }
}
public class Componentes {
    public static void main(String[] args) throws Exception {
        VentanaComponentes ventana = new VentanaComponentes();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
