/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

import connector.ServerConnector;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import models.Answer;
import models.Question;
import view.ExamRegistrationForm;

/**
 *
 * @author Supun
 */
public class OOPForum extends javax.swing.JDialog {

    private List<String> catogeryList;
    private List<String> topicList;

    Question currentQuestion;
    String curSec;
    String curCat;
    /**
     * Creates new form ForumCat
     */
    public OOPForum(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanel1.setLayout(new GridLayout(10, 1));
        jPanel2.setLayout(new GridLayout(10, 1));
        jPanel3.setLayout(new GridLayout(10, 1));
        List<String> sections;
//        try {
//            try {
//                forumController = ServerConnector.getServerConnector().getForumController().getSections();
//
//                for (int j = 0; j < 1; j++) {
//                    final String str1 = forumController.get(1);
//                    System.out.println("str1" + str1);
//                    // List<String> cat = FileSystem.getCategories(str1);
//                    List<String> cat = ServerConnector.getServerConnector().getForumController().getCategories(str1);
//                    for (final String str2 : cat) {
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
            final String section = sections.get(0);

            catogeryList = ServerConnector.getServerConnector().getForumController().getCategories(section);
            jPanel1.removeAll();
            for (final String category : catogeryList) {
                final JButton button = new JButton(category);
                jPanel1.add(button);
                jPanel1.revalidate();
                jPanel1.repaint();

                button.addActionListener(new ActionListener() {
                    String sec = section;
                    String cat = category;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            topicList = ServerConnector.getServerConnector().getForumController().getQuestionTopics(section, category);
                            jPanel3.removeAll();
                            for (final String topic : topicList) {
                                JButton topicBtn = new JButton(topic);
                                jPanel3.add(topicBtn);
                                jPanel3.repaint();
                                jPanel3.revalidate();

                                topicBtn.addActionListener(new ActionListener() {
                                    String s = sec;
                                    String c = cat;
                                    String t = topic;

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            final Question q = ServerConnector.getServerConnector().getForumController().getQuestion(s, c, t);
                                            currentQuestion = q;
                                            curSec = s;
                                            curCat = c;
                                            jPanel2.removeAll();
                                            for (Answer answer : q.getAnswers()) {
                                                JTextArea area = new JTextArea("ANS by: " + answer.getUsername() + "\n");
                                                //jTextArea1.setText("DESCRIPTION: " + q.getDescription());
                                                descLabel.setText("DESCRIPTION: " + q.getDescription());
                                                topicLabel.setText("TOPIC by: " + q.getUsername() + "::" + t);
                                                jPanel2.add(area);
                                                jPanel2.revalidate();
                                                jPanel2.repaint();
                                            }
                                        } catch (NotBoundException ex) {
                                            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (MalformedURLException ex) {
                                            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (Exception ex) {
                                            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

                            }
                        } catch (NotBoundException ex) {
                            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            }

        } catch (NotBoundException ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
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

        topicLabel = new javax.swing.JLabel();
        descTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        descLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addComponent(descTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(topicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(descTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(427, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

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
        } catch (RemoteException ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(OOPForum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    

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
            java.util.logging.Logger.getLogger(OOPForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OOPForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OOPForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OOPForum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OOPForum dialog = new OOPForum(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField descTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel topicLabel;
    // End of variables declaration//GEN-END:variables
}
