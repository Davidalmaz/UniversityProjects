import java.awt.Color;
import java.awt.BasicStroke;
import java.io.*;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartUtilities; 

public class XYLineChart_AWT extends ApplicationFrame {
    
    private JFreeChart xylineChart;
    
    public XYLineChart_AWT( String applicationTitle, String chartTitle, int[] n, double[][] time ) {
      super(applicationTitle);
         xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "n" ,
         "Tiempo (ms)" ,
         createDataset(n, time) ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 400 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.GREEN );
      renderer.setSeriesPaint( 2 , Color.YELLOW );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
      
      int width = 600;   /* Width of the image */
      int height = 400;  /* Height of the image */ 
      File XYChart = new File( "XYLineChart.jpeg" ); 
      try {
          ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
      } catch (IOException ie) {
          ie.printStackTrace();
      }
      
    }
    
    public XYDataset createDataset( int[] n, double[][] time) {
      /*final XYSeries chrome = new XYSeries( "Chrome" );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.0 , 5.0 );          
      chrome.add( 3.0 , 6.0 );    */   
      
      final XYSeries heap = new XYSeries( "Heapsort" ),
              selection = new XYSeries( "Selection" );   
          
      
      for (int i = 0; i < n.length; ++i) {
          selection.add(n[i], time[0][i]);
          heap.add(n[i], time[1][i]);
      }
          
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( selection );      
      dataset.addSeries( heap );  
      return dataset;
   }

    /*public static void main(String[] args) {
       final int max = 1000;
       int[] elements = new int[max];
       //double[] x = increment(-2*Math.PI, 0.2, 2 * Math.PI);
       int[] n = {125, 250, 500, 1000, 2000};
       double[] timeArray = {2.7, 10.8, 43.1, 172.4, 689.6};
 
       fill(elements, max, true);
       
       tiempo_ini = System.nanoTime();
       SelectionSort(elements);
       tiempo_fin = System.nanoTime();
       long time = tiempo_fin - tiempo_ini;
		
       System.out.println("Tiempo transcurrido: " + time + "ns (" + nsToSeg(time) + " seg)");
       
       XYLineChart_AWT chart = new XYLineChart_AWT("Algorithms benchmark",
         "3DMark11", n, timeArray);
       chart.pack( );          
       RefineryUtilities.centerFrameOnScreen( chart );          
       chart.setVisible( true ); 
       
    }*/
    
}
