/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import connector.ServerConnector;
import controller.ExamController;
import controller.StudentController;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
//luacando 
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Exam;
import model.Question;
import observer.StudentObserverImpl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import view.forum.ForumMain;

/**
 *
 * @author Supun
 */
public class QuestionLab extends javax.swing.JDialog {

    Set<Integer> listOfRandom = new HashSet<Integer>();
    public static int question;
    Random random = new Random();
    ArrayList<Integer> randomArray = new ArrayList<>();
    ArrayList<Integer> randomArray1 = new ArrayList<>();
    ArrayList<Integer> randomArray2 = new ArrayList<>();
    ArrayList<Integer> randomArray3 = new ArrayList<>();
    ArrayList<Integer> randomArray4 = new ArrayList<>();
    ArrayList<Integer> randomArray5 = new ArrayList<>();
    ArrayList<Integer> randomArray6 = new ArrayList<>();
    ArrayList<Integer> randomArray7 = new ArrayList<>();
    ArrayList<Integer> randomArray8 = new ArrayList<>();
    ArrayList<Integer> randomArray9 = new ArrayList<>();
    ArrayList<Integer> randomArray10 = new ArrayList<>();
    ArrayList<Integer> randomArray11 = new ArrayList<>();
    ArrayList<Integer> randomArray12 = new ArrayList<>();
    ArrayList<Integer> randomArray13 = new ArrayList<>();
    ArrayList<Integer> randomArray14 = new ArrayList<>();
    ArrayList<Integer> randomArray15 = new ArrayList<>();
    ArrayList<Integer> randomArray16 = new ArrayList<>();
    ArrayList<Integer> randomArray17 = new ArrayList<>();
    ArrayList<String> questionArrayList = new ArrayList<>();
    Integer ar[] = new Integer[60];
    int Low = 0;
    int High = 60;
    int x;
    JButton jButton;
    JButton newjButton;
    String actionCommand;
    public int sd = 1;
    private static final String VOICENAME = "kevin16";
    Question q;
    int count = 0;
    int questionNum = 1;
    Voice voice;
    Map<Integer, String> submit = new HashMap<Integer, String>();
    private boolean b;
    static int RESUME;
    public static int secondsLeft = 9000;
    Map<Integer, String> hashMap = new HashMap<Integer, String>();
    static Map<Integer, String> answerMap = new HashMap<Integer, String>();
    Map<Integer, String> newMap = new HashMap<Integer, String>();
    Map<Integer, String> catMap = new HashMap<Integer, String>();
    ArrayList<Integer> catArrayList = new ArrayList<>();
    int questionNum1 = 1;
    int questionNum4 = 1;
    int questionNum5 = 1;
    String questionText;
    JButton buttonArrayList[][];
    StudentObserverImpl studentObserverImpl;
    private int onlineNow;
    String answ;
    int anxCount = 0;
    String correctAnswer;
    StudentController controller;
    int y = 0;
    int catCount = 0;
    String newDate;
    Date date;
    public static int cat1;
    public static int cat2;
    public static int cat3;
    public static int cat4;
    public static int cat5;
    public static int cat6;
    public static int cat7;
    public static int cat8;
    public static int cat9;
    public static int cat10;
    public static int cat11;
    public static int cat12;
    public static int cat13;
    public static int cat14;
    public static int cat15;
    public static int cat16;
    public static int cat17;

    /**
     * Creates new form QuestionLab
     */
    public QuestionLab(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {

            initComponents();
            submitButton.setVisible(false);
            jCheckBox1.setEnabled(false);
            jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);
            jCheckBox7.setEnabled(false);
            jCheckBox8.setEnabled(false);
            jCheckBox9.setEnabled(false);
            jCheckBox10.setEnabled(false);
            submitButton.setEnabled(false);
            backButton.setEnabled(false);
            
            controller = ServerConnector.getServerConnector().getStudentController();
            studentObserverImpl = new StudentObserverImpl(this);
            controller.addObserve(studentObserverImpl);
            //controller.onlineNow();
            //displayMessage(Integer.toString(onlineNow));
            muteButton.setEnabled(false);
            setSize(Toolkit.getDefaultToolkit().getScreenSize());
            UIManager.setLookAndFeel(new GraphiteLookAndFeel());

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            date = new Date();
            System.out.println(dateFormat.format(date));
            newDate = dateFormat.format(date);
            JButton buttonArrayListOne[][] = {
                {jButton1, jButton2, jButton3, jButton4, jButton5},
                {jButton6, jButton7, jButton8, jButton9, jButton10},
                {jButton11, jButton12, jButton13, jButton14, jButton15},
                {jButton16, jButton17, jButton18, jButton19, jButton20},
                {jButton21, jButton22, jButton23, jButton24, jButton25},
                {jButton26, jButton27, jButton28, jButton29, jButton30},
                {jButton31, jButton32, jButton33, jButton34, jButton35},
                {jButton36, jButton37, jButton38, jButton39, jButton40},
                {jButton41, jButton42, jButton43, jButton44, jButton45},
                {jButton46, jButton47, jButton48, jButton49, jButton50},
                {jButton51, jButton52, jButton53, jButton54, jButton55},
                {jButton56, jButton57, jButton58, jButton59, jButton60}

            };

            this.buttonArrayList = buttonArrayListOne;
            System.out.println("MyNIc" + PracticeExamLogIn.studentNic);
            new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int hour = secondsLeft / 3600;
                    int min = secondsLeft / 60 - hour * 60;
                    int second = secondsLeft % 60;

                    if (hour == 0) {
                        int seconds = secondsLeft % 60;

                        jLabel7.setText(Integer.toString(seconds));

                        jLabel8.setText("Minutes");
                        //   jLabel5.setText("Seconds");
                        jLabel6.setText(Integer.toString(min));

                    } else {
                        jLabel6.setText(Integer.toString(hour));
                        jLabel7.setText(Integer.toString(min));
                        jLabel8.setText(Integer.toString(second));

                    }
                    secondsLeft--;
                    if ("0".equals(jLabel6.getText()) && "0".equals(jLabel7.getText())) {
                        //check(); 
                        System.out.println("true");
                    }

                }
            }).start();

            submitTextField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!((c >= 'a') && (c <= 'g')
                            || (c == KeyEvent.VK_SPACE)
                            || (c == KeyEvent.VK_TAB) || (c == KeyEvent.VK_SPACE))) {
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });

            
                    try {

            try {
                Exam exam = new Exam(PracticeExamLogIn.studentNic,date, anxCount);
            //    ExamController examController = ServerConnector.getServerConnector().getExamController();
                try {
                    boolean addMarks = ServerConnector.getServerConnector().getExamController().addMarks(exam);
                   // Exam exam = examController.addMarks(PracticeExamLogIn.studentNic, newDate, anxCount);
                   // if (addMarks) {
                     //   JOptionPane.showMessageDialog(QuestionLab.this, "Student Registered successfully !!");
                     //   this.dispose();
                    //    new LogIn(null, true).setVisible(true);

//                    } else {
//                        JOptionPane.showMessageDialog(QuestionLab.this, "Student Registered failed !!");
//                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NotBoundException | MalformedURLException ex) {
                Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        submitTextField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        readButton = new javax.swing.JButton();
        muteButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        onlineLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton61 = new javax.swing.JButton();
        prograssButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/f2747aa8f47a8041486e155be3b44246.jpg"))); // NOI18N
        jLabel2.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), new java.awt.Color(255, 0, 51)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        textArea.setRows(5);
        textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51)));

        nextButton.setBackground(new java.awt.Color(255, 0, 0));
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(255, 0, 0));
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 0, 0));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox1.setText("A");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox3.setText("B");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox5.setText("C");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox4.setText("D");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox7.setText("E");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox8.setText("F");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox9.setText("G");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jCheckBox10.setText("H");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        submitTextField.setEditable(false);
        submitTextField.setColumns(20);
        submitTextField.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        submitTextField.setForeground(new java.awt.Color(255, 0, 0));
        submitTextField.setRows(5);
        jScrollPane2.setViewportView(submitTextField);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox10))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)))
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox9)
                            .addComponent(jCheckBox10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/prac.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), new java.awt.Color(255, 0, 51)));

        jLabel7.setFont(new java.awt.Font("Adobe Caslon Pro", 1, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));

        jLabel8.setFont(new java.awt.Font("Adobe Caslon Pro", 1, 60)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("Adobe Caslon Pro", 1, 60)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        readButton.setBackground(new java.awt.Color(255, 255, 255));
        readButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/support-icon-contact.png"))); // NOI18N
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        muteButton.setBackground(new java.awt.Color(255, 255, 255));
        muteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shut-up-face-yellow-circle-icon_small.jpg"))); // NOI18N
        muteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton2.setText("2");
        jButton2.setName("2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton4.setText("4");
        jButton4.setName("4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton3.setText("3");
        jButton3.setName("3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton5.setText("5");
        jButton5.setName("5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton1.setText("1");
        jButton1.setName("1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton6.setText("6");
        jButton6.setName("6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton7.setText("7");
        jButton7.setName("7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton8.setText("8");
        jButton8.setName("8"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton9.setText("9");
        jButton9.setName("9"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton10.setText("10");
        jButton10.setName("10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton11.setText("11");
        jButton11.setName("11"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton12.setText("12");
        jButton12.setName("12"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton13.setText("13");
        jButton13.setName("13"); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton14.setText("14");
        jButton14.setName("14"); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton15.setText("15");
        jButton15.setName("15"); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton20.setText("20");
        jButton20.setName("20"); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton16.setText("16");
        jButton16.setName("16"); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton17.setText("17");
        jButton17.setName("17"); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton18.setText("18");
        jButton18.setName("18"); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton19.setText("19");
        jButton19.setName("19"); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton40.setBackground(new java.awt.Color(255, 255, 255));
        jButton40.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton40.setText("40");
        jButton40.setName("40"); // NOI18N
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton21.setText("21");
        jButton21.setToolTipText("");
        jButton21.setName("21"); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(255, 255, 255));
        jButton26.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton26.setText("26");
        jButton26.setName("26"); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(255, 255, 255));
        jButton31.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton31.setText("31");
        jButton31.setName("31"); // NOI18N
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(255, 255, 255));
        jButton36.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton36.setText("36");
        jButton36.setName("36"); // NOI18N
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(255, 255, 255));
        jButton37.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton37.setText("37");
        jButton37.setName("37"); // NOI18N
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(255, 255, 255));
        jButton38.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton38.setText("38");
        jButton38.setAutoscrolls(true);
        jButton38.setName("38"); // NOI18N
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(255, 255, 255));
        jButton39.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton39.setText("39");
        jButton39.setName("39"); // NOI18N
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(255, 255, 255));
        jButton35.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton35.setText("35");
        jButton35.setName("35"); // NOI18N
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 255, 255));
        jButton34.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton34.setText("34");
        jButton34.setName("34"); // NOI18N
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(255, 255, 255));
        jButton33.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton33.setText("33");
        jButton33.setName("33"); // NOI18N
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(255, 255, 255));
        jButton32.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton32.setText("32");
        jButton32.setName("32"); // NOI18N
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(255, 255, 255));
        jButton27.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton27.setText("27");
        jButton27.setName("27"); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(255, 255, 255));
        jButton22.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton22.setText("22");
        jButton22.setName("22"); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton23.setText("23");
        jButton23.setName("23"); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(255, 255, 255));
        jButton28.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton28.setText("28");
        jButton28.setName("28"); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(255, 255, 255));
        jButton24.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton24.setText("24");
        jButton24.setToolTipText("");
        jButton24.setName("24"); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(255, 255, 255));
        jButton29.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton29.setText("29");
        jButton29.setName("29"); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton25.setText("25");
        jButton25.setName("25"); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(255, 255, 255));
        jButton30.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton30.setText("30");
        jButton30.setName("30"); // NOI18N
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton60.setBackground(new java.awt.Color(255, 255, 255));
        jButton60.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton60.setText("60");
        jButton60.setName("60"); // NOI18N
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton41.setText("41");
        jButton41.setName("41"); // NOI18N
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(255, 255, 255));
        jButton46.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton46.setText("46");
        jButton46.setName("46"); // NOI18N
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton51.setBackground(new java.awt.Color(255, 255, 255));
        jButton51.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton51.setText("51");
        jButton51.setName("51"); // NOI18N
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton56.setBackground(new java.awt.Color(255, 255, 255));
        jButton56.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton56.setText("56");
        jButton56.setName("56"); // NOI18N
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setBackground(new java.awt.Color(255, 255, 255));
        jButton57.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton57.setText("57");
        jButton57.setName("57"); // NOI18N
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(255, 255, 255));
        jButton58.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton58.setText("58");
        jButton58.setName("58"); // NOI18N
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton59.setBackground(new java.awt.Color(255, 255, 255));
        jButton59.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton59.setText("59");
        jButton59.setName("59"); // NOI18N
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(255, 255, 255));
        jButton55.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton55.setText("55");
        jButton55.setName("55"); // NOI18N
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(255, 255, 255));
        jButton54.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton54.setText("54");
        jButton54.setName("54"); // NOI18N
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton53.setBackground(new java.awt.Color(255, 255, 255));
        jButton53.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton53.setText("53");
        jButton53.setName("53"); // NOI18N
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton52.setBackground(new java.awt.Color(255, 255, 255));
        jButton52.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton52.setText("52");
        jButton52.setName("52"); // NOI18N
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(255, 255, 255));
        jButton47.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton47.setText("47");
        jButton47.setName("47"); // NOI18N
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(255, 255, 255));
        jButton42.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton42.setText("42");
        jButton42.setName("42"); // NOI18N
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(255, 255, 255));
        jButton43.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton43.setText("43");
        jButton43.setName("43"); // NOI18N
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton48.setBackground(new java.awt.Color(255, 255, 255));
        jButton48.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton48.setText("48");
        jButton48.setName("48"); // NOI18N
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton44.setBackground(new java.awt.Color(255, 255, 255));
        jButton44.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton44.setText("44");
        jButton44.setName("44"); // NOI18N
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton49.setBackground(new java.awt.Color(255, 255, 255));
        jButton49.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton49.setText("49");
        jButton49.setName("49"); // NOI18N
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(255, 255, 255));
        jButton45.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton45.setText("45");
        jButton45.setName("45"); // NOI18N
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton50.setBackground(new java.awt.Color(255, 255, 255));
        jButton50.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jButton50.setText("50");
        jButton50.setName("50"); // NOI18N
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        onlineLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Minion Pro SmBd", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Online Now");

        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ocp.gif"))); // NOI18N
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jButton61.setBorder(dropShadowBorder1);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        prograssButton.setBackground(new java.awt.Color(255, 0, 0));
        prograssButton.setForeground(new java.awt.Color(255, 255, 255));
        prograssButton.setText("Check your prograss");
        prograssButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prograssButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(muteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(onlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(prograssButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1039, 1039, 1039))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(muteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(onlineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(prograssButton))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        
        jCheckBox1.setEnabled(true);
            jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);
            jCheckBox7.setEnabled(true);
            jCheckBox8.setEnabled(true);
            jCheckBox9.setEnabled(true);
            jCheckBox10.setEnabled(true);

            jCheckBox1.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            jCheckBox5.setSelected(false);
            jCheckBox7.setSelected(false);
            jCheckBox8.setSelected(false);
            jCheckBox9.setSelected(false);
            jCheckBox10.setSelected(false);
        
        if (!submitTextField.getText().isEmpty()) {
                submitButton.doClick();
            }
        
        
        try {
            submitTextField.setText("");
            String catText = textArea.getText();
            catMap.put(questionNum5, catText);
            questionNum5++;

            if (catArrayList.size() < 7) {
                try {
                    int count = ServerConnector.getServerConnector().getQuestionController().countCat1();

                    High = count;

//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
//                    High = x1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray1.contains(question) & (question != 0)) {
                                randomArray1.add(question);
                                if (!randomArray1.isEmpty()) {
                                    x = randomArray1.get(randomArray1.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion1(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer1(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //   String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 8) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat2();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray2.contains(question) & (question != 0)) {
                                randomArray2.add(question);
                                if (!randomArray2.isEmpty()) {
                                    x = randomArray2.get(randomArray2.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion2(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer2(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        // String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 12) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat3();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray3.contains(question) & (question != 0)) {
                                randomArray3.add(question);
                                if (!randomArray3.isEmpty()) {
                                    x = randomArray3.get(randomArray3.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion3(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer3(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //    String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 15) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat4();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray4.contains(question) & (question != 0)) {
                                randomArray4.add(question);
                                if (!randomArray4.isEmpty()) {
                                    x = randomArray4.get(randomArray4.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion4(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer4(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //   String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 23) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat5();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray5.contains(question) & (question != 0)) {
                                randomArray5.add(question);
                                if (!randomArray5.isEmpty()) {
                                    x = randomArray5.get(randomArray5.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion5(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer5(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //   String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 24) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat6();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray6.contains(question) & (question != 0)) {
                                randomArray6.add(question);
                                if (!randomArray6.isEmpty()) {
                                    x = randomArray6.get(randomArray6.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion6(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer6(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //        String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 27) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat7();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray7.contains(question) & (question != 0)) {
                                randomArray7.add(question);
                                if (!randomArray7.isEmpty()) {
                                    x = randomArray7.get(randomArray7.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion7(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer7(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //    String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 29) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat8();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray8.contains(question) & (question != 0)) {
                                randomArray8.add(question);
                                if (!randomArray8.isEmpty()) {
                                    x = randomArray8.get(randomArray8.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion8(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer8(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //   String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 31) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat9();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray9.contains(question) & (question != 0)) {
                                randomArray9.add(question);
                                if (!randomArray9.isEmpty()) {
                                    x = randomArray9.get(randomArray9.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion9(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer9(q);

                                        //       String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 34) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat10();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray10.contains(question) & (question != 0)) {
                                randomArray10.add(question);
                                if (!randomArray10.isEmpty()) {
                                    x = randomArray10.get(randomArray10.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion10(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer10(q);

                                        //  String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 35) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat11();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray11.contains(question) & (question != 0)) {
                                randomArray11.add(question);
                                if (!randomArray11.isEmpty()) {
                                    x = randomArray11.get(randomArray11.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion11(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer11(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //    String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 38) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat12();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray12.contains(question) & (question != 0)) {
                                randomArray12.add(question);
                                if (!randomArray12.isEmpty()) {
                                    x = randomArray12.get(randomArray12.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion12(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer12(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //   String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 50) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat13();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray13.contains(question) & (question != 0)) {
                                randomArray13.add(question);
                                if (!randomArray13.isEmpty()) {
                                    x = randomArray13.get(randomArray13.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion13(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer13(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //  String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 53) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat14();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray14.contains(question) & (question != 0)) {
                                randomArray14.add(question);
                                if (!randomArray14.isEmpty()) {
                                    x = randomArray14.get(randomArray14.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion14(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer14(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //  String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 55) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat15();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray15.contains(question) & (question != 0)) {
                                randomArray15.add(question);
                                if (!randomArray15.isEmpty()) {
                                    x = randomArray15.get(randomArray15.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion15(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer15(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //   String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 59) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat16();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray16.contains(question) & (question != 0)) {
                                randomArray16.add(question);
                                if (!randomArray16.isEmpty()) {
                                    x = randomArray16.get(randomArray16.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion16(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer16(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //  String text =new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            } else if (catArrayList.size() < 61) {
                try {
                    int folder1 = ServerConnector.getServerConnector().getQuestionController().countCat17();
//                    File[] listOfFiles1 = folder1.listFiles();
//                    int x1 = listOfFiles1.length;
                    High = folder1;
                    if (randomArray.size() < 60) {
                        try {
                            question = random.nextInt(High - Low) + Low;
                            if (!randomArray17.contains(question) & (question != 0)) {
                                randomArray17.add(question);
                                if (!randomArray17.isEmpty()) {
                                    x = randomArray17.get(randomArray17.size() - 1);

                                    System.out.println(x);
                                    System.out.println("no of ele" + catArrayList.size());
                                    q = new Question(x);
                                    try {
                                        String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion17(q);
                                        textArea.setText(file);
                                        String fileAns = ServerConnector.getServerConnector().getQuestionController().submitMyAnswer17(q);
                                        //FileReader myFile = new FileReader(fileAns);
                                        //      String text = new StringTokenizer(fileAns, "\\A").nextToken();
                                        String text = fileAns.toUpperCase().trim();
                                        newMap.put(questionNum4, text);
                                        questionNum4++;

                                    } catch (NotBoundException | MalformedURLException ex) {
                                        Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    String ans = textArea.getText();
                                    hashMap.put(questionNum, ans);
                                    questionNum++;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
                    }
                } catch (NotBoundException | MalformedURLException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

                catArrayList.add(y++);
            }

            /*
             if (randomArray.size() < 60) {
             try {
             question = random.nextInt(High - Low) + Low;
             if (!randomArray.contains(question) & (question != 0)) {
             randomArray.add(question);
             if (!randomArray.isEmpty()) {
             x = randomArray.get(randomArray.size() - 1);
             System.out.println(x);
             }
             }

             q = new Question(x);
             try {

             File file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion17(q);

             textArea.read(new FileReader(file), null);

             } catch (NotBoundException | MalformedURLException ex) {
             Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
             }
             System.out.println("");

             // MyForm.textField.read(new FileReader("Question" + x + ".txt"), null);
             //MyForm.textField.read(new FileReader("G:\\ExamLab Project\\ExamSimulatorClient\\src\\file\\question\\Question" + x + ".txt"), null);
             } catch (IOException ex) {
             Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
             }

             String ans = textArea.getText();
             hashMap.put(questionNum, ans);
             questionNum++;

             } else {
             JOptionPane.showMessageDialog(this, "You are already get all question.Please review that questions ");
             }
             */
        } catch (IOException ex) {
            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(newMap);

    }//GEN-LAST:event_nextButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

//        String ans = submitTextField.getText();
//
//        if (answerMap.containsKey(questionNum1)) {
//            answerMap.put(questionNum1, ans);
//        } else {
//            answerMap.put(questionNum1, ans);
//            questionNum1++;
//        }
        String ans = submitTextField.getText();

        answ = submitTextField.getText().toUpperCase().trim();

        if (answerMap.containsKey(questionNum1)) {
            answerMap.put(questionNum1, answ);

            for (int i = 0; i <= 11; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (Integer.toString(questionNum1).equals(buttonArrayList[i][j].getName())) {
                        buttonArrayList[i][j].setForeground(Color.red);
                        buttonArrayList[i][j].repaint();
                    } else if (submitTextField.getText().isEmpty()) {
                        buttonArrayList[i][j].setBackground(Color.WHITE);
                        buttonArrayList[i][j].repaint();
                    }
                }
            }

        } else {
            answerMap.put(questionNum1, answ);
            for (int i = 0; i <= 11; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (Integer.toString(questionNum1).equals(buttonArrayList[i][j].getName())) {
                        buttonArrayList[i][j].setForeground(Color.red);
                        buttonArrayList[i][j].repaint();
                    }
                }
            }
            questionNum1++;
        }

        try {
            boolean question = ServerConnector.getServerConnector().getQuestionController().submitAnswer(q, submitTextField.getText().toUpperCase().trim());

        } catch (IOException ex) {
            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);

        } catch (NotBoundException ex) {
            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed

        muteButton.setEnabled(true);
        Runnable runnable = new Runnable() {
            public void run() {

                VoiceManager vm = VoiceManager.getInstance();
                voice = vm.getVoice(VOICENAME);
                voice.allocate();

                try {

                    voice.speak(textArea.getText());

                } catch (Exception e) {
                }

            }
        };
        t = new Thread(runnable);

        t.start();
//        try {
//            t.wait();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_readButtonActionPerformed

    private void muteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteButtonActionPerformed
        voice.deallocate();
    }//GEN-LAST:event_muteButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        questionNum1 = 3;
        textArea.setText(hashMap.get(3));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(3));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        questionNum1 = 8;
        textArea.setText(hashMap.get(8));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(8));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        questionNum1 = 13;
        textArea.setText(hashMap.get(13));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(13));
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        questionNum1 = 18;
        textArea.setText(hashMap.get(18));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(18));
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        questionNum1 = 38;
        textArea.setText(hashMap.get(38));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(38));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        questionNum1 = 33;
        textArea.setText(hashMap.get(33));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(33));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        questionNum1 = 23;
        textArea.setText(hashMap.get(23));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(23));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        questionNum1 = 28;
        textArea.setText(hashMap.get(28));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(28));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        questionNum1 = 58;
        textArea.setText(hashMap.get(58));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(58));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        questionNum1 = 53;
        textArea.setText(hashMap.get(53));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(53));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        questionNum1 = 43;
        textArea.setText(hashMap.get(43));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(43));         // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        questionNum1 = 48;
        textArea.setText(hashMap.get(48));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(48));         // TODO add your handling code here:
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        questionNum1 = 42;
        textArea.setText(hashMap.get(42));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(42));         // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        questionNum1 = 1;
        textArea.setText(hashMap.get(1));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(1));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        questionNum1 = 2;
        textArea.setText(hashMap.get(2));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(2));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        questionNum1 = 4;
        textArea.setText(hashMap.get(4));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(4));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        questionNum1 = 5;
        textArea.setText(hashMap.get(5));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(5));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        questionNum1 = 6;
        textArea.setText(hashMap.get(6));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(6));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        questionNum1 = 7;
        textArea.setText(hashMap.get(7));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(7));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        questionNum1 = 9;
        textArea.setText(hashMap.get(9));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(9));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        questionNum1 = 10;
        textArea.setText(hashMap.get(10));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(10));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        int count11 = 0;
        int count12 = 0;
        int count13 = 0;
        int count14 = 0;
        int count15 = 0;
        int count16 = 0;
        int count17 = 0;
        DefaultCategoryDataset dataset = null;
        for (int is : answerMap.keySet()) {
            if (newMap.containsKey(is) && Objects.equals(answerMap.get(is), newMap.get(is))) {
                dataset = new DefaultCategoryDataset();
                anxCount++;
                int myKey = is;
                if (myKey < 7) {
                    count1++;
                    int a1 = (count1 * 100) / 6;
                    System.out.println("Collection Framework Generics :" + a1);
                    cat1 = a1;
                    //System.out.println("Collection Framework Generics :" + a1);
                    dataset.setValue(a1, "gfdg", "Collection Framework Generics");

                } else if (myKey < 8) {
                    count2++;
                    int a2 = (count2 * 100) / 1;
                    System.out.println("count 2 :" + a2);
                    cat2 = a2;
                    dataset.setValue(a2, "gfdg", "Date Number Currency");
                } else if (myKey < 12) {
                    count3++;
                    int a3 = (count3 * 100) / 3;
                    System.out.println("count 3 :" + a3);
                    cat3 = a3;
                    dataset.setValue(a3, "gfdg", "Development");
                } else if (myKey < 17) {
                    count4++;
                    int a4 = (count4 * 100) / 5;
                    System.out.println("count 4 :" + a4);
                    cat4 = a4;
                    dataset.setValue(a4, "gfdg", "Exception Assertion");
                } else if (myKey < 23) {
                    count5++;
                    int a5 = (count5 * 100) / 6;
                    System.out.println("count 5 :" + a5);
                    cat5 = a5;
                    dataset.setValue(a5, "gfdg", "File IO , Serialization");
                } else if (myKey < 24) {
                    count6++;
                    int a6 = (count6 * 100) / 1;
                    System.out.println("count 6 :" + a6);
                    cat6 = a6;
                    dataset.setValue(a6, "gfdg", "Flow Control");
                } else if (myKey < 27) {
                    count7++;
                    int a7 = (count7 * 100) / 3;
                    System.out.println("count 7 :" + a7);
                    cat7 = a7;
                    dataset.setValue(a7, "gfdg", "Formatting Tokenizing");
                } else if (myKey < 29) {
                    count8++;
                    int a8 = (count8 * 100) / 2;
                    System.out.println("count 8 :" + a8);
                    cat8 = a8;
                    dataset.setValue(a8, "gfdg", "Garbage Collector");
                } else if (myKey < 30) {
                    count9++;
                    int a9 = (count9 * 100) / 1;
                    System.out.println("count 9 :" + a9);
                    cat9 = a9;
                    dataset.setValue(a9, "gfdg", "Inner Classes");
                } else if (myKey < 34) {
                    count10++;
                    int a10 = (count10 * 100) / 4;
                    System.out.println("count 10 :" + a10);
                    cat10 = a10;
                    dataset.setValue(a10, "gfdg", "Interface Var-Args Enum");
                } else if (myKey < 35) {
                    count11++;
                    int a11 = (count11 * 100) / 1;
                    System.out.println("count 11 :" + a11);
                    cat11 = a11;
                    dataset.setValue(a11, "gfdg", "Java Fundamentals, Primitive Data Types Arrays");
                } else if (myKey < 38) {
                    count12++;
                    int a12 = (count12 * 100) / 3;
                    System.out.println("count 12 :" + a12);
                    cat12 = a12;
                    dataset.setValue(a12, "gfdg", "Modifiers Access,Non Access");
                } else if (myKey < 50) {
                    count13++;
                    int a13 = (count13 * 100) / 12;
                    System.out.println("count 13 :" + a13);
                    cat13 = a13;
                    dataset.setValue(a13, "gfdg", "Object Orientation");
                } else if (myKey < 53) {
                    count14++;
                    int a14 = (count14 * 100) / 3;
                    System.out.println("count 14 :" + a14);
                    cat14 = a14;
                    dataset.setValue(a14, "gfdg", "Objects, Variable, Methods");
                } else if (myKey < 55) {
                    count15++;
                    int a15 = (count15 * 100) / 2;
                    System.out.println("count 15 :" + a15);
                    cat15 = a15;
                    dataset.setValue(a15, "gfdg", "String, String Buffer, String Builder");
                } else if (myKey < 59) {
                    count16++;
                    int a16 = (count16 * 100) / 4;
                    System.out.println("count 16 :" + a16);
                    cat16 = a16;
                    dataset.setValue(a16, "gfdg", "Threads");
                } else if (myKey < 61) {
                    count17++;
                    int a17 = (count17 * 100) / 2;
                    System.out.println("count 17 :" + a17);
                    cat17 = a17;
                    dataset.setValue(a17, "gfdg", "Wrapper Classes");
                }
                System.out.println("keys :" + myKey);

//
//                    //JFreeChart chart=ChartFactory.create
//                }
//            }
//            JFreeChart freeChart = ChartFactory.createBarChart("Marks with catagories", "Subject", "Persentage", dataset, PlotOrientation.VERTICAL, false, true, false);
//            CategoryPlot plot = freeChart.getCategoryPlot();
//            plot.setRangeGridlinePaint(Color.BLUE);
//            ChartFrame frame = new ChartFrame("Student Performance", freeChart);
//            frame.setVisible(true);
//            frame.setSize(550, 450);
                System.out.println("Correct :" + anxCount);
                System.out.println("Percentage :" + (anxCount * 100) / 60 + "%");
                System.out.println("submit answers " + answerMap);
                System.out.println("correct answers " + newMap);
                try {
                    controller.removeObserve(studentObserverImpl);
                } catch (RemoteException ex) {
                    Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
int option = JOptionPane.showConfirmDialog(this, "Would you like to stop the exam?please notify your hole answers must be lost", "Confirm Message", JOptionPane.YES_NO_OPTION);
        System.out.println(option);
        if (option==0) {
            dispose();
            new PrograssCharts(null, true).setVisible(true);
        }


//        this.dispose();
//        new PrograssCharts(null, true).setVisible(true);


    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        try {
//            controller.addObserve(studentObserverImpl);
//        } catch (RemoteException ex) {
//            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        questionNum1 = 11;
        textArea.setText(hashMap.get(11));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(11));
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        questionNum1 = 12;
        textArea.setText(hashMap.get(12));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(12));
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        questionNum1 = 14;
        textArea.setText(hashMap.get(14));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(14));
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        questionNum1 = 15;
        textArea.setText(hashMap.get(15));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(15));
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        questionNum1 = 16;
        textArea.setText(hashMap.get(16));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(16));
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        questionNum1 = 17;
        textArea.setText(hashMap.get(17));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(17));
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        questionNum1 = 19;
        textArea.setText(hashMap.get(19));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(19));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        questionNum1 = 20;
        textArea.setText(hashMap.get(20));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(20));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        questionNum1 = 21;
        textArea.setText(hashMap.get(21));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(21));
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        questionNum1 = 22;
        textArea.setText(hashMap.get(22));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(22));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        questionNum1 = 24;
        textArea.setText(hashMap.get(24));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(24));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        questionNum1 = 25;
        textArea.setText(hashMap.get(25));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(25));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        questionNum1 = 26;
        textArea.setText(hashMap.get(26));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(26));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        questionNum1 = 27;
        textArea.setText(hashMap.get(27));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(27));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        questionNum1 = 29;
        textArea.setText(hashMap.get(29));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(29));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        questionNum1 = 30;
        textArea.setText(hashMap.get(30));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(30));
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        questionNum1 = 31;
        textArea.setText(hashMap.get(31));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(31));              // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        questionNum1 = 32;
        textArea.setText(hashMap.get(32));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(32));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        questionNum1 = 34;
        textArea.setText(hashMap.get(34));
        submitTextField.repaint();

        submitTextField.setText(answerMap.get(34));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        questionNum1 = 35;
        textArea.setText(hashMap.get(35));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(35));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        questionNum1 = 36;
        textArea.setText(hashMap.get(36));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(36));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        questionNum1 = 37;
        textArea.setText(hashMap.get(37));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(37));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        questionNum1 = 39;
        textArea.setText(hashMap.get(39));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(39));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        questionNum1 = 40;
        textArea.setText(hashMap.get(40));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(40));           // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        questionNum1 = 41;
        textArea.setText(hashMap.get(41));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(41));         // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        questionNum1 = 44;
        textArea.setText(hashMap.get(44));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(44));         // TODO add your handling code here:
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        questionNum1 = 45;
        textArea.setText(hashMap.get(45));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(45));         // TODO add your handling code here:
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        questionNum1 = 60;
        textArea.setText(hashMap.get(60));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(60));  // TODO add your handling code here:
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        questionNum1 = 59;
        textArea.setText(hashMap.get(59));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(59));  // TODO add your handling code here:
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        questionNum1 = 57;
        textArea.setText(hashMap.get(57));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(57)); // TODO add your handling code here:
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        questionNum1 = 56;
        textArea.setText(hashMap.get(56));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(56));// TODO add your handling code here:
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        questionNum1 = 55;
        textArea.setText(hashMap.get(55));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(55));// TODO add your handling code here:
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        questionNum1 = 54;
        textArea.setText(hashMap.get(54));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(54));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        questionNum1 = 52;
        textArea.setText(hashMap.get(52));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(52));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        questionNum1 = 51;
        textArea.setText(hashMap.get(51));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(51));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        questionNum1 = 50;
        textArea.setText(hashMap.get(50));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(50));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        questionNum1 = 49;
        textArea.setText(hashMap.get(49));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(49));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        questionNum1 = 47;
        textArea.setText(hashMap.get(47));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(47));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        questionNum1 = 46;
        textArea.setText(hashMap.get(46));
        submitTextField.repaint();
        submitTextField.setText(answerMap.get(46));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        new ForumMain(null, true).setVisible(true);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (questionNum > 1) {
            questionNum--;
            System.out.println("qusno" + questionNum);
            //hashMap.put(questionNum, answ);
            hashMap.get(questionNum);
            textArea.setText(hashMap.get(questionNum).toString());
            System.out.println("ddddddd" + questionNum);
            //submitTextField.setText(submit.get(questionNum));
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void prograssButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prograssButtonActionPerformed
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        int count11 = 0;
        int count12 = 0;
        int count13 = 0;
        int count14 = 0;
        int count15 = 0;
        int count16 = 0;
        int count17 = 0;

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        int a5 = 0;
        int a6 = 0;
        int a7 = 0;
        int a8 = 0;
        int a9 = 0;
        int a10 = 0;
        int a11 = 0;
        int a12 = 0;
        int a13 = 0;
        int a14 = 0;
        int a15 = 0;
        int a16 = 0;
        int a17 = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int is : answerMap.keySet()) {
            if (newMap.containsKey(is) && Objects.equals(answerMap.get(is), newMap.get(is))) {

                anxCount++;
                int myKey = is;
                if (myKey < 7) {
                    count1++;
                    a1 = (count1 * 100) / 6;
                    System.out.println("Collection Framework Generics :" + a1);
                    //System.out.println("Collection Framework Generics :" + a1);
                    // dataset.setValue(a1, "gfdg", "Collection Framework Generics");

                } else if (myKey < 8) {
                    count2++;
                    a2 = (count2 * 100) / 1;
                    System.out.println("count 2 :" + a2);
                    //  dataset.setValue(a2, "gfdg", "Date Number Currency");
                } else if (myKey < 12) {
                    count3++;
                    a3 = (count3 * 100) / 3;
                    System.out.println("count 3 :" + a3);
                    // dataset.setValue(a3, "gfdg", "Development");
                } else if (myKey < 17) {
                    count4++;
                    a4 = (count4 * 100) / 5;
                    System.out.println("count 4 :" + a4);
                    //dataset.setValue(a4, "gfdg", "Exception Assertion");
                } else if (myKey < 23) {
                    count5++;
                    a5 = (count5 * 100) / 6;
                    System.out.println("count 5 :" + a5);
                    //dataset.setValue(a5, "gfdg", "File IO , Serialization");
                } else if (myKey < 24) {
                    count6++;
                    a6 = (count6 * 100) / 1;
                    System.out.println("count 6 :" + a6);
                    //dataset.setValue(a6, "gfdg", "Flow Control");
                } else if (myKey < 27) {
                    count7++;
                    a7 = (count7 * 100) / 3;
                    System.out.println("count 7 :" + a7);
                    //dataset.setValue(a7, "gfdg", "Formatting Tokenizing");
                } else if (myKey < 29) {
                    count8++;
                    a8 = (count8 * 100) / 2;
                    System.out.println("count 8 :" + a8);
                    //dataset.setValue(a8, "gfdg", "Garbage Collector");
                } else if (myKey < 30) {
                    count9++;
                    a9 = (count9 * 100) / 1;
                    System.out.println("count 9 :" + a9);
                    //dataset.setValue(a9, "gfdg", "Inner Classes");
                } else if (myKey < 34) {
                    count10++;
                    a10 = (count10 * 100) / 4;
                    System.out.println("count 10 :" + a10);
                    //dataset.setValue(a10, "gfdg", "Interface Var-Args Enum");
                } else if (myKey < 35) {
                    count11++;
                    a11 = (count11 * 100) / 1;
                    System.out.println("count 11 :" + a11);
                    //dataset.setValue(a11, "gfdg", "Java Fundamentals, Primitive Data Types Arrays");
                } else if (myKey < 38) {
                    count12++;
                    a12 = (count12 * 100) / 3;
                    System.out.println("count 12 :" + a12);
                    //dataset.setValue(a12, "gfdg", "Modifiers Access,Non Access");
                } else if (myKey < 50) {
                    count13++;
                    a13 = (count13 * 100) / 12;
                    System.out.println("count 13 :" + a13);
                    //dataset.setValue(a13, "gfdg", "Object Orientation");
                } else if (myKey < 53) {
                    count14++;
                    a14 = (count14 * 100) / 3;
                    System.out.println("count 14 :" + a14);
                    //dataset.setValue(a14, "gfdg", "Objects, Variable, Methods");
                } else if (myKey < 55) {
                    count15++;
                    a15 = (count15 * 100) / 2;
                    System.out.println("count 15 :" + a15);
                    //dataset.setValue(a15, "gfdg", "String, String Buffer, String Builder");
                } else if (myKey < 59) {
                    count16++;
                    a16 = (count16 * 100) / 4;
                    System.out.println("count 16 :" + a16);
                    //dataset.setValue(a16, "gfdg", "Threads");
                } else if (myKey < 61) {
                    count17++;
                    a17 = (count17 * 100) / 2;
                    System.out.println("count 17 :" + a17);
                    //dataset.setValue(a17, "gfdg", "Wrapper Classes");
                }
                System.out.println("keys :" + myKey);

                //JFreeChart chart=ChartFactory.create
            }
        }
//        JFreeChart freeChart = ChartFactory.createBarChart("Marks with catagories", "Subject", "Persentage", dataset, PlotOrientation.VERTICAL, false, true, false);
//        CategoryPlot plot = freeChart.getCategoryPlot();
//plot.setRangeGridlinePaint(Color.BLUE);
//                ChartFrame frame = new ChartFrame("Student Performance", freeChart);
//                frame.setVisible(true);
//                frame.setSize(550, 450);
        dataset.setValue(a1, "gfdg", "CollectionFramework,Generics");
        dataset.setValue(a2, "gfdg", "Date,Num,Curr");
        dataset.setValue(a3, "gfdg", "Development");
        dataset.setValue(a4, "gfdg", "Exception");
        dataset.setValue(a5, "gfdg", "File,Serialization");
        dataset.setValue(a6, "gfdg", "Flow Control");
        dataset.setValue(a7, "gfdg", "Tokenizing");
        dataset.setValue(a8, "gfdg", "G.C");
        dataset.setValue(a9, "gfdg", "Inner Classes");
        dataset.setValue(a10, "gfdg", "Interface,Var-Args,Enum");
        dataset.setValue(a11, "gfdg", "Fundamentals,Data Types,Arrays");
        dataset.setValue(a12, "gfdg", "Modifiers");
        dataset.setValue(a13, "gfdg", "OOP");
        dataset.setValue(a14, "gfdg", "Objects,Variable,Methods");
        dataset.setValue(a15, "gfdg", "String, String Buffer, String Builder");
        dataset.setValue(a16, "gfdg", "Threads");
        dataset.setValue(a17, "gfdg", "Wrapper Classes");
        JFreeChart freeChart = ChartFactory.createBarChart("Marks with catagories", "Subject", "Persentage", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = freeChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Student Performance", freeChart);
        frame.setVisible(true);
        frame.setSize(1500, 750);

        System.out.println("Correct :" + anxCount);
        System.out.println("Percentage :" + (anxCount * 100) / 60 + "%");
        System.out.println("submit answers " + answerMap);
        System.out.println("correct answers " + newMap);
        try {
            controller.removeObserve(studentObserverImpl);
        } catch (RemoteException ex) {
            Logger.getLogger(QuestionLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prograssButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        //        String text = jTextArea1.getText();
        ////        if (jCheckBox1.isSelected() && !text.contains(jCheckBox1.getText())) {
            ////            jTextArea1.append(jCheckBox1.getText());
            ////        } else
        //        if (!jCheckBox1.isSelected() && text.contains(jCheckBox1.getText())) {
            //            String regex = "\\s*\\bis\\aA\\s*";
            //            //jTextArea1/**/.replaceAll(regex, "");
            //            String tee = jTextArea1.getText();
            //            text = text.replaceAll(regex, "");
            //        } else {
            //            jTextArea1.append(jCheckBox1.getText());
            //        }

        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox1.isSelected() && !text.contains(jCheckBox1.getText())) {
            submitTextField.append(jCheckBox1.getText());

        } else if (!jCheckBox1.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox1.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed

        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox3.isSelected() && !text.contains(jCheckBox3.getText())) {
            submitTextField.append(jCheckBox3.getText());

        } else if (!jCheckBox3.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox3.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox5.isSelected() && !text.contains(jCheckBox5.getText())) {
            submitTextField.append(jCheckBox5.getText());
        } else if (!jCheckBox5.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox5.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox4.isSelected() && !text.contains(jCheckBox4.getText())) {
            submitTextField.append(jCheckBox4.getText());
        }
        if (!jCheckBox4.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox4.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox7.isSelected() && !text.contains(jCheckBox7.getText())) {
            submitTextField.append(jCheckBox7.getText());
        } else if (!jCheckBox7.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox7.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox8.isSelected() && !text.contains(jCheckBox8.getText())) {
            submitTextField.append(jCheckBox8.getText());
        } else if (!jCheckBox8.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox8.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        String text = submitTextField.getText();
        submitButton.setEnabled(true);
        if (jCheckBox9.isSelected() && !text.contains(jCheckBox9.getText())) {
            submitTextField.append(jCheckBox9.getText());
        } else if (!jCheckBox9.isSelected()) {
            String s = submitTextField.getText();
            String a = s.replace(jCheckBox9.getText(), "");
            submitTextField.setText(a);
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox10ActionPerformed
    private Thread t;

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
            java.util.logging.Logger.getLogger(QuestionLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuestionLab dialog = new QuestionLab(new javax.swing.JFrame(), false);
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
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton muteButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel onlineLabel;
    private javax.swing.JButton prograssButton;
    private javax.swing.JButton readButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextArea submitTextField;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(QuestionLab.this, message);
    }

    public void displayMessage(String message) {

        onlineLabel.setText(message);
    }

}
