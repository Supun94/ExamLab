  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Question;

/**
 *
 * @author Supun
 */
public class QuestionFileAccess {

    int count = 0;

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public boolean nextQuestion(int question) throws IOException {
        try {
            lock.writeLock().lock();
            int q = question;
            //File file = new File("./Question"+q+".txt");
            //textField.read(new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + x + ".txt"), null);
            FileReader fileReader = new FileReader(".//file//question//Question" + q + ".txt");
            return true;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//RealQuestions//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion1(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Collection Framework Generics//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion2(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Date Number Currency//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion3(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Development//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion4(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Exception Assertion//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion5(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//File IO , Serialization//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion6(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Flow Control//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion7(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Formatting Tokenizing//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion8(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Garbage Collector//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion9(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Inner Classes//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion10(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Interface Var-Args Enum//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion11(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Java Fundamentals, Primitive Data Types Arrays//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion12(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Modifiers Access,Non Access//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion13(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Object Orientation//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion14(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Objects, Variable, Methods//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion15(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//String, String Buffer, String Builder//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion16(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Threads//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public String newNextQuestion17(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Wrapper Classes//question//Question" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat1() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Collection Framework Generics//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat2() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Date Number Currency//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat3() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Development//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat4() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Exception Assertion//question");
            return file.listFiles().length;
            
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat5() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//File IO , Serialization//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat6() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Flow Control//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat7() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Formatting Tokenizing//question");
            return file.listFiles().length;
            
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat8() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Garbage Collector//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat9() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Inner Classes//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat10() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Interface Var-Args Enum//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat11() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Java Fundamentals, Primitive Data Types Arrays//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat12() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Modifiers Access,Non Access//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat13() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Object Orientation//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat14() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Objects, Variable, Methods//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat15() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//String, String Buffer, String Builder//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat16() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Threads//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public int countCat17() throws IOException {
        try {
            lock.writeLock().lock();
            File file = new File(".//file//question//Wrapper Classes//question");
            return file.listFiles().length;
        } finally {
            lock.writeLock().unlock();
        }

    }

    //            else if(cat==2){
//             File fileData = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Date Number Currency//question//Question" + question + ".txt");   
//             return fileData;
//            }else if(cat==3){
//                File fileDev = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Development//question//Question" + question + ".txt");
//            return fileDev;
//            }else if(cat==4){
//                File fileExc = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Exception Assertion//question//Question" + question + ".txt");
//            return fileExc;
//            }else if(cat==5){
//                File fileIo = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//File IO , Serialization//question//Question" + question + ".txt");
//            return fileIo;
//            }else if(cat==6){
//                File fileFlow = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Flow Control//question//Question" + question + ".txt");
//            return fileFlow;
//            }else if(cat==7){
//                File fileFormat = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Formatting Tokenizing//question//Question" + question + ".txt");
//            return fileFormat;
//            }else if(cat==8){
//                File fileGar = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Garbage Collector//question//Question" + question + ".txt");
//            return fileGar;
//            }else if(cat==9){
//               File fileInner = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Inner Classes//question//Question" + question + ".txt");
//            return fileInner;
//
//            }else if(cat==10){
//               
//                File fileInterface = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Interface Var-Args Enum//question//Question" + question + ".txt");
//            return fileInterface;
//            }else if(cat==11){
//                File fileFunda = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Java Fundamentals, Primitive Data Types Arrays//question//Question" + question + ".txt");
//            return fileFunda;
//            }else if(cat==12){
//                File fileModi = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Modifiers Access,Non Access//question//Question" + question + ".txt");
//            return fileModi;
//            }else if(cat==13){
//                File fileOOp = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Object Orientation//question//Question" + question + ".txt");
//            return fileOOp;
//            }else if(cat==14){
//               File fileObj = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Objects, Variable, Methods//question//Question" + question + ".txt");
//            return fileObj;
//
//           }else if(cat==15){
//                File fileSt = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//String, String Buffer, String Builder//question//Question" + question + ".txt");
//           return  fileSt;
//           }else if(cat==16){
//                File fileThr = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Threads//question//Question" + question + ".txt");
//            return fileThr;
//            }else if(cat==17){
//                File fileWrap = new File("G://ExamLab Project//ExamSimulatorServer//src//file//question//Wrapper Classes//question//Question" + question + ".txt");
//            return fileWrap;
//            }
//        
    public boolean submitAnswer(Question q, String submitAnswer) throws IOException {

//        lock.writeLock().lock();
//        int question = q.getQuestionNumber();
//        System.out.println(q);
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("G://ExamLab Project//ExamSimulatorServer//file//realanswer//Answer" + question + ".txt"));
//        String line = "";
//        String concat = null;
//        String answer = "";
//        Pattern pattern = Pattern.compile(answer);
//
//        Matcher matcher;
//        try {
//            while ((line = bufferedReader.readLine()) != null) {
//                matcher = pattern.matcher(line);
//                if (matcher.find()) {
//                    concat = line;
//                    System.out.println(line);
//                    if (line.equalsIgnoreCase(submitAnswer)) {
//                        count = count + 1;
//                        System.out.println("qurrect answers count: " + count);
//                        System.out.println("true");
//                    } else {
//                        System.out.println("qurrect answers count: " + count);
//                        System.out.println("false");
//                    }
//                    break;
//                }
//
//            }
//        } finally {
//            try {
//                bufferedReader.close();
//            } catch (IOException ex) {
//                Logger.getLogger(QuestionFileAccess.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }  //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    public String submitMyAnswer(Question q) throws IOException {

//                BufferedReader bufferedReader = null;
//        try {
//            lock.writeLock().lock();
//            int question = q.getQuestionNumber();
//            System.out.println(q);
//            bufferedReader = new BufferedReader(new FileReader("G://ExamLab Project//ExamSimulatorServer//src//file//realanswer//Answer" + question + ".txt"));
//            //String is=bufferedReader.readLine();
//            //return bufferedReader;
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(QuestionFileAccess.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                bufferedReader.close();
//            } catch (IOException ex) {
//                Logger.getLogger(QuestionFileAccess.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return bufferedReader;
//        
//        
//    }
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//RealAnswers//Answer" + question + ".txt");
            //textField.read(new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + x + ".txt"), null);
            //FileReader fileReader = new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + question + ".txt");
            //return fileReader;
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String submitMyAnswer1(Question q) throws IOException {

        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Collection Framework Generics//realanswer//Answer" + question + ".txt");
            //textField.read(new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + x + ".txt"), null);
            //FileReader fileReader = new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + question + ".txt");
            //return fileReader;
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String submitMyAnswer2(Question q) throws IOException {

        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Date Number Currency//realanswer//Answer" + question + ".txt");
            //textField.read(new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + x + ".txt"), null);
            //FileReader fileReader = new FileReader("G://ExamLab Project//ExamSimulatorClient//src//file//question//Question" + question + ".txt");
            //return fileReader;
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String submitMyAnswer3(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Development//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer4(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Exception Assertion//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer5(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//File IO , Serialization//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer6(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Flow Control//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer7(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Formatting Tokenizing//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer8(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Garbage Collector//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer9(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Inner Classes//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer10(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Interface Var-Args Enum//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer11(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Java Fundamentals, Primitive Data Types Arrays//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer12(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Modifiers Access,Non Access//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer13(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Object Orientation//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer14(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Objects, Variable, Methods//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer15(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//String, String Buffer, String Builder//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer16(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Threads//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public String submitMyAnswer17(Question q) throws IOException {
        try {
            lock.writeLock().lock();
            int question = q.getQuestionNumber();
            System.out.println("Question numn " + question);
            File file = new File(".//file//question//Wrapper Classes//realanswer//Answer" + question + ".txt");
            final FileReader fileReader = new FileReader(file);

            String ques = "";
            while (fileReader.ready()) {
                ques += (char) fileReader.read();
            }
            return ques;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
