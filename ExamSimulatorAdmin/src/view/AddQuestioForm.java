/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.QuestionController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import org.jdesktop.swingx.JXHyperlink;

/**
 *
 * @author Supun
 */
public class AddQuestioForm extends javax.swing.JDialog {

    private final List<String> topicList;
    private List<String> questionList;
    private List<String> questionList1;
    private List<String> answerList;
    private List<String> answerList1;

    String question;
    //String topic;
    String section;
    String ansSection;
    String txt;
    String currentLink;
    String currentTopic;

    /**
     * Creates new form AddQuestioForm
     */
    public AddQuestioForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        topicList = QuestionController.getTopics();

        for (final String topic : topicList) {
            final JXHyperlink button = new JXHyperlink();
            button.setText(topic);
            button.setName(topic);
            System.out.println(topic);
            topicPanel.add(button);
            topicPanel.revalidate();
            topicPanel.repaint();

            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    questionPanel.removeAll();
                    questionList = QuestionController.getQuestions(topic);
                    answerList = QuestionController.getQuestions(topic);
                    currentTopic=button.getName();
                    section = questionList.get(0);
                    ansSection = questionList.get(1);
                    questionList1 = QuestionController.getQuestions1(topic, section);
                    answerList1 = QuestionController.getAnswer1(topic, ansSection);
                    System.out.println(section);
                    System.out.println(ansSection);
                    for (final String question : questionList1) {
                        final JXHyperlink button1 = new JXHyperlink();
                        button1.setText(question);
                        button1.setName(question);
                        //System.out.println(topic);
                        questionPanel.add(button1);
                        questionPanel.revalidate();
                        questionPanel.repaint();

                        //System.out.println("ansSec :"+ansSection);
                        //answerList=QuestionController.getAnswer(topic, ansSection);
                        for (final String answer : answerList1) {
                            //System.out.println("Answer :"+answer);

                            button1.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    try {
                                        answerTextArea.removeAll();
                                        questionTextArea.read(new FileReader("G:\\ExamLab Project\\ExamSimulatorServer\\file\\question\\" + topic + "\\question\\" + question), e);
                                        txt = question;
                                        System.out.println("jjjjj"+txt);
                                        String[] parts = txt.split("Question");
                                        currentLink=button1.getName();
                                    //System.out.println("part"+parts[1]);
                                        //System.out.println("quessss"+"G:\\ExamLab Project\\ExamSimulatorServer\\file\\question\\"+topic+"\\question\\"+question);
                                        answerTextArea.read(new FileReader("G:\\ExamLab Project\\ExamSimulatorServer\\file\\question\\" + topic + "\\realanswer\\Answer" + parts[1]), e);
                                    //System.out.println("ansssss"+"G:\\ExamLab Project\\ExamSimulatorServer\\file\\question\\"+topic+"\\realanswer\\"+answer);
                                        //questionPanel.removeAll();
                                    } catch (IOException ex) {
                                        Logger.getLogger(AddQuestioForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
//                        saveButton.addActionListener(new ActionListener() {
//                                  
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                String txt=question;
//                                    String[] parts = txt.split("Question");
//                                    //System.out.println("part"+parts[1]);
//                                QuestionController.saveQuestion(questionTextArea.getText(),question, topic, section);
//                                QuestionController.saveAnswer(answerTextArea.getText(),"Answer"+parts[1], topic, ansSection);
//                                
//                                
//                                
//                        }
//                        });
                        }

                    }
                    //final String section = sections.get(3);
                }
            });

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

        topicPanel = new javax.swing.JPanel();
        questionPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        topicPanel.setLayout(new org.jdesktop.swingx.VerticalLayout());

        questionPanel.setLayout(new org.jdesktop.swingx.VerticalLayout());

        questionTextArea.setColumns(20);
        questionTextArea.setRows(5);
        jScrollPane1.setViewportView(questionTextArea);

        answerTextArea.setColumns(20);
        answerTextArea.setRows(5);
        jScrollPane2.setViewportView(answerTextArea);

        saveButton.setText("Save");
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
                .addGap(89, 89, 89)
                .addComponent(topicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(293, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(topicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //txt = question;
        //System.out.println("nnnnn"+question);
        String[] parts = currentLink.split("Question");
        //System.out.println("part"+parts[1]);
        System.out.println("ddd"+parts[1]);
        QuestionController.saveQuestion(questionTextArea.getText(), "Question"+parts[1], currentTopic, section);
        QuestionController.saveAnswer(answerTextArea.getText(), "Answer" + parts[1], currentTopic, ansSection);

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
            java.util.logging.Logger.getLogger(AddQuestioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddQuestioForm dialog = new AddQuestioForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea answerTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JTextArea questionTextArea;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel topicPanel;
    // End of variables declaration//GEN-END:variables
}
