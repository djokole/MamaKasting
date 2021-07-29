/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connection.Session;
import domen.Glumac;
import domen.Produkcija;
import domen.Projekat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import transfer.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Panda
 */
public class ClientController {
    private static ClientController instance;
    
    public ClientController() {
        
    }
    
    public static ClientController getInstance() {
        if(instance == null)
            instance = new ClientController();
        return instance;
    }
    
    public Produkcija loginProdukcija(String username, String password) throws Exception {
        return (Produkcija) sendRequest(new Produkcija(0,null,username,password), Operation.LOGIN_PRODUKCIJA);
    }
    
    public Glumac loginGlumac(String username, String password) throws Exception {
        return (Glumac) sendRequest(new Glumac(username,password), Operation.LOGIN_GLUMAC);
    }

    public void createProdukcija(Produkcija prod) throws Exception {
        sendRequest(prod, Operation.NOVA_PRODUKCIJA);
    }
    
    public void updateProdukcija(Produkcija produkcija) throws Exception{
        sendRequest(produkcija, Operation.IZMENI_PRODUKCIJU);
    }
    
    public void deleteProdukcija(Produkcija produkcija) throws Exception {
        sendRequest(produkcija, Operation.OBRISI_PRODUKCIJU);
    }
    
    public void deleteGlumac(Glumac glumac) throws Exception {
        sendRequest(glumac, Operation.OBRISI_GLUMCA);
    }
    
    public void createGlumac(Glumac glumac) throws Exception {
        sendRequest(glumac, Operation.DODAJ_GLUMCA);
    }
    
    public List<Glumac> getAllGlumci() throws Exception {
        return (List<Glumac>) sendRequest(null,Operation.DAJ_GLUMCE);
    }
    
    public void deleteProjekat(Projekat projekat) throws Exception{
        sendRequest(projekat, Operation.OBRISI_PROJEKAT);
    }
    
    public void createProjekat(Projekat projekat) throws Exception {
        sendRequest(projekat, Operation.DODAJ_NOVI_PROJEKAT);
    }
    
    public List<Projekat> getAllProjekti()throws Exception{
        return (List<Projekat>) sendRequest(null, Operation.DAJ_PROJEKTE);
    }
    
    
    
    
    
    private Object sendRequest(Object data, int operation) throws Exception {
        Request request = new Request(data, operation);
        ObjectOutputStream oos = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        oos.writeObject(request);
        ObjectInputStream ois = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) ois.readObject();
        if (response.getException() != null) {
            throw response.getException();
        }
        return response.getData();
    }
}
