package Programa2TAYDA;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class Mostrar extends javax.swing.JFrame{
      
    public Mostrar(char [] caminito){
        super("Mostrar");
        setSize(250,100);
        FlowLayout fl=new FlowLayout(3,3,10);
        setLayout(fl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(char baldosa:caminito){
           add(new Baldosas(baldosa));
        }
        
            
        
        
    }
    
}
