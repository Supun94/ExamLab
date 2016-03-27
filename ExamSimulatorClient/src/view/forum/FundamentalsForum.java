/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

import connector.ServerConnector;
import controller.ForumController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import models.Answer;
import models.Question;
import observer.ForumAnswerObserverImpl;
import org.jdesktop.swingx.JXHyperlink;
import org.jdesktop.swingx.VerticalLayout;
import view.ExamRegistrationForm;

/**
 *
 * @author Supun
 */
public class FundamentalsForum extends javax.swing.JDialog {

    private List<String> catogeryList;
    private List<String> topicList;
    List<String> sections;

    Question currentQuestion;
    String curSec;
    String curCat;
    JTextArea area;
    ForumAnswerObserverImpl forumAnswerObserverImpl;
    ForumController controller;

    /**
     * Creates new form ForumCat
     */
    public FundamentalsForum(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            questionPanel.setVisible(false);
            myAnsPanel.setVisible(false);
            nextButton3.setEnabled(false);
            nextButton2.setEnabled(false);
            try {
                controller = ServerConnector.getServerConnector().getForumController();
            } catch (NotBoundException ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            }
            forumAnswerObserverImpl = new ForumAnswerObserverImpl(this);
            controller.addObserve(forumAnswerObserverImpl);
            jPanel1.setLayout(new VerticalLayout(4));
            jPanel2.setLayout(new VerticalLayout(10));
            jPanel3.setLayout(new VerticalLayout(2));
            //area.setSize(100, 200);

            //        try {
//            try {
//                forumController = ServerConnector.getServerConnector().getForumController().getSections();
//
//                for (int j = 0; j < 1; j++) {
//                    final String str1 = forumController.get(1);
//                    System.out.println("str1" + str1);
//                    // List<String> cat = FileSystem.getCategories(str1);
//                    List<String> cat = ServerConnector.getServerConnector().getForumController().getCategories(str1);
//                    for (final String str2 : cat {
//                        System.out.println("str2" + str2);
//                        final JButton button = new JButton(str2);
//                        jPanel1.add(button);
//                        jPanel1.revalidate();
//                        jPanel1.repaint();
//
//                        /*  
//                         Runnable runnable = new Runnable() {
//                         public void run() {
//
//                         VoiceManager vm = VoiceManager.getInstance();
//                         voice = vm.getVoice(VOICENAME);
//                         voice.allocate();
//
//                         try {
//
//                         voice.speak(textArea.getText());
//
//                         } catch (Exception e) {
//                         }
//
//                         }
//                         };
//                         t = new Thread(runnable);
//
//                         t.start();
//                         */
//                        Runnable runnable = new Runnable() {
//                            public void run() {
//                                button.addActionListener(new java.awt.event.ActionListener() {
//
//                                    /*List<String> top = FileSystem.getQuestionTopics(str1, str2);
//                                     for (String str3 : top) {
//                                     Question q = FileSystem.getQuestion(str1, str2, str3);
//                                     System.out.println("\t\tTOPIC by: " + q.getUsername() + "::" + str3);
//                                     System.out.println("\t\tDESCRIPTION: " + q.getDescription());
//                                     for (Answer ans : q.getAnswers()) {
//                                     System.out.println("\t\t\tANS by: " + ans.getUsername() + "::" + ans.getDescription());
//                                        }
//                                     }*/
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        jPanel3.removeAll();
//                                        //List<String> top = FileSystem.getQuestionTopics(str1, str2);
//                                        try {
//                                            List<String> top = ServerConnector.getServerConnector().getForumController().getQuestionTopics(str1, str2);
//                                            for (final String str3 : top) {
//                                                //final Question q = FileSystem.getQuestion(str1, str2, str3);
//
//
//                                                System.out.println("Name of "+button.getText());
//                                                final Question q = ServerConnector.getServerConnector().getForumController().getQuestion(str1, str2, button.getText());
//                                                    //  System.out.println("\t\tTOPIC by: " + q.getUsername() + "::" + str3);
//                                                    //      System.out.println("\t\tDESCRIPTION: " + q.getDescription());
//                                                    System.out.println("str3" + str3);
//                                                saveButton.addActionListener(new java.awt.event.ActionListener() {
//                                                    @Override
//                                                    public void actionPerformed(ActionEvent e) {
//                                                        try {
//                                                            /*Question q2 = new Question("gamma", "rmi", "What the hell is RMI?");
//                                                             q2.getAnswers().add(new Answer("d", "It can connect remote apps"));
//                                                             q2.getAnswers().add(new Answer("alpha", "Yeah. I agree with @delta"));
//
//                                                             FileSystem.save(q2, "Remoting", "RMI");*/
//                                                     //       Question q1 = new Question(nameTextField.getText(), str3, descTextField.getText());
//                                                                
//                                                            q.getAnswers().add(new Answer(nameTextField.getText(), descTextField.getText()));
//                                                            try {
//                                                                ServerConnector.getServerConnector().getForumController().save(q, str1, str2);
//                                                            } catch (RemoteException ex) {
//                                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//                                                            } catch (ClassNotFoundException ex) {
//                                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//                                                            } catch (SQLException ex) {
//                                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//                                                            }
//                                                        } catch (NotBoundException ex) {
//                                                            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//                                                        } catch (MalformedURLException ex) {
//                                                            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//                                                        }
//                                                    }
//                                                });
//                                                JButton button = new JButton(str3);
//                                                    jPanel3.add(button);
//                                                    jPanel3.revalidate();
//                                                    jPanel3.repaint();
//                                                    button.addActionListener(new java.awt.event.ActionListener() {
//                                                        //jTextArea1.setText("\t\tTOPIC by: " + q.getUsername() + "::" + str3);
//                                                        // jTextArea1.setText("\t\tDESCRIPTION: " + q.getDescription());
//
//                                                        @Override
//                                                        public void actionPerformed(ActionEvent e) {
//                                                            jPanel2.removeAll();
//                                                            //jTextArea1.removeAll();
//                                                            descLabel.removeAll();
//                                                            topicLabel.removeAll();
//                                                            for (Answer ans : q.getAnswers()) {
//                                                            System.out.println("\t\t\tANS by: " + ans.getUsername() + "::" + ans.getDescription());
//                                                            System.out.println("ans :"+ans);
//                                                                //jTextArea1.setText("\t\tTOPIC by: " + q.getUsername() + "::" + str3+"\t\t\tANS by: " + ans.getUsername() + "::" + ans.getDescription()+"\t\tDESCRIPTION: " + q.getDescription());
//                                                                //jTextArea1.append("\t\tTOPIC by: " + q.getUsername() + "\n" + "::" + str3 + "\t\t\tANS by: " + ans.getUsername() + "\n" + "::" + ans.getDescription() + "\t\tDESCRIPTION: " + q.getDescription() + "\n");
//                                                                JTextArea area = new JTextArea("ANS by: " + ans.getUsername() + "\n");
//                                                                //jTextArea1.setText("DESCRIPTION: " + q.getDescription());
//                                                                descLabel.setText("DESCRIPTION: " + q.getDescription());
//                                                                topicLabel.setText("TOPIC by: " + q.getUsername() + "::" + str3);
//                                                                jPanel2.add(area);
//                                                                jPanel2.revalidate();
//                                                                jPanel2.repaint();
//
//                                                            }
//
//                                                        }
//                                                    });
//                                                }
//
//                                        } catch (NotBoundException | MalformedURLException | RemoteException | ClassNotFoundException | SQLException ex) {
//                                            Logger.getLogger(ExamRegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
//                                        }
//                                    }
//
//                                });
//
//                            }
//                        };
//                        Thread t = new Thread(runnable);
//
//                        t.start();
//
//                    }
//
//                }
//
//            } catch (RemoteException | ClassNotFoundException | SQLException ex) {
//                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (NotBoundException | MalformedURLException ex) {
//            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
//        }
            try {
                sections = ServerConnector.getServerConnector().getForumController().getSections();
                final String section = sections.get(3);

                System.out.println("section"+sections.get(3));
                catogeryList = ServerConnector.getServerConnector().getForumController().getCategories(section);
                jPanel1.removeAll();
                for (final String category : catogeryList) {
                    final JXHyperlink button = new JXHyperlink();
                    button.setText(category);
                    button.setFont(new java.awt.Font("Arial", 0, 24));
                    jPanel2.removeAll();
                    jPanel1.add(button);
                    jPanel1.revalidate();
                    jPanel1.repaint();

                    button.addActionListener(new ActionListener() {
                        String sec = section;
                        String cat = category;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jPanel2.revalidate();
                            jPanel2.repaint();
                            jPanel2.removeAll();
                            descLabel.setText("");
                            topicLabel.setText("");
                            try {
                                topicList = ServerConnector.getServerConnector().getForumController().getQuestionTopics(section, category);
                                jPanel3.removeAll();
                                for (final String topic : topicList) {
                                    JXHyperlink topicBtn = new JXHyperlink();
                                    topicBtn.setText(topic);
                                    topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
                                    //topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
                                    jPanel3.add(topicBtn);
                                    jPanel3.repaint();
                                    jPanel3.revalidate();

                                    topicBtn.addActionListener(new ActionListener() {
                                        String s = sec;
                                        String c = cat;
                                        String t = topic;

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            questionPanel.setVisible(true);
                                            myAnsPanel.setVisible(true);
                                            jPanel2.revalidate();
                                            jPanel2.repaint();
                                            jPanel2.removeAll();
                                            descLabel.setText("");  
                                            topicLabel.setText("");
                                            try {
                                                final Question q = ServerConnector.getServerConnector().getForumController().getQuestion(s, c, t);
                                                currentQuestion = q;
                                                curSec = s;
                                                curCat = c;
                                                jPanel2.removeAll();
                                                for (Answer answer : q.getAnswers()) {
                                                    area = new JTextArea("ANS by: " + answer.getUsername() + "\n" + "Desc :" + answer.getDescription());
                                                    area.setFont(new java.awt.Font("Arial", 0, 18));
                                                //JScrollPane scrollArea = new JScrollPane(area);

                                                    //jTextArea1.setText("DESCRIPTION: " + q.getDescription());
                                                    descLabel.setText("DESCRIPTION: " + q.getDescription());
                                                    System.out.println("DESCRIPTION: " + q.getDescription());
                                                    descLabel.setFont(new java.awt.Font("Arial", 0, 24));
                                                    topicLabel.setText("TOPIC by: " + q.getUsername() + ">>" + t);
                                                    System.out.println("TOPIC by: " + q.getUsername() + ">>" + t);
                                                    topicLabel.setFont(new java.awt.Font("Arial", 0, 16));
                                                    jPanel2.add(area);
                                                    jPanel2.revalidate();
                                                    jPanel2.repaint();
                                                    area.setAutoscrolls(true);
                                                }
                                            } catch (NotBoundException ex) {
                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (MalformedURLException ex) {
                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (Exception ex) {
                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    });

                                }
                            } catch (NotBoundException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                }

            } catch (NotBoundException ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        topicLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        myAnsPanel = new org.jdesktop.swingx.JXPanel();
        jLabel6 = new javax.swing.JLabel();
        nextButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        descTextField = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel5 = new javax.swing.JLabel();
        questionPanel = new org.jdesktop.swingx.JXPanel();
        qustionTopTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        startNameTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        queDesTextArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nextButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/image/f2747aa8f47a8041486e155be3b44246.jpg"))); // NOI18N
        jLabel3.setOpaque(true);

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(51, 51, 51));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jXPanel1.setBorder(dropShadowBorder1);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Related  Topics");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Search Catogory");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jXPanel2.setBackground(new java.awt.Color(204, 204, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jXPanel2.setBorder(dropShadowBorder2);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShowLeftShadow(true);
        dropShadowBorder3.setShowTopShadow(true);
        jPanel2.setBorder(dropShadowBorder3);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(jPanel2);

        topicLabel.setBackground(new java.awt.Color(255, 255, 255));

        descLabel.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder4.setShowLeftShadow(true);
        dropShadowBorder4.setShowTopShadow(true);
        myAnsPanel.setBorder(dropShadowBorder4);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Colonna MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Answer     :");

        nextButton2.setBackground(new java.awt.Color(255, 0, 0));
        nextButton2.setForeground(new java.awt.Color(255, 255, 255));
        nextButton2.setText("Post Your Answer");
        nextButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton2ActionPerformed(evt);
            }
        });

        descTextField.setColumns(20);
        descTextField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        descTextField.setRows(5);
        descTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descTextFieldKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(descTextField);

        jLabel10.setFont(new java.awt.Font("Ribbon131 BT", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("   Your Answer ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Colonna MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Name        :");

        nameTextField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myAnsPanelLayout = new javax.swing.GroupLayout(myAnsPanel);
        myAnsPanel.setLayout(myAnsPanelLayout);
        myAnsPanelLayout.setHorizontalGroup(
            myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAnsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myAnsPanelLayout.createSequentialGroup()
                        .addGroup(myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myAnsPanelLayout.createSequentialGroup()
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4)))
                    .addGroup(myAnsPanelLayout.createSequentialGroup()
                        .addGroup(myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myAnsPanelLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myAnsPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(nextButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        myAnsPanelLayout.setVerticalGroup(
            myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myAnsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myAnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myAnsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(nextButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(topicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(myAnsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(topicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myAnsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder5.setShowLeftShadow(true);
        dropShadowBorder5.setShowTopShadow(true);
        jXPanel3.setBorder(dropShadowBorder5);

        jLabel5.setFont(new java.awt.Font("Ribbon131 Bd BT", 0, 60)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Ask  Your  Question....");

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder6.setShowLeftShadow(true);
        dropShadowBorder6.setShowTopShadow(true);
        questionPanel.setBorder(dropShadowBorder6);

        qustionTopTextField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        qustionTopTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qustionTopTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Colonna MT", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Description    :");

        startNameTextField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        startNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startNameTextFieldActionPerformed(evt);
            }
        });

        queDesTextArea.setColumns(20);
        queDesTextArea.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        queDesTextArea.setRows(5);
        queDesTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                queDesTextAreaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(queDesTextArea);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Colonna MT", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Topic              :");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Colonna MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Name              :");

        nextButton3.setBackground(new java.awt.Color(255, 0, 0));
        nextButton3.setForeground(new java.awt.Color(255, 255, 255));
        nextButton3.setText("Ask");
        nextButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(qustionTopTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(nextButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addComponent(startNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(qustionTopTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nextButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Ribbon131 BT", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("   Please view the previous descusions first");

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel3Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(126, Short.MAX_VALUE)))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel3Layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(404, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton2ActionPerformed
        /*Question q2 = new Question("gamma", "rmi", "What the hell is RMI?");
         q2.getAnswers().add(new Answer("d", "It can connect remote apps"));
         q2.getAnswers().add(new Answer("alpha", "Yeah. I agree with @delta"));


         }                                          

         ServerConnector.getServerConnector().getForumController().save(q, nameTextField.getText(), descTextField.getText());
         } catch (RemoteException ex) {
         Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
         Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
         Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
         }
         } catch (NotBoundException ex) {
         Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
         } catch (MalformedURLException ex) {
         Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
         }

         }
         */
        currentQuestion.getAnswers().add(new Answer(nameTextField.getText(), descTextField.getText()));
        try {
            ServerConnector.getServerConnector().getForumController().save(currentQuestion, curSec, curCat);
            ServerConnector.getServerConnector().getForumController().notifyObserve(nameTextField.getText(), descTextField.getText(), descLabel.getText(), topicLabel.getText());
       //     nameTextField.setText("");
         //   descTextField.setText("");
            ///////////
            try {
                sections = ServerConnector.getServerConnector().getForumController().getSections();
                final String section = sections.get(3);

                catogeryList = ServerConnector.getServerConnector().getForumController().getCategories(section);
                jPanel1.removeAll();
                for (final String category : catogeryList) {
                    final JXHyperlink button = new JXHyperlink();
                    button.setText(category);
                    button.setFont(new java.awt.Font("Arial", 0, 24));
                    jPanel1.add(button);
                    jPanel1.revalidate();
                    jPanel1.repaint();

                    button.addActionListener(new ActionListener() {
                        String sec = section;
                        String cat = category;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jPanel2.revalidate();
                            jPanel2.repaint();
                            jPanel2.removeAll();
                            descLabel.setText("");
                            topicLabel.setText("");
                            try {
                                topicList = ServerConnector.getServerConnector().getForumController().getQuestionTopics(section, category);
                                jPanel3.removeAll();
                                for (final String topic : topicList) {
                                    JXHyperlink topicBtn = new JXHyperlink();
                                    topicBtn.setText(topic);
                                    topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
                                    //topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
                                    jPanel3.add(topicBtn);
                                    jPanel3.repaint();
                                    jPanel3.revalidate();

                                    topicBtn.addActionListener(new ActionListener() {
                                        String s = sec;
                                        String c = cat;
                                        String t = topic;

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            questionPanel.setVisible(true);
                                            myAnsPanel.setVisible(true);
                                            jPanel2.revalidate();
                                            jPanel2.repaint();
                                            jPanel2.removeAll();
                                            descLabel.setText("");
                                            topicLabel.setText("");
                                            
                                            try {
                                                final Question q = ServerConnector.getServerConnector().getForumController().getQuestion(s, c, t);
                                                currentQuestion = q;
                                                curSec = s;
                                                curCat = c;
                                                jPanel2.removeAll();
                                                for (Answer answer : q.getAnswers()) {
                                                    area = new JTextArea("ANS by: " + answer.getUsername() + "\n" + "Desc :" + answer.getDescription());
                                                    area.setFont(new java.awt.Font("Arial", 0, 18));
                                                //JScrollPane scrollArea = new JScrollPane(area);

                                                    //jTextArea1.setText("DESCRIPTION: " + q.getDescription());
                                                    descLabel.setText("DESCRIPTION: " + q.getDescription());
                                                    descLabel.setFont(new java.awt.Font("Arial", 0, 24));
                                                    topicLabel.setText("TOPIC by: " + q.getUsername() + ">>" + t);
                                                    topicLabel.setFont(new java.awt.Font("Arial", 0, 16));
                                                    jPanel2.add(area);
                                                    jPanel2.revalidate();
                                                    jPanel2.repaint();
                                                    area.setAutoscrolls(true);
                                                    
                                                    setVisible(false);
                                                }
                                            } catch (NotBoundException ex) {
                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (MalformedURLException ex) {
                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (Exception ex) {
                                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    });

                                }
                            } catch (NotBoundException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                }

            } catch (NotBoundException ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
            }
            /////////////
        } catch (RemoteException ex) {
            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nextButton2ActionPerformed

    private void nextButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton3ActionPerformed

        /*Question q4 = new Question("supun", "exception hadling", "what is exception?");
        

         FileSystem.save(q4, "Remoting", "RMI");*/
        final Question q = new Question(startNameTextField.getText(), qustionTopTextField.getText(), queDesTextArea.getText());
        System.out.println("1" + "sec :" + curSec + "cat :" + curCat);
        if (curSec != null && curCat != null) {
            if (!startNameTextField.getText().equals("") & !qustionTopTextField.getText().equals("") & !queDesTextArea.getText().equals("")) {
                System.out.println("2" + "sec :" + curSec + "cat :" + curCat);

                Runnable runnable = new Runnable() {
                    public void run() {
                        try {
                            try {
                                ServerConnector.getServerConnector().getForumController().notifyNewQuestionObserve(startNameTextField.getText(), qustionTopTextField.getText(), queDesTextArea.getText());
                            } catch (RemoteException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                System.out.println("cat" + curCat + "sec " + curSec);
                                //ServerConnector.getServerConnector().getForumController().save(q, "Remoting", "RMI");
                                ServerConnector.getServerConnector().getForumController().save(q, curSec, curCat);

                                //descLabel.setText("DESCRIPTION: " + q.getDescription());
                                //descLabel.setFont(new java.awt.Font("Arial", 0, 24));
                                //topicLabel.setText("TOPIC by: " + q.getUsername() + ">>" + qustionTopTextField.getText());
                                //topicLabel.setFont(new java.awt.Font("Arial", 0, 18));
                                System.out.println("by :" + q.getUsername());
                                System.out.println("tpoic :" + q.getTopic());
                                System.out.println("desct :" + q.getDescription());
                                ////////////////////////

                                try {
                                    sections = ServerConnector.getServerConnector().getForumController().getSections();
                                    final String section = sections.get(3);

                                    catogeryList = ServerConnector.getServerConnector().getForumController().getCategories(section);
                                    jPanel1.removeAll();
                                    for(final String category : catogeryList) {
                                        final JXHyperlink button = new JXHyperlink();
                                        button.setText(category);
                                        button.setFont(new java.awt.Font("Arial", 0, 24));
                                        jPanel1.add(button);
                                        jPanel1.revalidate();
                                        jPanel1.repaint();

                                        button.addActionListener(new ActionListener() {
                                            String sec = section;
                                            String cat = category;

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                jPanel2.revalidate();
                                                jPanel2.repaint();
                                                jPanel2.removeAll();
                                                descLabel.setText("");
                                                topicLabel.setText("");
                                                try {
                                                    topicList = ServerConnector.getServerConnector().getForumController().getQuestionTopics(section, category);
                                                    jPanel3.removeAll();
                                                    for (final String topic : topicList) {
                                                        JXHyperlink topicBtn = new JXHyperlink();
                                                        topicBtn.setText(topic);
                                                        topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
                                                        //topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
                                                        jPanel3.add(topicBtn);
                                                        jPanel3.repaint();
                                                        jPanel3.revalidate();

                                                        topicBtn.addActionListener(new ActionListener() {
                                                            String s = sec;
                                                            String c = cat;
                                                            String t = topic;

                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                questionPanel.setVisible(true);
                                                                myAnsPanel.setVisible(true);
                                                                jPanel2.revalidate();
                                                                jPanel2.repaint();
                                                                jPanel2.removeAll();
                                                                descLabel.setText("");
                                                                topicLabel.setText("");
                                                                try {
                                                                    final Question q = ServerConnector.getServerConnector().getForumController().getQuestion(s, c, t);
                                                                    currentQuestion = q;
                                                                    curSec = s;
                                                                    curCat = c;
                                                                     jPanel2.removeAll();
                                                                    for (Answer answer : q.getAnswers()) {
                                                                        area = new JTextArea("ANS by: " + answer.getUsername() + "\n" + "Desc :" + answer.getDescription());
                                                                        area.setFont(new java.awt.Font("Arial", 0, 18));
                                                //JScrollPane scrollArea = new JScrollPane(area);
                                                                        

                                                                        //jTextArea1.setText("DESCRIPTION: " + q.getDescription());
                                                                        descLabel.setText("DESCRIPTION: " + q.getDescription());
                                                                        System.out.println("desc"+q.getDescription());
                                                                        descLabel.setFont(new java.awt.Font("Arial", 0, 24));
                                                                        topicLabel.setText("TOPIC by: " + q.getUsername() + ">>" + t);
                                                                        topicLabel.setFont(new java.awt.Font("Arial", 0, 16));
                                                                        jPanel2.add(area);
                                                                        jPanel2.revalidate();
                                                                        jPanel2.repaint();
                                                                        area.setAutoscrolls(true);
                                                                    }
                                                                } catch (NotBoundException ex) {
                                                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                                                } catch (MalformedURLException ex) {
                                                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                                                } catch (Exception ex) {
                                                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                                                }
                                                            }
                                                        });

                                                    }
                                                } catch (NotBoundException ex) {
                                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (MalformedURLException ex) {
                                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (Exception ex) {
                                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        });

                                    }

                                } catch (NotBoundException ex) {
                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception ex) {
                                    Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                //////////////////////
                            } catch (RemoteException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (NotBoundException ex) {
                            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FundamentalsForum.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        startNameTextField.setText("");
                        qustionTopTextField.setText("");
                        queDesTextArea.setText("");
                    }
                };
                t = new Thread(runnable);

                t.start();
            }
        }
    }//GEN-LAST:event_nextButton3ActionPerformed

    private void qustionTopTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qustionTopTextFieldActionPerformed
        queDesTextArea.requestFocus();
    }//GEN-LAST:event_qustionTopTextFieldActionPerformed

    private void queDesTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queDesTextAreaKeyTyped
        if (!startNameTextField.getText().equals("") & !qustionTopTextField.getText().equals("") & !queDesTextArea.getText().equals("")) {
            nextButton3.setEnabled(true);
        }
    }//GEN-LAST:event_queDesTextAreaKeyTyped

    private void startNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startNameTextFieldActionPerformed
        qustionTopTextField.requestFocus();
    }//GEN-LAST:event_startNameTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        descTextField.requestFocus();
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void descTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTextFieldKeyTyped
        nextButton2.setEnabled(true);
    }//GEN-LAST:event_descTextFieldKeyTyped
    Thread t;

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
            java.util.logging.Logger.getLogger(FundamentalsForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FundamentalsForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FundamentalsForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FundamentalsForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FundamentalsForum dialog = new FundamentalsForum(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel myAnsPanel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton nextButton2;
    private javax.swing.JButton nextButton3;
    private javax.swing.JTextArea queDesTextArea;
    private org.jdesktop.swingx.JXPanel questionPanel;
    private javax.swing.JTextField qustionTopTextField;
    private javax.swing.JTextField startNameTextField;
    private javax.swing.JLabel topicLabel;
    // End of variables declaration//GEN-END:variables

    public void displayMessage(String name, String message, String desc, String topic) {
        System.out.println("true" + "Name" + name + "mee" + message);
        area = new JTextArea("ANS by: " + name + "\n" + "Desc :" + message);
        area.setFont(new java.awt.Font("Arial", 0, 18));
        //JOptionPane.showMessageDialog(rootPane, "ANS by: " + name + "\n" + "Desc :" + message);

        descLabel.setText("DESCRIPTION: " + desc);
        descLabel.setFont(new java.awt.Font("Arial", 0, 24));
        topicLabel.setText("TOPIC by: " + topic + ">>" + t);
        topicLabel.setFont(new java.awt.Font("Arial", 0, 16));
        jPanel2.add(area);
        jPanel2.revalidate();
        jPanel2.repaint();
        area.setAutoscrolls(true);
    }

    public void displayQuestionMessage(String name, String topic, String desc) {
        JXHyperlink topicBtn = new JXHyperlink();
        topicBtn.setText(topic);
        topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
        //topicBtn.setFont(new java.awt.Font("Arial", 0, 20));
        System.out.println("yahh");
        jPanel3.add(topicBtn);
        jPanel3.repaint();
        jPanel3.revalidate();
    }

}
