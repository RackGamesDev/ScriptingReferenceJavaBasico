import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;//para cuadros de texto y Document

class LaminaMenu extends JPanel{
    public LaminaMenu(){
        JMenuBar barraSuperior = new JMenuBar(); add(barraSuperior);//soporte para la barra de menu superior (se debe agregar antes que el resto de componentes para que aparezca arriba)
        JMenu archivoM = new JMenu("archivo"); JMenu editarM = new JMenu("editar");//cada menu
        barraSuperior.add(archivoM); barraSuperior.add(editarM);//agregando los menus a la barra
        JMenuItem guardarMI = new JMenuItem("guardar"); JMenuItem abrirMI = new JMenuItem("abrir"); JMenuItem borrarMI = new JMenuItem("borrar"); JMenuItem agregarMI = new JMenuItem("agregar");//cada opcion de los menus
        archivoM.add(guardarMI); archivoM.add(abrirMI); editarM.add(borrarMI); editarM.add(agregarMI);//agregar las opciones a los menus
        JMenuItem subopcion1 = new JMenuItem("sub1"); JMenuItem subopcion2 = new JMenuItem("sub2"); JMenu subopciones = new JMenu();
        subopciones.add(subopcion1); subopciones.add(subopcion2); agregarMI.add(subopciones);//agregar subopciones a opciones normales
        archivoM.addSeparator();//pone un separador
    }
}
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
        areaTexto.append("asdfasfd");//agrega texto al final (concatenacion simple)

        JScrollPane laminaBarras = new JScrollPane(areaTexto);//poniendo barras de scroll a un componente
        add(laminaBarras);//en lugar de poner el componente se pone solo la lamina

        JButton boton = new JButton("click"); add(boton);//un boton (eventos ya explicados en App.java)
        JLabel label = new JLabel("textooo"); add(label);//un texto sin mas
        label.setFont(new Font("Arial", Font.BOLD, 26));//al igual que con cualquier otro componente, se le peuden aplicar fuentes

        JCheckBox check = new JCheckBox("si o no"); add(check);//un checkbox simple
        check.addActionListener(new EscuchaComponente());//funciona parecido a un boton
        boolean siono = check.isSelected();//devuelve si esta checkeado o no, setSelected() para cambiarlo

        ButtonGroup grupoRadio = new ButtonGroup();//agrupador para radio buttons
        JRadioButton radio1 = new JRadioButton("opcion1", false);//los radio buttons son checkbox pero solo puede haber uno activo en su grupo (texto, activado)
        JRadioButton radio2 = new JRadioButton("opcion2", true);
        grupoRadio.add(radio1); grupoRadio.add(radio2);//agregar los radios al grupo
        radio1.addActionListener(new EscuchaComponente()); radio1.addActionListener(new EscuchaComponente());//los eventos van igual que con los checkbox
        add(radio1); add(radio2);//simplemente se ponen en la lamina
        siono = radio1.isSelected();//devuelve si esta checkeado o no, setSelected() para cambiarlo

        JComboBox comboBox = new JComboBox(); add(comboBox);//un cuadro para elegir una de varias opciones
        comboBox.addItem("opcion1"); comboBox.addItem("opcion2"); comboBox.addItem("opcion3");//agregar opciones
        comboBox.setEditable(true);//si es editable, se puede escribir en el como un textbox
        comboBox.addActionListener(new EscuchaComponente());
        txt = (String)comboBox.getSelectedItem();//devuelve como string el texto aplicado
        txt = (String)comboBox.getItemAt(1);//devuelve como string el texto de x item

        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50); add(slider);//barra para elegir un numero (direccion, minimo, maximo, por defecto)
        slider.setMajorTickSpacing(25); slider.setMinorTickSpacing(5); slider.setPaintTicks(true);//cada cuanto salen las lineas identificador
        slider.setPaintLabels(true);//activar numeros en las lineas grandes
        slider.setSnapToTicks(true);//agrega imanes a los numeros grandes
        slider.addChangeListener(new EscuchaSlider());//aplicar el ChangeListener
        int numero = slider.getValue();//devuelve el numero puesto, setValue() para cambiarlo

        JSpinner spinner = new JSpinner();//un textbox para numeros con botones de subir y bajar
        spinner.setPreferredSize(new Dimension(50, 20));//para cambiar el tamagno
        add(spinner);
        JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel()); add(spinnerFecha);//igual pero para fechas (dia/mes/agno hora:minuto  actual)
        String [] opciones = {"op0", "op1", "op2"}; JSpinner spinnerLista = new JSpinner(new SpinnerListModel(opciones)); add(spinnerLista);//similar al combobox
        JSpinner spinnerNumber = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1)); add(spinnerNumber);//mas especifico para numeros (por defecto, minimo, maximo, salto)
    }
    private class EscuchaTexto implements DocumentListener{//clase de escucha de eventos preparada para cuadros de texto
        public void insertUpdate(DocumentEvent e){//cuando se inserta texto
        }
        public void removeUpdate(DocumentEvent e){//cuando se borra texto
        }
        public void changedUpdate(DocumentEvent e){//cuando cambia el contenido
        }
    }
    private class EscuchaComponente implements ActionListener{
        public void actionPerformed(ActionEvent e) {//evento para cualquier accion de cambio de estado/activacion de componente
            System.out.println("se ha cambiado el estado o se ha accionado");
        }
    }
    private class EscuchaSlider implements ChangeListener{//clase de escucha para cuando cambie el valor del slider
        public void stateChanged(ChangeEvent e) {
            System.out.println("cambio el valor del slider");
        }
    }
}

class VentanaComponentes extends JFrame{
    public VentanaComponentes(){
        setLayout(new BorderLayout(10, 10));
        add(new LaminaMenu(), BorderLayout.NORTH);
        add(new LaminaComponentes(), BorderLayout.CENTER);
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
