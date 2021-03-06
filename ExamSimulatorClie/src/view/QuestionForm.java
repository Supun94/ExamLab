package view;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;
import connector.ServerConnector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Question;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Supun
 */
public class QuestionForm extends javax.swing.JFrame {

    Set<Integer> listOfRandom = new HashSet<Integer>();
    public static int question;
    Random random = new Random();
    ArrayList<Integer> randomArray = new ArrayList<>();
    Integer ar[] = new Integer[60];
    int Low = 1;
    int High = 60;
    int x;
    //int lastElement = Iterables.getLast(iterableList);
    /**
     * Creates new form MyForm
     */
    public QuestionForm() {

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        submitTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textField = new org.jdesktop.swingx.JXTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        textField.setColumns(20);
        textField.setRows(5);
        jScrollPane1.setViewportView(textField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(submitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitButton))
                        .addGap(15, 15, 15)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        try {
            question = random.nextInt(High - Low) + Low;
            if (!randomArray.contains(question) & (question != 0)) {
                randomArray.add(question);

                if (!randomArray.isEmpty()) {
                    x = randomArray.get(randomArray.size() - 1);
                    System.out.println(x);
                }

            }

            Question q = new Question(x);
            try {

//                File file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion1(q);
//
//                QuestionForm.textField.read(new FileReader(file), null);
                
                String file = ServerConnector.getServerConnector().getQuestionController().newNextQuestion1(q);
                        

                        textField.setText(file);

            } catch (NotBoundException | MalformedURLException ex) {
                Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
            }

             // MyForm.textField.read(new FileReader("Question" + x + ".txt"), null);
            //MyForm.textField.read(new FileReader("G:\\ExamLab Project\\ExamSimulatorClient\\src\\file\\question\\Question" + x + ".txt"), null);
        } catch (IOException ex) {
            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_nextButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            if (question == 0) {
                JOptionPane.showMessageDialog(null, "You are complete the exam");
                nextButton.setEnabled(false);
            }
            question -= 1;
            //System.out.println("2");
            QuestionForm.textField.read(new FileReader("G:\\ExamLab Project\\ExamSimulatorClient\\src\\file\\question\\Question" + question + ".txt"), null);

        } catch (IOException ex) {
            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        BufferedReader bufferedReader = null;

        String submit = submitTextField.getText().toUpperCase().trim();
        String answer = "";
        try {

            bufferedReader = new BufferedReader(new FileReader("G:\\ExamLab Project\\ExamSimulatorClient\\src\\file\\question\\Question" + question + ".txt"));
            String line = "";
            String concat = null;
            Pattern pattern = Pattern.compile(answer);

            Matcher matcher;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        concat = line;
                        System.out.println(line);
                        if (line.equalsIgnoreCase(submit)) {
                            System.out.println("true");
                        } else {
                            System.out.println("false");
                        }
                        break;
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(QuestionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_submitButtonActionPerformed

    int restrictOfRandomDuplicating() {
        Random r = new Random();

        while (true) {
            int value = r.nextInt(30) + 1;
            boolean isExceed = true;
            for (int i = 0; i < 1; i++) {
                if (ar[i] == value) {
                    isExceed = false;
                    break;
                }
            }
            if (isExceed == true) {
                sortRandom(value);
            }
            if (randomArray.size() == 30) {
                break;
            }
            for (Integer integer : randomArray) {
                question = integer;

            }
        }
        return question;

    }

    private void sortRandom(int val) {
        randomArray.add(val);
        ar[randomArray.size() - 1] = val;
        question = val;
        System.out.println(question + "");
    }

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
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField submitTextField;
    public static org.jdesktop.swingx.JXTextArea textField;
    // End of variables declaration//GEN-END:variables
}
