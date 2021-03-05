package ft.view;

import ft.controller.Controller;
import ft.domain.ThemeColor;
import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewBase extends JFrame {

    public JPanel panelBarraTitulo, panelBarraLateral, panelCentral, contentPane;
    public JLabel titulo;
    public JButton minimizar, maximizar, cerrar;
    public ThemeColor color;
    public Controller controlador;
    private int ventana_x, ventana_y;

    public ViewBase() {
        controlador = new Controller();
        this.color = Controller.colorParaUsar;

        setBounds(0, 0, 400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        contentPane = new JPanel();
        contentPane.setBackground(this.color.getColorFondo());
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        contentPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point ubi = MouseInfo.getPointerInfo().getLocation();
                setLocation(ubi.x - ventana_x, ubi.y - ventana_y);
            }
        });
        //agrega evento para arrstra la ventana
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ventana_x = e.getX();
                ventana_y = e.getY();
            }
        });

        initBarraTitulo();
    }

    public void initBarraTitulo() {

        panelBarraTitulo = new JPanel();
        panelBarraTitulo.setLayout(null);
        panelBarraTitulo.setBounds(0, 0, 400, 80);
        panelBarraTitulo.setBackground(color.getColorBarra());
        contentPane.add(panelBarraTitulo, BorderLayout.NORTH);

        titulo = new JLabel("Notas");
        titulo.setBounds(0, 0, 310, 100);
        panelBarraTitulo.add(titulo);

        minimizar = new JButton(new ImageIcon("config\\iconos\\minimizar.png"));
        minimizar.setBackground(color.getColorBarra());
        minimizar.setSize(30, 100);
        panelBarraTitulo.add(minimizar);

        maximizar = new JButton(new ImageIcon("config\\iconos\\maximizar.png"));
        maximizar.setBackground(color.getColorBarra());
        panelBarraTitulo.add(maximizar);

        cerrar = new JButton(new ImageIcon("config\\iconos\\cerrar.png"));
        cerrar.setBackground(color.getColorBarra());
        panelBarraTitulo.add(cerrar);

    }

    public void initBarraLateral() {

    }

    public void initPanel() {

    }
}
