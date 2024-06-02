
package Programa2TAYDA;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;


public class Baldosas extends JPanel{
        char  color;
    public Baldosas(char  color){
        this.color=color;
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

            if(color=='B'){
                g.setColor(Color.WHITE);
            }
            if(color=='G'){
                g.setColor(Color.GRAY);
            }
            if(color=='N'){
                g.setColor(Color.BLACK);
            }
            g.fillRect(0,0,10,10);
        
        
    }
    
}
