import java.awt.*;
import javax.swing.*;//libreria con las cosas de la interfaz, tambien usa java.awt
import java.awt.event.*;//para los eventos de componentes
import java.awt.geom.*;//para figuras con Java2D
import javax.imageio.*;//para imagenes
import java.io.*;//para archivos, necesario para las imagenes

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


        LaminaDibujo miLamina = new LaminaDibujo();//instanciar un componente en una ventana (en este caso poniendo el JPanel en el JFrame)
        //add(miLamina);
        miLamina.setBackground(Color.white);//establece el color de fondo con la clase Color
        miLamina.setForeground(Color.black);//establece el color principal

        LaminaEventos lamina2 = new LaminaEventos(); add(lamina2);
        addWindowListener(new MVentana());//usando el listener para eventos de la ventana (hecho mas abajo)
        addWindowStateListener(new MVentanaEstado());//activando el listener de estados de ventana alternativo (hecho mas abajo)

        addKeyListener(new EventoTeclado());//usar el listener de eventos de teclado para este componente (hecho mas abajo)
        addMouseListener(new EventoRaton());//usar el listener de eventos de raton para este componente (hecho mas abajo)
        addMouseMotionListener(new EventoMovimientoRaton());//lo mismo pero para el motion (hecho mas abajo)
    }
}

class LaminaDibujo extends JPanel{//es un panel que puede servir para pintar componentes dentro y organizar layout
    public void paintComponent(Graphics g){//aqui dentro se ponen las cosas a dibujar (esto esta obsoleto, ahora se usa mas el paqueta Java2D)
        super.paintComponent(g);
        /*g.drawString("aaa", 10, 10);//pintar texto simple (texto, x, y)
        g.drawRect(20, 20, 50, 50);//dibuja un cuadrado (posx, posy, sizx, sizy)
        g.drawLine(20, 20, 30, 30);//dibuja una linea (startx, starty, endx, endy)
        g.drawArc(50, 50, 70, 70, 120, 150);//como la linea pero curva (linea, angulo inicial, angulo final)*/
        Graphics2D g2 = (Graphics2D) g;//para usar Java2D (lo anterior esta obsoleto)
        Rectangle2D rectangulo = new Rectangle2D.Double(20, 20, 50, 50);//similar a lo anterior pero los dibujos se almacenan en variables
        g2.draw(rectangulo);//agregar la forma al panel
        Ellipse2D elipse = new Ellipse2D.Double(20, 20, 50, 50);//hay muchas formas disponibles
        elipse.setFrame(rectangulo);//normalmente se pueden copiar los transforms asi, el elipse tendria las mismas dimensiones que el rectangulo
        g2.draw(elipse);
        double centroY = elipse.getCenterY();//recibiendo propiedades de las formas
        g2.draw(new Line2D.Double(20,20,50,50));//se puede instanciar directamente en draw()
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(10, centroY, 20, centroY + 10);//lo mismo pero poniendolo desde el centro
        g2.setPaint(Color.red);//pone un color para pintar las siguientes formas (de la clase color, new Color(r,g,b) para color especifico)
        g2.fill(circulo);//igual que draw, pero el interior se pinta con el color seleccionado con setPaint()
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();//todas las fuentes disponibles en el sistema
        Font fuente = new Font("Arial", Font.BOLD, 26);//guarda una fuente apartir de un nombre (debe estar instalada)
        g2.setFont(fuente);//selecciona esa fuente
        g2.drawString("fuente", 60, 60);

        try{imagen = ImageIO.read(new File("media/icono.png"));}//pone el contenido de la imagen en la variable
        catch(IOException e){System.out.println("error");}
        g.drawImage(imagen, 80, 0, null);//pintar la imagen
        System.out.println(imagen.getHeight(this));//altura de la imagen, getWidth para ancho
        g.copyArea(80, 0, 64, 64, 40, 0);//copiar pixeles (seleccionx, selecciony, tamagnoselx, tamagnosely, distanciax, distanciay)
    }
    private Image imagen;//variable con la imagen a mostrar
}

class LaminaEventos extends JPanel implements ActionListener{//implementa lo necesario para que escuche eventos (no es necesario que el ActionListener y el JPanel sean la misma clase, se puede separar)
    JButton boton = new JButton("clica");//un boton que hace eventos
    JButton boton2 = new JButton("clica2");
    JTextField cuadroTexto = new JTextField();//cuadro para escribir texto

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setLayout(null);//en caso de que sea necesario, desactivar que los elementos se coloquen automaticamente
        cuadroTexto.setBounds(10,40,150,20);
    }
    public LaminaEventos(){
        add(boton);
        boton.addActionListener(this);//especificando que hace eventos, diciendo this hara la funcion actionPerformed de esta clase que implementa ActionListener (recibe un objeto que implemente AtionListener)
        add(boton2);boton2.addActionListener(this);
        add(cuadroTexto); cuadroTexto.addFocusListener(new EventoFoco());//aplicanto el listener de foco
    }
    public void actionPerformed(ActionEvent e){//funcion que se ejecuta al hacer un evento sobre esta clase
        if(e.getSource()==boton){//comprobar de donde vino el evento
            setBackground(Color.black);
        }
    }
    private class EventoFoco implements FocusListener{//para escuchar el foco sobre elementos (tab o click) (es una clase interna para que pueda acceder a las propiedades de aqui)
        public void focusGained(FocusEvent e){//tiene el foco
            //System.out.println("seleccionado");
        }
        public void focusLost(FocusEvent e){//pierde el foco
            if(e.getSource() == cuadroTexto){//devuelve el elemento que hizo el evento
                //System.out.println("deseleccionado " + cuadroTexto.getText());
            }  
        }
    }
}
class MVentana extends WindowAdapter{//clase listener con lo que puede escuchar una ventana (es una clase adaptadora)
    public void windowActivated(WindowEvent e){System.out.println("ventana activada");}//cada evento que puede hacer una ventana, no hace falta ponerlos todos
    public void windowClosed(WindowEvent e){} public void windowClosing(WindowEvent e){}public void windowDeactivated(WindowEvent e){}public void windowDeiconified(WindowEvent e){}public void windowIconified(WindowEvent e){}public void windowOpened(WindowEvent e){}
}
class MVentanaEstado implements WindowStateListener{//otra forma para ver los cambios de estado de ventana (alternativa a la de arriba)
    public void windowStateChanged(WindowEvent e){//cada vez que cambie algo
        //System.out.println("ventana cambia de estado" + e.getOldState() + "  " + e.getNewState());//devuelven un numero dependiendo del estado de la ventana antes y despues
    }
}

class EventoTeclado implements KeyListener{//para escuchar los eventos de teclado (es necesario que el JPanel con este listener este vacio, se recomienda hacer uno aparte) (se puede hacer extends KeyAdapter para no tener que sobreescribir todos los metodos)
    public void keyPressed(KeyEvent e){
        //System.out.println("se presiono la tecla con el codigo " + e.getKeyCode());//cada tecla con su codigo
    }
    public void keyReleased(KeyEvent e){
        //System.out.println("se solto la tecla con el codigo " + e.getKeyCode());
    }
    public void keyTyped(KeyEvent e){
        //System.out.println("se uso la tecla con el codigo " + e.getKeyCode() + " que es la letra " + e.getKeyChar());//getKeyChar devuelve la letra de la tecla en caso de que tenga
    }
}
class EventoRaton implements MouseListener{//para escuchar los eventos de raton (se puede hacer extends MouseAdapter para no tener que sobreescribir todos los metodos)
    public void mouseClicked(MouseEvent e){
        //System.out.println("se presiono el raton sobre el elemento");
        //System.out.println("x" + e.getX() + " y" + e.getY());//coordenadas del raton en el momento (relativo al componente/panel)
        //System.out.println(e.getClickCount());//cuantos clicks se hacen en x tiempo (tiempo diefinido por el sistema operativo)
    }
    public void mouseEntered(MouseEvent e){
        //System.out.println("el raton entro al elemento");
    }
    public void mouseExited(MouseEvent e){
        //System.out.println("el raton salio del elemento");
    }
    public void mousePressed(MouseEvent e){
        //System.out.println("click presionado");
        //System.out.println("el boton del raton es el " + e.getModifiersEx());//devuelve que boton del raton se presiono con un numero (mirar docs para ver cual es cual)
    }
    public void mouseReleased(MouseEvent e){
        //System.out.println("click soltado");
    }
}
class EventoMovimientoRaton implements MouseMotionListener{//similar a MouseListener pero para movimiento
    public void mouseDragged(MouseEvent e){//mover el raton con el click presionado
        //System.out.println("arrastrando x" + e.getX() + " y" + e.getY());
    }
    public void mouseMoved(MouseEvent e){//mover el raton
        //System.out.println("x" + e.getX() + " y" + e.getY());
    }  
}
class OtraVentana extends JFrame implements WindowFocusListener{//cuando una ventana implementa esto escuchara eventos de focus de ventana
    public void windowGainedFocus(WindowEvent e){
        //System.out.println("ventana en primer plano");
    }
    public void windowLostFocus(WindowEvent e){
        //System.out.println("ventana en segundo plano");
    }
    public OtraVentana(){
        setBounds(300,100,200,200);
        addWindowFocusListener(this);//aplicar este WindowFocusListener (la propia clase del JFrame ya lo implementa)
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        UnaVentana ventana = new UnaVentana();//abrir una ventana ya especificada en una clase
        ventana.setVisible(true);//hacerla visible (esto se puede poner en el constructor)
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//especifica que hacer al cerrar la ventana, en este caso cierra el programa (ventana principal) (HIDE_ON_CLOSE/DISPOSE_ON_CLOSE para ventanas secundarias) (esto se puede poner en el constructor)
        //OtraVentana ventana2 = new OtraVentana(); ventana2.setVisible(true);
    }
}