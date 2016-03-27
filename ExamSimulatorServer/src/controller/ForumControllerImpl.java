/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FilenameFilter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import models.Question;
import observer.ForumAnswerObserverController;
import obsrveble.ForumObserveble;
import util.Serializer;


/**
 *
 * @author Supun
 */
public class ForumControllerImpl extends UnicastRemoteObject implements ForumController {

    private static ForumObserveble observeble = new ForumObserveble();
    ForumControllerImpl() throws RemoteException {
            
    }
    public static final String root = ".//forum";
    public static final String root1 = ".\\forum\\Fundamentals";
    public static final String root1i = ".\\forum\\Fundamentals\\Variables";
    public static final String root1ii = ".\\forum\\Fundamentals\\Data Types";
    public static final String root1iii = ".\\forum\\Fundamentals";
    public static final String root1iv = ".\\forum\\Fundamentals";
    public static final String root2 = ".\\forum\\Object Orientation";
    public static final String root2i = ".\\forum\\Object Orientation";
    public static final String root2ii = ".\\forum\\Object Orientation";
    public static final String root2iii = ".\\forum\\Object Orientation";
    public static final String root2iv = ".\\forum\\Object Orientation";
    public static final String root3 = ".\\forum\\Collection Framework Generics";
    public static final String root3i = ".\\forum\\Collection Framework Generics";
    public static final String root3ii = ".\\forum\\Collection Framework Generics";
    public static final String root3iii = ".\\forum\\Collection Framework Generics";
    public static final String root3iv = ".\\forum\\Collection Framework Generics";
    public static final String root4 = ".\\forum\\Threads";
    public static final String root4i = ".\\forum\\Threads";
    public static final String root4ii = ".\\forum\\Threads";
    public static final String root4iii = ".\\forum\\Threads";
    public static final String root4iv = ".\\forum\\Threads";
    public static final String root5 = ".\\forum\\File IO , Serialization";
    public static final String root5i = ".\\forum\\File IO , Serialization";
    public static final String root5ii = ".\\forum\\File IO , Serialization";
    public static final String root5iii = ".\\forum\\File IO , Serialization";
    public static final String root5iv = ".\\forum\\File IO , Serialization";
    public static final String root6 = ".\\forum\\Interface Var-Args Enum";
    public static final String root6i = ".\\forum\\Interface Var-Args Enum";
    public static final String root6ii = ".\\forum\\Interface Var-Args Enum";
    public static final String root6iii = ".\\forum\\Interface Var-Args Enum";
    public static final String root6iv = ".\\forum\\Interface Var-Args Enum";
    public static final String root7 = ".\\forum\\Exception Assertion";
    public static final String root7i = ".\\forum\\Exception Assertion";
    public static final String root7ii = ".\\forum\\Exception Assertion";
    public static final String root7iii = ".\\forum\\Exception Assertion";
    public static final String root7iv = ".\\forum\\Exception Assertion";
    public static final String root8 = ".\\forum\\Others";
    public static final String root8i = ".\\forum\\Others";
    public static final String root8ii = ".\\forum\\Others";
    public static final String root8iii = ".\\forum\\Others";
    public static final String root8iv = ".\\forum\\Others";
    public static final String root8v = ".\\forum\\Others";
    public static final String root8vi = ".\\forum\\Others";
    
    

    static {
        File rootdir = new File(root);
        File rootdir1 = new File(root1);
        File rootdir1i = new File(root1i);
        File rootdir1ii = new File(root1ii);
        File rootdir1iii = new File(root1iii);
        File rootdir1iv = new File(root1iv);
        File rootdir2 = new File(root2);
        File rootdir2i = new File(root2i);
        File rootdir2ii = new File(root2ii);
        File rootdir2iii = new File(root2iii);
        File rootdir2iv = new File(root2iv);
        File rootdir3 = new File(root3);
        File rootdir3i = new File(root3i);
        File rootdir3ii = new File(root3ii);
        File rootdir3iii = new File(root3iii);
        File rootdir3iv = new File(root3iv);
        File rootdir4 = new File(root4);
        File rootdir4i = new File(root4i);
        File rootdir4ii = new File(root4ii);
        File rootdir4iii = new File(root4iii);
        File rootdir4iv = new File(root4iv);
        File rootdir5 = new File(root5);
        File rootdir5i = new File(root5i);
        File rootdir5ii = new File(root5ii);
        File rootdir5iii = new File(root5iii);
        File rootdir5iv = new File(root5iv);
        File rootdir6 = new File(root6);
        File rootdir6i = new File(root6i);
        File rootdir6ii = new File(root6ii);
        File rootdir6iii = new File(root6iii);
        File rootdir6iv = new File(root6iv);
        File rootdir7 = new File(root7);
        File rootdir7i = new File(root7i);
        File rootdir7ii = new File(root7ii);
        File rootdir7iii = new File(root7iii);
        File rootdir7iv = new File(root7iv);
        File rootdir8 = new File(root8);
        File rootdir8i = new File(root8i);
        File rootdir8ii = new File(root8ii);
        File rootdir8iii = new File(root8iii);
        File rootdir8iv = new File(root8iv);
        File rootdir8v = new File(root8v);
        File rootdir8vi = new File(root8vi);
        
        if (!rootdir.isDirectory()) {
            if (rootdir.isFile()) {
                rootdir.delete();
            }
            rootdir.mkdirs();
        }
        if (!rootdir1.isDirectory()) {
            if (rootdir1.isFile()) {
                rootdir1.delete();
            }
            rootdir1.mkdirs();
        }
        if (!rootdir1i.isDirectory()) {
            if (rootdir1i.isFile()) {
                rootdir1i.delete();
            }
            rootdir1i.mkdirs();
        }
        if (!rootdir1ii.isDirectory()) {
            if (rootdir1ii.isFile()) {
                rootdir1ii.delete();
            }
            rootdir1ii.mkdirs();
        }
        if (!rootdir1iii.isDirectory()) {
            if (rootdir1iii.isFile()) {
                rootdir1iii.delete();
            }
            rootdir1iii.mkdirs();
        }
        if (!rootdir1iv.isDirectory()) {
            if (rootdir1iv.isFile()) {
                rootdir1iv.delete();
            }
            rootdir1iv.mkdirs();
        }
        if (!rootdir2.isDirectory()) {
            if (rootdir2.isFile()) {
                rootdir2.delete();
            }
            rootdir2.mkdirs();
        }
        if (!rootdir2i.isDirectory()) {
            if (rootdir2i.isFile()) {
                rootdir2i.delete();
            }
            rootdir2i.mkdirs();
        }
        if (!rootdir2ii.isDirectory()) {
            if (rootdir2ii.isFile()) {
                rootdir2ii.delete();
            }
            rootdir2ii.mkdirs();
        }
        if (!rootdir2iii.isDirectory()) {
            if (rootdir2iii.isFile()) {
                rootdir2iii.delete();
            }
            rootdir2iii.mkdirs();
        }
        if (!rootdir2iv.isDirectory()) {
            if (rootdir2iv.isFile()) {
                rootdir2iv.delete();
            }
            rootdir2iv.mkdirs();
        }
        if (!rootdir3.isDirectory()) {
            if (rootdir3.isFile()) {
                rootdir3.delete();
            }
            rootdir3.mkdirs();
        }
        if (!rootdir3i.isDirectory()) {
            if (rootdir3i.isFile()) {
                rootdir3i.delete();
            }
            rootdir3i.mkdirs();
        }
        if (!rootdir3ii.isDirectory()) {
            if (rootdir3ii.isFile()) {
                rootdir3ii.delete();
            }
            rootdir3ii.mkdirs();
        }
        if (!rootdir3iii.isDirectory()) {
            if (rootdir3iii.isFile()) {
                rootdir3iii.delete();
            }
            rootdir3iii.mkdirs();
        }
        if (!rootdir3iv.isDirectory()) {
            if (rootdir3iv.isFile()) {
                rootdir3iv.delete();
            }
            rootdir3iv.mkdirs();
        }
        if (!rootdir4.isDirectory()) {
            if (rootdir4.isFile()) {
                rootdir4.delete();
            }
            rootdir4.mkdirs();
        }
        if (!rootdir4i.isDirectory()) {
            if (rootdir4i.isFile()) {
                rootdir4i.delete();
            }
            rootdir4i.mkdirs();
        }
        if (!rootdir4ii.isDirectory()) {
            if (rootdir4ii.isFile()) {
                rootdir4ii.delete();
            }
            rootdir4ii.mkdirs();
        }
        if (!rootdir4iii.isDirectory()) {
            if (rootdir4iii.isFile()) {
                rootdir4iii.delete();
            }
            rootdir4iii.mkdirs();
        }
        if (!rootdir4iv.isDirectory()) {
            if (rootdir4iv.isFile()) {
                rootdir4iv.delete();
            }
            rootdir4iv.mkdirs();
        }
        if (!rootdir5.isDirectory()) {
            if (rootdir5.isFile()) {
                rootdir5.delete();
            }
            rootdir5.mkdirs();
        }
        if (!rootdir5i.isDirectory()) {
            if (rootdir5i.isFile()) {
                rootdir5i.delete();
            }
            rootdir5i.mkdirs();
        }
        if (!rootdir5ii.isDirectory()) {
            if (rootdir5ii.isFile()) {
                rootdir5ii.delete();
            }
            rootdir5ii.mkdirs();
        }
        if (!rootdir5iii.isDirectory()) {
            if (rootdir5iii.isFile()) {
                rootdir5iii.delete();
            }
            rootdir5iii.mkdirs();
        }
        if (!rootdir5iv.isDirectory()) {
            if (rootdir5iv.isFile()) {
                rootdir5iv.delete();
            }
            rootdir5iv.mkdirs();
        }
        if (!rootdir6.isDirectory()) {
            if (rootdir6.isFile()) {
                rootdir6.delete();
            }
            rootdir6.mkdirs();
        }
        if (!rootdir6i.isDirectory()) {
            if (rootdir6i.isFile()) {
                rootdir6i.delete();
            }
            rootdir6i.mkdirs();
        }
        if (!rootdir6ii.isDirectory()) {
            if (rootdir6ii.isFile()) {
                rootdir6ii.delete();
            }
            rootdir6ii.mkdirs();
        }
        if (!rootdir6iii.isDirectory()) {
            if (rootdir6iii.isFile()) {
                rootdir6iii.delete();
            }
            rootdir6iii.mkdirs();
        }
        if (!rootdir6iv.isDirectory()) {
            if (rootdir6iv.isFile()) {
                rootdir6iv.delete();
            }
            rootdir6iv.mkdirs();
        }
        if (!rootdir7.isDirectory()) {
            if (rootdir7.isFile()) {
                rootdir7.delete();
            }
            rootdir7.mkdirs();
        }
        if (!rootdir7i.isDirectory()) {
            if (rootdir7i.isFile()) {
                rootdir7i.delete();
            }
            rootdir7i.mkdirs();
        }
        if (!rootdir7ii.isDirectory()) {
            if (rootdir7ii.isFile()) {
                rootdir7ii.delete();
            }
            rootdir7ii.mkdirs();
        }
        if (!rootdir7iii.isDirectory()) {
            if (rootdir7iii.isFile()) {
                rootdir7iii.delete();
            }
            rootdir7iii.mkdirs();
        }
        if (!rootdir7iv.isDirectory()) {
            if (rootdir7iv.isFile()) {
                rootdir7iv.delete();
            }
            rootdir7iv.mkdirs();
        }
        if (!rootdir8.isDirectory()) {
            if (rootdir8.isFile()) {
                rootdir8.delete();
            }
            rootdir8.mkdirs();
        }
        if (!rootdir8i.isDirectory()) {
            if (rootdir8i.isFile()) {
                rootdir8i.delete();
            }
            rootdir8i.mkdirs();
        }
        if (!rootdir8ii.isDirectory()) {
            if (rootdir8ii.isFile()) {
                rootdir8ii.delete();
            }
            rootdir8ii.mkdirs();
        }
        if (!rootdir8iii.isDirectory()) {
            if (rootdir8iii.isFile()) {
                rootdir8iii.delete();
            }
            rootdir8iii.mkdirs();
        }
        if (!rootdir8iv.isDirectory()) {
            if (rootdir8iv.isFile()) {
                rootdir8iv.delete();
            }
            rootdir8iv.mkdirs();
        }
        if (!rootdir8v.isDirectory()) {
            if (rootdir8v.isFile()) {
                rootdir8v.delete();
            }
            rootdir8v.mkdirs();
        }
        if (!rootdir8vi.isDirectory()) {
            if (rootdir8vi.isFile()) {
                rootdir8vi.delete();
            }
            rootdir8vi.mkdirs();
        }
        
    }

    @Override
    public  List<String> getSections() {
        File rootDir = new File(root);

        String[] sections = rootDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isDirectory();
            }
        });

        return Arrays.asList(sections);
    }

    @Override
    public  List<String> getCategories(String section) {
        File sectionDir = new File(root + "/" + section);

        String[] categories = sectionDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isDirectory();
            }
        });

        return Arrays.asList(categories);
    }

    @Override
    public  List<String> getQuestionTopics(
            String section,
            String category) {
        File categoryDir = new File(root + "/" + section + "/" + category);

        String[] topics = categoryDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir + "/" + name).isFile();
            }
        });

        return Arrays.asList(topics);
    }

    @Override
    public  Question getQuestion(
            String section,
            String category,
            String topic) {
         String questionFile
                = root + "/" + section + "/" + category + "/" + topic;

        return Serializer.deserialize(questionFile);
    }

    @Override
    public  void save(Question question,
            String section,
            String category) {
        String questionDir = root + "/" + section + "/" + category;
        File dir = new File(questionDir);
        dir.mkdirs();

        String questionFile = questionDir + "/" + question.getTopic();

        Serializer.serialize(question, questionFile);
    } 

    @Override
    public void addObserve(ForumAnswerObserverController controller) throws RemoteException {
        observeble.addObserve(controller);
    }

    @Override
    public void removeObserve(ForumAnswerObserverController controller) throws RemoteException {
        observeble.removeObserve(controller);
    }

    @Override
    public void notifyObserve(String name, String message,String desc,String topic) throws RemoteException {
        observeble.notifyObserve(name,message,desc,topic);
    }

    @Override
    public void notifyNewQuestionObserve(String name, String topic, String desc) throws RemoteException {
        observeble.notifyNewQuestionObserve(name,topic,desc);
    }
    
    
}
