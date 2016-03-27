/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;

/**
 *
 * @author Supun
 */
public class QuestionController {

    public static final String root = "G:\\ExamLab Project\\ExamSimulatorServer\\file\\question";

    static {
        File rootdir = new File(root);

        if (!rootdir.isDirectory()) {
            if (rootdir.isFile()) {
                rootdir.delete();
            }
            rootdir.mkdirs();
        }
    }

    public static List<String> getTopics() {
        File rootDir = new File(root);

        String[] topics = rootDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isDirectory();
            }
        });

        return Arrays.asList(topics);
    }

    public static List<String> getQuestions(String topic) {
        File sectionDir = new File(root + "/" + topic);

        String[] categories = sectionDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isDirectory();
            }
        });

        return Arrays.asList(categories);
    }

    public static List<String> getQuestions1(String topic, String section) {

        File categoryDir = new File(root + "/" + topic + "/" + section);

        String[] topics = categoryDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isFile();
            }
        });

        return Arrays.asList(topics);
    }

    public static List<String> getAnswer(String topic, String ansSection) {

        File categoryDir = new File(root + "/" + topic + "/" + ansSection);

        String[] topics = categoryDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isFile();
            }
        });

        return Arrays.asList(topics);
    }

    public static List<String> getAnswer1(String topic, String ansSection) {
        File categoryDir = new File(root + "/" + topic + "/" + ansSection);

        String[] topics = categoryDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isFile();
            }
        });

        return Arrays.asList(topics);
    }

    /*Writer output = null;
     String text = "Rajesh Kumar";
     File file = new File("write.txt");
     output = new BufferedWriter(new FileWriter(file));
     output.write(text);
     output.close();
     System.out.println("Your file has been written");  */
    public static void saveQuestion(String cont, String name,
            String topic,
            String section) {
        try {
            Writer output = null;
            String text = cont;
            //File file = new File("write.txt");

            //System.out.println("Your file has been written");

            String questionDir = root + "/" + topic + "/" + section + "/" + name;
            
            
            
            File dir = new File(questionDir);
            output = new BufferedWriter(new FileWriter(dir));
            output.write(text);
            output.close();
            //dir.mkdirs();

//        String questionFile = questionDir + "/" + question.getTopic();
//
//        Serializer.serialize(question, questionFile);
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveAnswer(String cont, String name,
            String topic,
            String section) {
        try {
            Writer output = null;
            String text = cont;
            //File file = new File("write.txt");

            System.out.println("Your file has been written");

            String questionDir = root + "/" + topic + "/" + section + "/" + name;
            File dir = new File(questionDir);
            output = new BufferedWriter(new FileWriter(dir));
            output.write(text);
            output.close();
            //  dir.mkdirs();

//        String questionFile = questionDir + "/" + question.getTopic();
//
//        Serializer.serialize(question, questionFile);
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
