import java.awt.*;
import javax.swing.*;//Libreria con las cosas de la interfaz, tambien usa java.awt
import java.awt.event.*;//Para los eventos de componentes
import java.awt.geom.*;//Ppara figuras con Java2D
import javax.imageio.*;//Para imagenes
import java.io.*;//Para archivos, necesario para las imagenes

class UnaVentana extends JFrame{//Cada ventana debe alojarse en una clase, que herede de JFrame
    public UnaVentana(){//En el constructor se ponen todas las propiedades de la ventana
        //setSize(500,300);//Tamagno de ventana
        //setLocation(100, 100);//Posicion de ventana
        setBounds(500,300,500,500);//Lo mismo, sizex sizey locationx locationy
        setResizable(false);//Si se puede redimensionar
        //setExtendedState(Frame.MAXIMIZED_BOTH);//Hace que este en pantalla completa
        setTitle("titulo");//Titulo de ventana

        Toolkit pantalla = Toolkit.getDefaultToolkit();//Tiene propiedades sobre el sistema grafico
        Dimension tamagnoPantalla = pantalla.getScreenSize();//Devuelve como objeto de Dimension el tamagno de la pantalla
        System.out.println("x " + tamagnoPantalla.width + "  y " + tamagnoPantalla.height);//cada valor por separado (pantalla principal)

        Image icono = pantalla.getImage("media/icono.png");//Guardar una imagen desde ruta relativa (desde fuera de la carpeta src)
        setIconImage(icono);//Establecerlo como icono de ventana


        LaminaDibujo miLamina = new LaminaDibujo();//Instanciar un componente en una ventana (en este caso poniendo el JPanel en el JFrame)
        //add(miLamina);
        miLamina.setBackground(Color.white);//Establece el color de fondo con la clase Color
        miLamina.setForeground(Color.black);//Establece el color principal

        LaminaEventos lamina2 = new LaminaEventos(); add(lamina2);
        addWindowListener(new MVentana());//Usando el listener para eventos de la ventana (hecho mas abajo)
        addWindowStateListener(new MVentanaEstado());//Activando el listener de estados de ventana alternativo (hecho mas abajo)

        addKeyListener(new EventoTeclado());//Usar el listener de eventos de teclado para este componente (hecho mas abajo)
        addMouseListener(new EventoRaton());//Usar el listener de eventos de raton para este componente (hecho mas abajo)
        addMouseMotionListener(new EventoMovimientoRaton());//Lo mismo pero para el motion (hecho mas abajo)
    }
}

class LaminaDibujo extends JPanel{//Es un panel que puede servir para pintar componentes dentro y organizar layout
    public void paintComponent(Graphics g){//Aqui dentro se ponen las cosas a dibujar (esto esta obsoleto, ahora se usa mas el paqueta Java2D)
        super.paintComponent(g);
        /*g.drawString("aaa", 10, 10);//Pintar texto simple (texto, x, y)
        g.drawRect(20, 20, 50, 50);//Dibuja un cuadrado (posx, posy, sizx, sizy)
        g.drawLine(20, 20, 30, 30);//Dibuja una linea (startx, starty, endx, endy)
        g.drawArc(50, 50, 70, 70, 120, 150);//Como la linea pero curva (linea, angulo inicial, angulo final)*/
        Graphics2D g2 = (Graphics2D) g;//Para usar Java2D (lo anterior esta obsoleto)
        Rectangle2D rectangulo = new Rectangle2D.Double(20, 20, 50, 50);//Similar a lo anterior pero los dibujos se almacenan en variables
        g2.draw(rectangulo);//Agregar la forma al panel
        Ellipse2D elipse = new Ellipse2D.Double(20, 20, 50, 50);//Hay muchas formas disponibles
        elipse.setFrame(rectangulo);//Normalmente se pueden copiar los transforms asi, el elipse tendria las mismas dimensiones que el rectangulo
        g2.draw(elipse);
        double centroY = elipse.getCenterY();//Recibiendo propiedades de las formas
        g2.draw(new Line2D.Double(20,20,50,50));//Se puede instanciar directamente en draw()
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(10, centroY, 20, centroY + 10);//Lo mismo pero poniendolo desde el centro
        g2.setPaint(Color.red);//Pone un color para pintar las siguientes formas (de la clase color, new Color(r,g,b) para color especifico)
        g2.fill(circulo);//Igual que draw, pero el interior se pinta con el color seleccionado con setPaint()
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();//Todas las fuentes disponibles en el sistema
        Font fuente = new Font("Arial", Font.BOLD, 26);//Guarda una fuente apartir de un nombre (debe estar instalada)
        g2.setFont(fuente);//Selecciona esa fuente
        g2.drawString("fuente", 60, 60);
        

        try{imagen = ImageIO.read(new File("media/icono.png"));}//Pone el contenido de la imagen en la variable
        catch(IOException e){System.out.println("error");}
        g.drawImage(imagen, 80, 0, null);//Pintar la imagen
        System.out.println(imagen.getHeight(this));//Altura de la imagen, getWidth para ancho
        g.copyArea(80, 0, 64, 64, 40, 0);//Copiar pixeles (seleccionx, selecciony, tamagnoselx, tamagnosely, distanciax, distanciay)
    }
    private Image imagen;//Variable con la imagen a mostrar
}

class LaminaEventos extends JPanel implements ActionListener{//Implementa lo necesario para que escuche eventos (no es necesario que el ActionListener y el JPanel sean la misma clase, se puede separar)
    JButton boton = new JButton("clica");//Un boton que hace eventos
    JButton boton2 = new JButton("clica2");
    JTextField cuadroTexto = new JTextField();//Cuadro para escribir texto

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setLayout(null);//En caso de que sea necesario, desactivar que los elementos se coloquen automaticamente
        cuadroTexto.setBounds(10,40,150,20);
    }
    public LaminaEventos(){
        add(boton);
        boton.addActionListener(this);//Especificando que hace eventos, diciendo this hara la funcion actionPerformed de esta clase que implementa ActionListener (recibe un objeto que implemente AtionListener)
        add(boton2);boton2.addActionListener(this);
        add(cuadroTexto); cuadroTexto.addFocusListener(new EventoFoco());//Aplicanto el listener de foco
    }
    public void actionPerformed(ActionEvent e){//Funcion que se ejecuta al hacer un evento sobre esta clase
        if(e.getSource()==boton){//Comprobar de donde vino el evento
            setBackground(Color.black);
        }
    }
    private class EventoFoco implements FocusListener{//Para escuchar el foco sobre elementos (tab o click) (es una clase interna para que pueda acceder a las propiedades de aqui)
        public void focusGained(FocusEvent e){//Tiene el foco
            //System.out.println("seleccionado");
        }
        public void focusLost(FocusEvent e){//Pierde el foco
            if(e.getSource() == cuadroTexto){//Devuelve el elemento que hizo el evento
                //System.out.println("deseleccionado " + cuadroTexto.getText());
            }  
        }
    }
}
class MVentana extends WindowAdapter{//Clase listener con lo que puede escuchar una ventana (es una clase adaptadora)
    public void windowActivated(WindowEvent e){System.out.println("ventana activada");}//Cada evento que puede hacer una ventana, no hace falta ponerlos todos
    public void windowClosed(WindowEvent e){} public void windowClosing(WindowEvent e){}public void windowDeactivated(WindowEvent e){}public void windowDeiconified(WindowEvent e){}public void windowIconified(WindowEvent e){}public void windowOpened(WindowEvent e){}
}
class MVentanaEstado implements WindowStateListener{//Otra forma para ver los cambios de estado de ventana (alternativa a la de arriba)
    public void windowStateChanged(WindowEvent e){//Cada vez que cambie algo
        //System.out.println("ventana cambia de estado" + e.getOldState() + "  " + e.getNewState());//Devuelven un numero dependiendo del estado de la ventana antes y despues
    }
}

class EventoTeclado implements KeyListener{//Para escuchar los eventos de teclado (es necesario que el JPanel con este listener este vacio, se recomienda hacer uno aparte) (se puede hacer extends KeyAdapter para no tener que sobreescribir todos los metodos)
    public void keyPressed(KeyEvent e){
        //System.out.println("se presiono la tecla con el codigo " + e.getKeyCode());//Cada tecla con su codigo
    }
    public void keyReleased(KeyEvent e){
        //System.out.println("se solto la tecla con el codigo " + e.getKeyCode());
    }
    public void keyTyped(KeyEvent e){
        //System.out.println("se uso la tecla con el codigo " + e.getKeyCode() + " que es la letra " + e.getKeyChar());//getKeyChar devuelve la letra de la tecla en caso de que tenga
    }
}
class EventoRaton implements MouseListener{//Para escuchar los eventos de raton (se puede hacer extends MouseAdapter para no tener que sobreescribir todos los metodos)
    public void mouseClicked(MouseEvent e){
        //System.out.println("se presiono el raton sobre el elemento");
        //System.out.println("x" + e.getX() + " y" + e.getY());//Coordenadas del raton en el momento (relativo al componente/panel)
        //System.out.println(e.getClickCount());//Cuantos clicks se hacen en x tiempo (tiempo diefinido por el sistema operativo)
    }
    public void mouseEntered(MouseEvent e){
        //System.out.println("el raton entro al elemento");
    }
    public void mouseExited(MouseEvent e){
        //System.out.println("el raton salio del elemento");
    }
    public void mousePressed(MouseEvent e){
        //System.out.println("click presionado");
        //System.out.println("el boton del raton es el " + e.getModifiersEx());//Devuelve que boton del raton se presiono con un numero (mirar docs para ver cual es cual)
    }
    public void mouseReleased(MouseEvent e){
        //System.out.println("click soltado");
    }
}
class EventoMovimientoRaton implements MouseMotionListener{//Similar a MouseListener pero para movimiento
    public void mouseDragged(MouseEvent e){//Mover el raton con el click presionado
        //System.out.println("arrastrando x" + e.getX() + " y" + e.getY());
    }
    public void mouseMoved(MouseEvent e){//mover el raton
        //System.out.println("x" + e.getX() + " y" + e.getY());
    }  
}
class OtraVentana extends JFrame implements WindowFocusListener{//Cuando una ventana implementa esto escuchara eventos de focus de ventana
    public void windowGainedFocus(WindowEvent e){
        //System.out.println("ventana en primer plano");
    }
    public void windowLostFocus(WindowEvent e){
        //System.out.println("ventana en segundo plano");
    }
    public OtraVentana(){
        setBounds(300,100,200,200);
        addWindowFocusListener(this);//Aplicar este WindowFocusListener (la propia clase del JFrame ya lo implementa)
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        UnaVentana ventana = new UnaVentana();//Abrir una ventana ya especificada en una clase
        ventana.setVisible(true);//Hacerla visible (esto se puede poner en el constructor)
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//especifica que hacer al cerrar la ventana, en este caso cierra el programa (ventana principal) (HIDE_ON_CLOSE/DISPOSE_ON_CLOSE para ventanas secundarias) (esto se puede poner en el constructor)
        //OtraVentana ventana2 = new OtraVentana(); ventana2.setVisible(true);
    }
}
