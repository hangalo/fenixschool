/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixschool.mb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author PENA
 */
@ManagedBean(name = "grafico")
@ViewScoped
public class Grafico implements Serializable{

    private static final long serialVersionUID = 1L;

    private BarChartModel graficoBarra;
    
    public Grafico() {
    }
    
    @PostConstruct 
    public void initialize(){
        barChats();
    }

    public BarChartModel getGraficoBarra() {
        return graficoBarra;
    }

    public void setGraficoBarra(BarChartModel graficoBarra) {
        this.graficoBarra = graficoBarra;
    }
    
     private void barChats() {
        graficoBarra = new BarChartModel();
        ChartSeries rapazes = new BarChartSeries();
        rapazes.setLabel("Rapazes");
        rapazes.set("2013", 150);
        rapazes.set("2014", 50);
        rapazes.set("2015", 80);
        rapazes.set("2016", 120);
        rapazes.set("2017", 107);
        rapazes.set("2018", 102);
        
        ChartSeries raparigas = new BarChartSeries();
        raparigas.setLabel("Raparigas");
        raparigas.set("2013", 180);
        raparigas.set("2014", 100);
        raparigas.set("2015", 150);
        raparigas.set("2016", 130);
        raparigas.set("2017", 110);
        raparigas.set("2018", 200);
        
        graficoBarra.addSeries(rapazes);
        graficoBarra.addSeries(raparigas);
        graficoBarra.setAnimate(true);
        graficoBarra.setShadow(true);
        graficoBarra.isAnimate();
        graficoBarra.isShadow();
        graficoBarra.setMouseoverHighlight(true);
        graficoBarra.isShowPointLabels();
        graficoBarra.setTitle("Gráfico de alunos");
        graficoBarra.setLegendPosition("ne");
        graficoBarra.createAxes();
        graficoBarra.setSeriesColors("337ab7,FF7F24");
        
        Axis posX = graficoBarra.getAxis(AxisType.X);
        posX.setLabel("Géneros");
        
        Axis posY = graficoBarra.getAxis(AxisType.Y);
        posY.setLabel("Total de alunos");
        posY.setMin(0);
        posY.setMax(300);
        
    }
}
