package programa1tayda;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Inter {
    
    XYSeries series = new XYSeries("Insercion");
    
    XYSeriesCollection dataset =new XYSeriesCollection();
    
    JFreeChart grafica=ChartFactory.createXYLineChart("Grafica Datos X Tiempo", "Tiempo de ejecucion", "Cantidad de Datos", dataset, PlotOrientation.VERTICAL, true, true, true);
    
    public void agregargraf(String id,double []x,double y[]){
        XYSeries s= new XYSeries(id);
        int n=x.length;
        for(int i=0;i<n;i++){
            s.add(x[i], y[i]);
        }
        dataset.addSeries(s);
    }
    public JPanel panel(){
        return new ChartPanel(grafica);
    }
    
}