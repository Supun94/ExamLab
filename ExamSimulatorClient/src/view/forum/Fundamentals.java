/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forum;

import connector.ServerConnector;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import models.Answer;
import models.Question;
//import sun.dc.pr.PathStroker;
import view.ExamRegistrationForm;

/**
 *
 * @author Supun
 */
public class Fundamentals extends javax.swing.JDialog {
    private String namess="DESCRIPTION: ";
    /**
     * Creates new form ForumCat
     */
    public Fundamentals(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanel1.setLayout(new GridLayout(10, 1));
        jPanel2.setLayout(new GridLayout(10, 1));
        jPanel3.setLayout(new GridLayout(10, 1));
        List<String> forumController;
        try {
            try {
                forumController = ServerConnector.getServerConnector().getForumController().getSections();

                for (int j = 0; j < 1; j++) {
                    final String str1 = forumController.get(1);
                    // List<String> cat = FileSystem.getCategories(str1);
                    List<String> cat = ServerConnector.getServerConnector().getForumController().getCategories(str1);
                    for (final String str2 : cat) {

                        JButton button = new JButton(str2);
                        jPanel1.add(button);
                        jPanel1.validate();
                        jPanel1.repaint();

                        button.addActionListener(new java.awt.event.ActionListener() {

                            /*List<String> top = FileSystem.getQuestionTopics(str1, str2);
                             for (String str3 : top) {
                             Question q = FileSystem.getQuestion(str1, str2, str3);
                             System.out.println("\t\tTOPIC by: " + q.getUsername() + "::" + str3);
                             System.out.println("\t\tDESCRIPTION: " + q.getDescription());
                             for (Answer ans : q.getAnswers()) {
                             System.out.println("\t\t\tANS by: " + ans.getUsername() + "::" + ans.getDescription());
                             }
                             }*/
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //List<String> top = FileSystem.getQuestionTopics(str1, str2);
                                try {
                                    List<String> top = ServerConnector.getServerConnector().getForumController().getQuestionTopics(str1, str2);
                                    for (final String str3 : top) {
                                        //final Question q = FileSystem.getQuestion(str1, str2, str3);
                                        final Question q = ServerConnector.getServerConnector().getForumController().getQuestion(str1, str2, str3);
                          //  System.out.println("\t\tTOPIC by: " + q.getUsername() + "::" + str3);
                                        //      System.out.println("\t\tDESCRIPTION: " + q.getDescription());
                                        saveButton.addActionListener(new java.awt.event.ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                try {
                                                    q.getAnswers().add(new Answer(nameTextField.getText(), descTextField.getText()));
                                                    try {
                                                        ServerConnector.getServerConnector().getForumController().save(q, str1, str2);
                                                    } catch (RemoteException ex) {
                                                        Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
                                                    } catch (ClassNotFoundException ex) {
                                                        Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
                                                    } catch (SQLException ex) {
                                                        Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                } catch (NotBoundException ex) {
                                                    Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (MalformedURLException ex) {
                                                    Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        });
                                       final JButton button = new JButton(str3);
                                        jPanel3.add(button);
                                        jPanel3.revalidate();
                                        jPanel3.repaint();
                                        button.addActionListener(new java.awt.event.ActionListener() {
                                //jTextArea1.setText("\t\tTOPIC by: " + q.getUsername() + "::" + str3);
                                            // jTextArea1.setText("\t\tDESCRIPTION: " + q.getDescription());

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                jPanel2.removeAll();
                                                jTextArea1.removeAll();
                                                jLabel1.removeAll();
                                                for (Answer ans : q.getAnswers()) {
                                                    System.out.println("\t\t\tANS by: " + ans.getUsername() + "::" + ans.getDescription());
                                        //jTextArea1.setText("\t\tTOPIC by: " + q.getUsername() + "::" + str3+"\t\t\tANS by: " + ans.getUsername() + "::" + ans.getDescription()+"\t\tDESCRIPTION: " + q.getDescription());
                                                    //jTextArea1.append("\t\tTOPIC by: " + q.getUsername() + "\n" + "::" + str3 + "\t\t\tANS by: " + ans.getUsername() + "\n" + "::" + ans.getDescription() + "\t\tDESCRIPTION: " + q.getDescription() + "\n");
                                                    JTextArea area = new JTextArea("ANS by: " + ans.getUsername() + "\n");
                                                    jTextArea1.setText("DESCRIPTION: " + q.getDescription());
                                                    jLabel1.setText("TOPIC by: " + q.getUsername() + "::" + str3);
                                                    jPanel2.add(area);
                                                    jPanel2.validate();
                                                    jPanel2.repaint();
                                                    namess=button.getText();
                                                    System.out.println(namess);

                                                }

                                            }
                                        });
                                    }

                                } catch (NotBoundException | MalformedURLException | RemoteException | ClassNotFoundException | SQLException ex) {
                                    Logger.getLogger(ExamRegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        });
                    }
                }

            } catch (RemoteException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NotBoundException | MalformedURLException ex) {
            Logger.getLogger(Fundamentals.class.getName()).log(Level.SEVERE, null, ex);
        }

        //List<String> sect = FileSystem.getSections();
        //for (String str1 : sect) {
//
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(jScrollPane2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(481, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addComponent(descTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(descTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Fundamentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fundamentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fundamentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fundamentals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fundamentals dialog = new Fundamentals(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField descTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
