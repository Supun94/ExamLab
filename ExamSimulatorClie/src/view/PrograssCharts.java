/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connector.ServerConnector;
import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exam;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Supun
 */
public class PrograssCharts extends javax.swing.JDialog {

    /**
     * Creates new form PrograssCharts
     */
    public PrograssCharts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            setSize(1400, 800);
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                loading1();
                loading2();
                run();
                
            }
        }).start();
            
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
            dataset.setValue(QuestionLab.cat1, "gfdg", "Collectns");
            dataset.setValue(QuestionLab.cat2, "gfdg", "Data");
            dataset.setValue(QuestionLab.cat3, "gfdg", "Dev");
            dataset.setValue(QuestionLab.cat4, "gfdg", "Excep");
            dataset.setValue(QuestionLab.cat5, "gfdg", "File");
            dataset.setValue(QuestionLab.cat6, "gfdg", "FlowCon");
            dataset.setValue(QuestionLab.cat7, "gfdg", "Format");
            dataset.setValue(QuestionLab.cat8, "gfdg", "GC");
            dataset.setValue(QuestionLab.cat9, "gfdg", "IC");
            dataset.setValue(QuestionLab.cat10, "gfdg", "VarArgs");
            dataset.setValue(QuestionLab.cat11, "gfdg", "Fundamt");
            dataset.setValue(QuestionLab.cat12, "gfdg", "Modif");
            dataset.setValue(QuestionLab.cat13, "gfdg", "OOP");
            dataset.setValue(QuestionLab.cat14, "gfdg", "Vari");
            dataset.setValue(QuestionLab.cat15, "gfdg", "String");
            dataset.setValue(QuestionLab.cat16, "gfdg", "Threads");
            dataset.setValue(QuestionLab.cat17, "gfdg", "WC");
            JFreeChart freeChart = ChartFactory.createBarChart("Exam Prograss by Subjects", "Subject", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
            //JFreeChart freeChart1 = ChartFactory.createBarChart("Income", " Name", "Incomesss", dataset1, PlotOrientation.VERTICAL, false, true, false);
            TimeSeries pop = new TimeSeries("Population", Day.class);

            //JFreeChart chart=ChartFactory.create
            CategoryPlot plot = freeChart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLUE);
            ChartFrame frame = new ChartFrame("Exam Prograss", freeChart);

//        frame.setVisible(true);
//        frame.setSize(550, 450);
            // JPanel jPanel1 = new JPanel();
            jPanel1.setLayout(new java.awt.BorderLayout());

            ChartPanel CP = new ChartPanel(freeChart);
            CP.setPreferredSize(new Dimension(785, 440));
            CP.setMouseWheelEnabled(true);

            jPanel1.add(CP);
            jPanel1.revalidate();

            ArrayList<Exam> setChartValue = ServerConnector.getServerConnector().getExamController().getPreviousMarks(PracticeExamLogIn.studentNic);
            for (Exam exam : setChartValue) {
                //dataset1.setValue(exam.getMarks(), "gfdg9", exam.getDate());
                pop.addOrUpdate(new Day(exam.getDate()), exam.getMarks());
                System.out.println("mar" + exam.getMarks());
                System.out.println("date" + exam.getDate());
            }
            TimeSeriesCollection myDataset = new TimeSeriesCollection();
            myDataset.addSeries(pop);
            JFreeChart myChart = ChartFactory.createTimeSeriesChart(
                    "Population Your Marks",
                    "Date",
                    "Population",
                    myDataset,
                    true,
                    true,
                    false);
//try {
//ChartUtilities.saveChartAsJPEG(new File("C:\\chart.jpg"), chart, 500, 300);
//} catch (IOException e) {
//System.err.println("Problem occurred creating chart.");
//}

            //JFreeChart chart=ChartFactory.create
            CategoryPlot plot1 = freeChart.getCategoryPlot();
            plot1.setRangeGridlinePaint(Color.BLUE);
            //ChartFrame frame1 = new ChartFrame("Exam Prograss", freeChart1);

//        frame.setVisible(true);
//        frame.setSize(550, 450);
            // JPanel jPanel1 = new JPanel();
            jPanel2.setLayout(new java.awt.BorderLayout());

            ChartPanel CP1 = new ChartPanel(myChart);
            CP1.setPreferredSize(new Dimension(785, 440));
            CP1.setMouseWheelEnabled(true);

            jPanel2.add(CP1);
            jPanel2.revalidate();

        } catch (RemoteException | ClassNotFoundException | SQLException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(PrograssCharts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -1, 1290, 710);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1290, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrograssCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrograssCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrograssCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrograssCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrograssCharts dialog = new PrograssCharts(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

void loading1(){
        try {
            jPanel1.setVisible(true);
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
              Logger.getLogger(PrograssCharts.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel1.setVisible(false);
    }
    
    void loading2(){
        try {
          jPanel2.setVisible(true);
            Thread.sleep(5000);            
        } catch (InterruptedException ex) {
            Logger.getLogger(PrograssCharts.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel2.setVisible(false);
    }




}
