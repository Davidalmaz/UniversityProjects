package rascacielos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graficar extends JPanel {
    private ArrayList<Silueta> siluetas;
    private ArrayList<Rascacielo> rascacielos;
    private ArrayList<Point2D.Float> rascacieloCoords = new ArrayList<>();
    private ArrayList<Point2D.Float> siluetasCoords = new ArrayList<>();
    
    private final static short  BASE_X_BEGIN = 0,
                                BASE_X_END = 900,
                                BASE_Y1 = 210,
                                BASE_Y2 = 420,
                                MULTIPLIER_X = 20,
                                MULTIPLIER_Y = 30;
    
    public Graficar(final Centro centro) {
        this.siluetas = centro.getSiluetas();
        this.rascacielos = centro.getRascacielos();
        convertirAPuntosPantalla();
    }
    
    public void convertirAPuntosPantalla() {
        for(short i = 0, size = (short)rascacielos.size(); i < size; ++i) {
        	rascacieloCoords.add(
        			new Point2D.Float(
        					(short) (rascacielos.get(i).getIzq() * MULTIPLIER_X), 
        					BASE_Y1
        					)
        			);
        	
        	rascacieloCoords.add(
        			new Point2D.Float(
        					(short) (rascacielos.get(i).getIzq() * MULTIPLIER_X), 
        					 (short) (BASE_Y1 - (MULTIPLIER_Y * rascacielos.get(i).getAlt()))
        					)
        			);
        	rascacieloCoords.add(
        			new Point2D.Float(
        					(short) (rascacielos.get(i).getDer() * MULTIPLIER_X), 
        					(short) (BASE_Y1 - (MULTIPLIER_Y * rascacielos.get(i).getAlt()))
        					)
        			);
        	rascacieloCoords.add(
        			new Point2D.Float(
        					(short) (rascacielos.get(i).getDer() * MULTIPLIER_X), 
        					BASE_Y1
        					)
        			);
        }
        
        siluetasCoords.add(
        		new Point2D.Float(
        				(short) (siluetas.get(0).getHor() * MULTIPLIER_X), 
        				BASE_Y2
        				)
        		);
        
        for(short i = 1, size = (short)siluetas.size(); i < size; ++i) {
            short altura = (short) (BASE_Y2 - (MULTIPLIER_Y * siluetas.get(i - 1).getVer()));
        	siluetasCoords.add(
        			new Point2D.Float(
        					(short) (siluetas.get(i - 1).getHor() * MULTIPLIER_X), 
        					altura
        					)
        			);
                siluetasCoords.add(
                                new Point2D.Float(
        					(short) (siluetas.get(i).getHor() * MULTIPLIER_X), 
        					altura
        					)
                                );
        }
        siluetasCoords.add(
        		new Point2D.Float(
        				(short) (siluetas.get(siluetas.size() - 1).getHor() * MULTIPLIER_X), 
        				BASE_Y2
        				)
        		);
    }
    
    private void graficarLineas(Graphics2D g) {
    	for(short i = 1, size = (short)rascacieloCoords.size(); i < size; ++i) {
            Point2D p2 = rascacieloCoords.get(i);
            Point2D p = rascacieloCoords.get(i - 1);
            g.draw(new Line2D.Float(p, p2));
        }
        
        for(short i = 1, size = (short)siluetasCoords.size(); i < size; ++i) {
            Point2D p2 = siluetasCoords.get(i);
            Point2D p = siluetasCoords.get(i - 1);
            g.draw(new Line2D.Float(p, p2));
        }
    }
    
    public void paintComponent(Graphics g) {
        
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.red);
    
    //Big Line
    g2d.draw(new Line2D.Double(BASE_X_BEGIN, BASE_Y1, BASE_X_END, BASE_Y1));
    g2d.draw(new Line2D.Double(BASE_X_BEGIN, BASE_Y2, BASE_X_END, BASE_Y2));
    
    graficarLineas(g2d);
    
    /*g2d.draw(new Line2D.Double(2, BASE_Y, 2, BASE_Y - (MULTIPLIER_Y * 6)));
    g2d.draw(new Line2D.Double(2, BASE_Y - (6 * MULTIPLIER_Y), 7 * MULTIPLIER_X, BASE_Y - (6 *MULTIPLIER_Y)));
    g2d.draw(new Line2D.Double(7 * MULTIPLIER_X, BASE_Y - (MULTIPLIER_Y * 6), 7 * MULTIPLIER_X, BASE_Y));*/

    

    /*for (int i = 0; i <= 100000; i++) {
      Dimension size = getSize();
      int w = size.width ;
      int h = size.height;

      Random r = new Random();
      int x = Math.abs(r.nextInt()) % w;
      int y = Math.abs(r.nextInt()) % h;
      g2d.drawLine(x, y, x, y);
    }*/
    
  }
}
