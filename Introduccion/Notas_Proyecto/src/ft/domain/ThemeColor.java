package ft.domain;

import java.awt.Color;
import java.util.HashSet;

public class ThemeColor {
    private Color ColorFondo;
    private Color colorBarra;
    
    public ThemeColor(Color colorFondo, Color colorBarra){
        this.ColorFondo = colorFondo;
        this.colorBarra = colorBarra; 
    }

    public Color getColorFondo() {
        return ColorFondo;
    }

    public void setColorFondo(Color ColorFondo) {
        this.ColorFondo = ColorFondo;
    }

    public Color getColorBarra() {
        return colorBarra;
    }

    public void setColorBarra(Color colorBarra) {
        this.colorBarra = colorBarra;
    }
    
    public String toString(){
        return "\nColorFondo: "+this.ColorFondo.getRed()+","+this.ColorFondo.getGreen()+","+this.ColorFondo.getBlue()+",\n"
                +"ColorBarra: "+this.colorBarra.getRed()+","+this.colorBarra.getGreen()+","+this.colorBarra.getBlue()+",\n";
    }
    
}
