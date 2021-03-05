
package pruebasjframe;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebasJFrame extends JFrame{
    JPanel contentPane, panelUno, panelDos;
    
    public PruebasJFrame(){
        setBounds(0,0,200,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initComponents();
    }
    
    public void initComponents(){
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0,255,0));
        contentPane.setBounds(10,80,150,250);
        
        panelUno = new JPanel();
        panelUno.setBackground(new Color(0,0,255));
        panelUno.setBounds(10,80,150,250);
        
        panelDos = new JPanel();
        panelDos.setBackground(new Color(255,0,0));
        panelDos.setBounds(10,80,150,250);
        
        setContentPane(contentPane);
        contentPane = panelUno;
        setContentPane(contentPane);
    }
    public static void main(String[] args) {
        PruebasJFrame pjf = new PruebasJFrame();
        pjf.setVisible(true);
    }
    
}
