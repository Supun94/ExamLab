/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fileaccess.QuestionFileAccess;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Question;

/**
 *
 * @author Supun
 */
public class QuestionControllerImpl extends UnicastRemoteObject implements QuestionController {

    private QuestionFileAccess questionFileAccess = new QuestionFileAccess();

    QuestionControllerImpl() throws RemoteException {

    }

    @Override
    public boolean nextQuestion(int question) throws RemoteException, IOException {
        return questionFileAccess.nextQuestion(question);
    }

    @Override
    public String newNextQuestion1(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion1(q);
    }

    @Override
    public boolean submitAnswer(Question q,String submitAnswer) throws RemoteException, IOException {
        return questionFileAccess.submitAnswer(q,submitAnswer);
    }

    @Override
    public String submitMyAnswer(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer(q);
    }

    @Override
    public String newNextQuestion2(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion2(q);
    }

    @Override
    public String newNextQuestion3(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion3(q);
    }

    @Override
    public String newNextQuestion4(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion4(q);
    }

    @Override
    public String newNextQuestion5(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion5(q);
    }

    @Override
    public String newNextQuestion6(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion6(q);
    }

    @Override
    public String newNextQuestion7(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion7(q);
    }

    @Override
    public String newNextQuestion8(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion8(q);
    }

    @Override
    public String newNextQuestion9(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion9(q);
    }

    @Override
    public String newNextQuestion10(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion10(q);
    }

    @Override
    public String newNextQuestion11(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion11(q);
    }

    @Override
    public String newNextQuestion12(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion12(q);
    }

    @Override
    public String newNextQuestion13(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion13(q);
    }

    @Override
    public String newNextQuestion14(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion14(q);
    }

    @Override
    public String newNextQuestion15(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion15(q);
    }

    @Override
    public String newNextQuestion16(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion16(q);
    }

    @Override
    public String newNextQuestion17(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion17(q);
    }

    @Override
    public int countCat1() throws RemoteException, IOException {
        return questionFileAccess.countCat1();
    }

    @Override
    public int countCat2() throws RemoteException, IOException {
        return questionFileAccess.countCat2();
    }

    @Override
    public int countCat3() throws RemoteException, IOException {
    return questionFileAccess.countCat3();
    }

    @Override
    public int countCat4() throws RemoteException, IOException {
        return questionFileAccess.countCat4();
    }

    @Override
    public int countCat5() throws RemoteException, IOException {
        return questionFileAccess.countCat5();
    }

    @Override
    public int countCat6() throws RemoteException, IOException {
        return questionFileAccess.countCat6();
    }

    @Override
    public int countCat7() throws RemoteException, IOException {
        return questionFileAccess.countCat7();
    }

    @Override
    public int countCat8() throws RemoteException, IOException {
        return questionFileAccess.countCat8();
    }

    @Override
    public int countCat9() throws RemoteException, IOException {
        return questionFileAccess.countCat9();
    }

    @Override
    public int countCat10() throws RemoteException, IOException {
        return questionFileAccess.countCat10();
    }

    @Override
    public int countCat11() throws RemoteException, IOException {
        return questionFileAccess.countCat11();
    }

    @Override
    public int countCat12() throws RemoteException, IOException {
        return questionFileAccess.countCat12();
    }

    @Override
    public int countCat13() throws RemoteException, IOException {
        return questionFileAccess.countCat13();
    }

    @Override
    public int countCat14() throws RemoteException, IOException {
        return questionFileAccess.countCat14();
    }

    @Override
    public int countCat15() throws RemoteException, IOException {
        return questionFileAccess.countCat15();
    }

    @Override
    public int countCat16() throws RemoteException, IOException {
        return questionFileAccess.countCat16();
    }

    @Override
    public int countCat17() throws RemoteException, IOException {
        return questionFileAccess.countCat17();
    }

    @Override
    public String newNextQuestion(Question q) throws RemoteException, IOException {
        return questionFileAccess.newNextQuestion(q);
    }

    @Override
    public String submitMyAnswer1(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer1(q);
    }

    @Override
    public String submitMyAnswer2(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer2(q);
    }

    @Override
    public String submitMyAnswer3(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer3(q);
    }

    @Override
    public String submitMyAnswer4(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer4(q);
    }

    @Override
    public String submitMyAnswer5(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer5(q);
    }

    @Override
    public String submitMyAnswer6(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer6(q);
    }

    @Override
    public String submitMyAnswer7(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer7(q);
    }

    @Override
    public String submitMyAnswer8(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer8(q);
    }

    @Override
    public String submitMyAnswer9(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer9(q);
    }

    @Override
    public String submitMyAnswer10(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer10(q);
    }

    @Override
    public String submitMyAnswer11(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer11(q);
    }

    @Override
    public String submitMyAnswer12(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer12(q);
    }

    @Override
    public String submitMyAnswer13(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer13(q);
    }

    @Override
    public String submitMyAnswer14(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer14(q);
    }

    @Override
    public String submitMyAnswer15(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer15(q);
    }

    @Override
    public String submitMyAnswer16(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer16(q);
    }

    @Override
    public String submitMyAnswer17(Question q) throws RemoteException, IOException {
        return questionFileAccess.submitMyAnswer17(q);
    }

}
