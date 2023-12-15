import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MultieventoVentana extends JFrame{
    public MultieventoVentana(){
        setBounds(200,200,200,200);
        //add(new MultieventoPanelAccion());
        //add(new MultieventoPanelMultifuente());
    }
}

class MultieventoPanelAccion extends JPanel{//este programa cambia su color de fondo con las teclas a/b o los botones accionando igualmente el mismo evento (multievento)
    public MultieventoPanelAccion(){
        MultieventoAccion accionA = new MultieventoAccion("color a", new ImageIcon("media/icono.png"), Color.darkGray);//instanciando el evento personalizado
        MultieventoAccion accionB = new MultieventoAccion("color b", new ImageIcon("media/icono.png"), Color.white);//y este para el otro boton/atajo
        add(new JButton(accionA));//usando la clase MultieventoAccion:AbstractAction para instanciar elementos (usando las propiedades del putValue)
        add(new JButton(accionB));

        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//crear input map para este panel
        KeyStroke teclaA = KeyStroke.getKeyStroke("ctrl A"); KeyStroke teclaB = KeyStroke.getKeyStroke("ctrl B");//crear atajo de teclado (tiene su propia sintaxis para especificar teclas)
        mapaEntrada.put(teclaA, "color a"); mapaEntrada.put(teclaB, "color b");//asignar el KeyStroke a un elemento (usando el nombre de la instancia de MultieventoAccion)
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("color a", accionA); mapaAccion.put("color b", accionB);//asignar aqui tambien el KeyStroke para vincularlo a la accion
    }
    class MultieventoAccion extends AbstractAction{//igual que las clases adaptadoras para eventos pero sirve para cualquier tipo de evento (interfaz, teclado, raton, ventan, etc) (es una clase interna porque solo se usara en este panel)
        public MultieventoAccion(String nombre, Icon icono, Color colorFondo){//como el evento puede venir de cualquier sitio se recomienda hacer un constructor con datos genericos a fuentes
            putValue(Action.NAME, nombre);//nombre del elemento que hace el evento
            putValue(Action.SMALL_ICON, icono);//icono (opcional)
            putValue(Action.SHORT_DESCRIPTION, "cambiar color de fondo a " + colorFondo.toString());//descripcion (opcional)
            putValue("ColorDeFondo", colorFondo);//creando claves adicionales (en este caso porque cada boton/atajo cambia el color de fondo)
        }
        public void actionPerformed(ActionEvent e){//cuando se realiza la accion del elemento o cualquier otra que se especifique
            setBackground((Color)getValue("ColorDeFondo"));//recibiendo propiedades personalizadas del evento
            System.out.println(getValue(Action.NAME));//en el caso de propiedades de Action.X no hace falta casting de tipos
        }
    }
}

class MultieventoPanelMultifuente extends JPanel{//este otro programa envia una accion a varios elementos de una sola fuente (un boton que abra una ventana y otro que las cierre todas)
    JButton botonCerrar = new JButton("cerrar");//como este boton acciona multiples eventos se hace en la clase en si
    public MultieventoPanelMultifuente(){
        JButton botonNuevo = new JButton("nuevo"); add(botonNuevo); add(botonCerrar);
        botonNuevo.addActionListener(new OyenteNuevo());//agregar el oyente de abrir ventanas al boton de abrir ventanas
    }
    private class OyenteNuevo implements ActionListener{//oyente para el boton de nuevo, que abre una ventana
        public void actionPerformed(ActionEvent e){
            MultieventoMarcoEmergente marco = new MultieventoMarcoEmergente(botonCerrar);//necesita una referencia al boton de cerrar porque esta en otra clase
        }
    }
}
class MultieventoMarcoEmergente extends JFrame{
    private static int contador=0;//indica el numero de ventana, static para que lo compartan todas las instancias
    public MultieventoMarcoEmergente(JButton botonQueCierra){
        contador++;
        setTitle("ventana " + contador);
        setBounds(40*contador, 40*contador, 10, 10);
        setVisible(true);
        botonQueCierra.addActionListener(new CierraTodos());//asignando el evento de cerrar al boton pasado por parametros
    }
    private class CierraTodos implements ActionListener{//oyente para el boton de cerrar, que cierra todas las ventanas
        public void actionPerformed(ActionEvent e) {
            dispose();//cerrar ventana
            contador = 0;
        }
    }
}


public class Multievento {
    public static void main(String[] args) throws Exception {
        MultieventoVentana laVentana = new MultieventoVentana();
        laVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        laVentana.setVisible(true);
    }
}
