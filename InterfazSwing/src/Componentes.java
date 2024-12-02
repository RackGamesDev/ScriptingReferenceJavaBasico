import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;//Para cuadros de texto y Document

class LaminaMenu extends JPanel{
    public LaminaMenu(){
        JMenuBar barraSuperior = new JMenuBar(); add(barraSuperior);//Soporte para la barra de menu superior (se debe agregar antes que el resto de componentes para que aparezca arriba)
        JMenu archivoM = new JMenu("archivo"); JMenu editarM = new JMenu("editar");//Cada menu
        barraSuperior.add(archivoM); barraSuperior.add(editarM);//Agregando los menus a la barra
        JMenuItem guardarMI = new JMenuItem("guardar"); JMenuItem abrirMI = new JMenuItem("abrir", new ImageIcon("media/icono.png")); JMenuItem borrarMI = new JMenuItem("borrar"); JMenuItem agregarMI = new JMenuItem("agregar");//Cada opcion de los menus (se pueden poner iconos)
        JCheckBoxMenuItem opcionCheck = new JCheckBoxMenuItem("siono"); archivoM.add(opcionCheck);//Un menuitem con un checkbox, funciona igual que el menuitem y el checkbox
        JRadioButtonMenuItem radioCheck = new JRadioButtonMenuItem("este"); archivoM.add(radioCheck);//Un menuitem con un radio, funciona igual que el menuitem y el radio asi que necesitaria estar en un ButtonGroup
        archivoM.add(guardarMI); archivoM.add(abrirMI); editarM.add(borrarMI); editarM.add(agregarMI);//Agregar las opciones a los menus
        guardarMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));//Agregar un atajo de teclado, tecla + modificador (ctrl, alt, shift)
        JMenuItem subopcion1 = new JMenuItem("sub1"); JMenuItem subopcion2 = new JMenuItem("sub2"); JMenu subopciones = new JMenu();//pPoner iconos
        subopciones.add(subopcion1); subopciones.add(subopcion2); agregarMI.add(subopciones);//Agregar subopciones a opciones normales
        archivoM.addSeparator();//Pone un separador
    }
}
class LaminaClickDerecho extends JPanel{//Lamina que contiene los elementos del panel de click derecho, esto podria ser cualquier otro componente y no necesariamente una lamina
    public LaminaClickDerecho(){
        JPopupMenu emergente = new JPopupMenu();//Menu del click derecho
        JMenuItem op1 = new JMenuItem("op1"); JMenuItem op2 = new JMenuItem("op2");//Funciona igual que el JMenu, con items
        emergente.add(op1); emergente.add(op2);//Agregar los items/opciones
        setComponentPopupMenu(emergente);//Agrega el jpopupmenu a si mismo, se deberia agnadir a un componente
    }
}
class LaminaComponentes extends JPanel{
    public LaminaComponentes(){
        JTextField texto = new JTextField("texto por defecto", 10);//Sitio para escribir (texto por defecto, anchura)
        add(texto);
        String txt = texto.getText();//Recibir el texto que tiene
        texto.setText("asdfas");//Establecer texto
        texto.setEnabled(true);//Si es interactuable
        Document midoc = texto.getDocument();//Devuelve el Document del texto (todos los componentes de introduccion de texto tienen uno)
        midoc.addDocumentListener(new EscuchaTexto());//Subscribir el Document del textfield para que escuche eventos

        JPasswordField contrasegna = new JPasswordField(10);add(contrasegna);//Igual que jtextfield pero no se ven los caracteres
        char [] caracteres = contrasegna.getPassword();//En lugar de getText, lo devuelve como array de char y no como string
        JTextArea areaTexto = new JTextArea(10,2);//Igual que jtextfield pero multilinea (letras, columnas)
        areaTexto.setLineWrap(false);//Quiere decir que si el texto no cabe se pondra abajo (si no, el ancho se autoagrandara)
        areaTexto.append("asdfasfd");//Agrega texto al final (concatenacion simple)
        JTextPane panelTexto = new JTextPane(); add(panelTexto);//Como el textarea pero sin bordes, debe ser el unico elemento en su panel o agregarse al frame

        JScrollPane laminaBarras = new JScrollPane(areaTexto);//Poniendo barras de scroll a un componente
        add(laminaBarras);//En lugar de poner el componente se pone solo la lamina

        JButton boton = new JButton("click"); add(boton);//Un boton (eventos ya explicados en App.java)
        JLabel label = new JLabel("textooo"); add(label);//Un texto sin mas
        label.setFont(new Font("Arial", Font.BOLD, 26));//Al igual que con cualquier otro componente, se le peuden aplicar fuentes

        JCheckBox check = new JCheckBox("si o no"); add(check);//Un checkbox simple
        check.addActionListener(new EscuchaComponente());//Funciona parecido a un boton
        boolean siono = check.isSelected();//Devuelve si esta checkeado o no, setSelected() para cambiarlo

        ButtonGroup grupoRadio = new ButtonGroup();//Agrupador para radio buttons
        JRadioButton radio1 = new JRadioButton("opcion1", false);//Los radio buttons son checkbox pero solo puede haber uno activo en su grupo (texto, activado)
        JRadioButton radio2 = new JRadioButton("opcion2", true);
        grupoRadio.add(radio1); grupoRadio.add(radio2);//Agregar los radios al grupo
        radio1.addActionListener(new EscuchaComponente()); radio1.addActionListener(new EscuchaComponente());//Los eventos van igual que con los checkbox
        add(radio1); add(radio2);//Simplemente se ponen en la lamina
        siono = radio1.isSelected();//Devuelve si esta checkeado o no, setSelected() para cambiarlo

        JComboBox comboBox = new JComboBox(); add(comboBox);//Un cuadro para elegir una de varias opciones
        comboBox.addItem("opcion1"); comboBox.addItem("opcion2"); comboBox.addItem("opcion3");//Agregar opciones
        comboBox.setEditable(true);//Si es editable, se puede escribir en el como un textbox
        comboBox.addActionListener(new EscuchaComponente());
        txt = (String)comboBox.getSelectedItem();//Devuelve como string el texto aplicado
        txt = (String)comboBox.getItemAt(1);//Devuelve como string el texto de x item

        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50); add(slider);//Barra para elegir un numero (direccion, minimo, maximo, por defecto)
        slider.setMajorTickSpacing(25); slider.setMinorTickSpacing(5); slider.setPaintTicks(true);//Cada cuanto salen las lineas identificador
        slider.setPaintLabels(true);//Activar numeros en las lineas grandes
        slider.setSnapToTicks(true);//Agrega imanes a los numeros grandes
        slider.addChangeListener(new EscuchaSlider());//Aplicar el ChangeListener
        int numero = slider.getValue();//Devuelve el numero puesto, setValue() para cambiarlo

        JSpinner spinner = new JSpinner();//Un textbox para numeros con botones de subir y bajar
        spinner.setPreferredSize(new Dimension(50, 20));//para cambiar el tamagno
        add(spinner);
        JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel()); add(spinnerFecha);//Igual pero para fechas (dia/mes/agno hora:minuto  actual)
        String [] opciones = {"op0", "op1", "op2"}; JSpinner spinnerLista = new JSpinner(new SpinnerListModel(opciones)); add(spinnerLista);//Similar al combobox
        JSpinner spinnerNumber = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1)); add(spinnerNumber);//Mas especifico para numeros (por defecto, minimo, maximo, salto)
    }
    private class EscuchaTexto implements DocumentListener{//Clase de escucha de eventos preparada para cuadros de texto
        public void insertUpdate(DocumentEvent e){//Cuando se inserta texto
        }
        public void removeUpdate(DocumentEvent e){//Cuando se borra texto
        }
        public void changedUpdate(DocumentEvent e){//Cuando cambia el contenido
        }
    }
    private class EscuchaComponente implements ActionListener{
        public void actionPerformed(ActionEvent e) {//Evento para cualquier accion de cambio de estado/activacion de componente
            System.out.println("se ha cambiado el estado o se ha accionado");
        }
    }
    private class EscuchaSlider implements ChangeListener{//Clase de escucha para cuando cambie el valor del slider
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
