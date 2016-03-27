/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Question;

/**
 *
 * @author Supun
 */
public interface QuestionController extends Remote{
    boolean nextQuestion(int question) throws RemoteException,IOException;
    String newNextQuestion(Question q) throws RemoteException,IOException;
    String newNextQuestion1(Question q) throws RemoteException,IOException;
    String newNextQuestion2(Question q) throws RemoteException,IOException;
    String newNextQuestion3(Question q) throws RemoteException,IOException;
    String newNextQuestion4(Question q) throws RemoteException,IOException;
    String newNextQuestion5(Question q) throws RemoteException,IOException;
    String newNextQuestion6(Question q) throws RemoteException,IOException;
    String newNextQuestion7(Question q) throws RemoteException,IOException;
    String newNextQuestion8(Question q) throws RemoteException,IOException;
    String newNextQuestion9(Question q) throws RemoteException,IOException;
    String newNextQuestion10(Question q) throws RemoteException,IOException;
    String newNextQuestion11(Question q) throws RemoteException,IOException;
    String newNextQuestion12(Question q) throws RemoteException,IOException;
    String newNextQuestion13(Question q) throws RemoteException,IOException;
    String newNextQuestion14(Question q) throws RemoteException,IOException;
    String newNextQuestion15(Question q) throws RemoteException,IOException;
    String newNextQuestion16(Question q) throws RemoteException,IOException;
    String newNextQuestion17(Question q) throws RemoteException,IOException;
    boolean submitAnswer(Question q,String submitAnswer) throws RemoteException,IOException;
    String submitMyAnswer(Question q) throws RemoteException,IOException;
    String submitMyAnswer1(Question q) throws RemoteException,IOException;
    String submitMyAnswer2(Question q) throws RemoteException,IOException;
    String submitMyAnswer3(Question q) throws RemoteException,IOException;
    String submitMyAnswer4(Question q) throws RemoteException,IOException;
    String submitMyAnswer5(Question q) throws RemoteException,IOException;
    String submitMyAnswer6(Question q) throws RemoteException,IOException;
    String submitMyAnswer7(Question q) throws RemoteException,IOException;
    String submitMyAnswer8(Question q) throws RemoteException,IOException;
    String submitMyAnswer9(Question q) throws RemoteException,IOException;
    String submitMyAnswer10(Question q) throws RemoteException,IOException;
    String submitMyAnswer11(Question q) throws RemoteException,IOException;
    String submitMyAnswer12(Question q) throws RemoteException,IOException;
    String submitMyAnswer13(Question q) throws RemoteException,IOException;
    String submitMyAnswer14(Question q) throws RemoteException,IOException;
    String submitMyAnswer15(Question q) throws RemoteException,IOException;
    String submitMyAnswer16(Question q) throws RemoteException,IOException;
    String submitMyAnswer17(Question q) throws RemoteException,IOException;
    int countCat1() throws RemoteException,IOException;
    int countCat2() throws RemoteException,IOException;
    int countCat3() throws RemoteException,IOException;
    int countCat4() throws RemoteException,IOException;
    int countCat5() throws RemoteException,IOException;
    int countCat6() throws RemoteException,IOException;
    int countCat7() throws RemoteException,IOException;
    int countCat8() throws RemoteException,IOException;
    int countCat9() throws RemoteException,IOException;
    int countCat10() throws RemoteException,IOException;
    int countCat11() throws RemoteException,IOException;
    int countCat12() throws RemoteException,IOException;
    int countCat13() throws RemoteException,IOException;
    int countCat14() throws RemoteException,IOException;
    int countCat15() throws RemoteException,IOException;
    int countCat16() throws RemoteException,IOException;
    int countCat17() throws RemoteException,IOException;
    
}
