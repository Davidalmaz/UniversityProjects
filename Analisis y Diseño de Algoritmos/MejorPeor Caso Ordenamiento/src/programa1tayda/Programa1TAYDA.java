package programa1tayda;

import static java.lang.Math.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.util.Random;
import java.util.Scanner;


public class Programa1TAYDA extends JFrame{
    public Programa1TAYDA(double [] tiempo,double [] cantidad,String titulo){
        Inter migrafica=new Inter();
        double [] y=tiempo;
        double [] x=cantidad;
        migrafica.agregargraf(titulo, x, y);
        JPanel panel=migrafica.panel();
        this.setSize(650,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
    
    public static int leer(){
        Scanner leer=new Scanner(System.in);
        return leer.nextInt();
    }
    
    public static void main(String [] args){
        double Tini,Tfin,tiempo1[],tiempo2[],tiempo3[];
        tiempo1=new double[10];
        tiempo2=new double[10];
        tiempo3=new double[10];
        Random num=new Random();
        Metodos orden=new Metodos();
        double datos[]=new double[128000];
        double [] cantidad=new double[10];
        cantidad[0]=250;
        int op=0;
        System.out.println("INGRESE EL MÉTODO QUE DESEA CONSULTAR");
        while(op!=4){
        System.out.println("1-INSERCIÓN");
        System.out.println("2-SELECCIÓN");
        System.out.println("3-BURBUJA");
        System.out.println("4-SALIR");
        op=leer();
        switch(op){
            case 1:
                //System.out.println("Mejor caso");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.insercion(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.insercion(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo1[i]=Tfin-Tini;
                    //System.out.println(tiempo1[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo1,cantidad,"Insercion Mejor Caso");
                //System.out.println("Peor caso");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.selecciond(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.insercion(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo2[i]=Tfin-Tini;
                    //System.out.println(tiempo2[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo2,cantidad,"Insercion Peor Caso");
                
                //System.out.println("Caso Promedio");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.insercionp(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.insercion(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo3[i]=Tfin-Tini;
                    //System.out.println(tiempo3[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo3,cantidad,"Insercion Caso Promedio");
                
            break;
            
            case 2:
                //System.out.println("Mejor caso");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.insercion(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.seleccion(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo1[i]=Tfin-Tini;
                    //System.out.println(tiempo1[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo1,cantidad,"Seleccion Mejor Caso");
                //System.out.println("Peor caso");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.selecciond(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.seleccion(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo2[i]=Tfin-Tini;
                    //System.out.println(tiempo2[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo2,cantidad,"Seleccion Peor Caso");
                
                //System.out.println("Caso Promedio");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.insercionp(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.seleccion(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo3[i]=Tfin-Tini;
                    //System.out.println(tiempo3[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo3,cantidad,"Seleccion Caso Promedio");
                
            break;
            
            case 3:
                //System.out.println("Mejor caso");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.insercion(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.burbuja(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo1[i]=Tfin-Tini;
                    //System.out.println(tiempo1[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo1,cantidad,"Burbuja Mejor Caso");
                //System.out.println("Peor caso");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.selecciond(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.burbuja(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo2[i]=Tfin-Tini;
                    //System.out.println(tiempo2[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo2,cantidad,"Burbuja Peor Caso");
                
                //System.out.println("Caso Promedio");
                for(int i=0;i<10;i++){
                    for(int j=0;j<cantidad[0];j++){
                        datos[j]=num.nextDouble();
                    }
                    datos=orden.insercionp(datos,cantidad[i]);
                    Tini=System.currentTimeMillis();
                    datos=orden.burbuja(datos,cantidad[i]);
                    Tfin=System.currentTimeMillis();
                    tiempo3[i]=Tfin-Tini;
                    //System.out.println(tiempo3[i]);
                    if(i<9){
                      cantidad[i+1]=cantidad[i]*2;
                    }
                }
                new Programa1TAYDA(tiempo3,cantidad,"Burbuja Caso Promedio");
                
            break;
            case 4:
                break;
            default:
                System.out.println("Por favor ingrese uno de los valor válido");
                break;
        };
    }
        
        
    }
}
