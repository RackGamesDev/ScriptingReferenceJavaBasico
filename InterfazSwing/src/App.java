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
        MVentana oyenteVentana = new MVentana();  addWindowListener(oyenteVentana);//usando el listener para eventos de la ventana (hecho mas abajo)
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

    public LaminaEventos(){
        add(boton);
        boton.addActionListener(this);//especificando que hace eventos, diciendo this hara la funcion actionPerformed de esta clase que implementa ActionListener (recibe un objeto que implemente AtionListener)
        add(boton2);boton2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){//funcion que se ejecuta al hacer un evento sobre esta clase
        if(e.getSource()==boton){//comprobar de donde vino el evento
            setBackground(Color.black);
        }
    }
}
class MVentana implements WindowListener{//clase listener con lo que puede escuchar una ventana
    public void windowActivated(WindowEvent e){System.out.println("ventana activada");}//cada evento que puede hacer una ventana
    public void windowClosed(WindowEvent e){} public void windowClosing(WindowEvent e){}public void windowDeactivated(WindowEvent e){}public void windowDeiconified(WindowEvent e){}public void windowIconified(WindowEvent e){}public void windowOpened(WindowEvent e){}
}


public class App {
    public static void main(String[] args) throws Exception {
        UnaVentana ventana = new UnaVentana();//abrir una ventana ya especificada en una clase
        ventana.setVisible(true);//hacerla visible (esto se puede poner en el constructor)
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//especifica que hacer al cerrar la ventana, en este caso cierra el programa (ventana principal) (HIDE_ON_CLOSE/DISPOSE_ON_CLOSE para ventanas secundarias) (esto se puede poner en el constructor)

    }
}