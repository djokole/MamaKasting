/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domen.Glumac;
import domen.Produkcija;
import domen.Projekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import transfer.Operation;
import transfer.Request;
import transfer.Response;

public class ThreadClient extends Thread {

    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) ois.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response();
        try {
            switch (request.getOperation()) {
                case Operation.LOGIN_PRODUKCIJA:
                    response.setData(ServerController.getInstance().loginP((Produkcija)request.getData()));
                    break;
                case Operation.NOVA_PRODUKCIJA:
                    ServerController.getInstance().createProdukcija((Produkcija)request.getData());
                    break;
                case Operation.IZMENI_PRODUKCIJU:
                    ServerController.getInstance().updateProdukcija((Produkcija)request.getData());
                    break;
                case Operation.OBRISI_PRODUKCIJU:
                    ServerController.getInstance().deleteProdukcija((Produkcija)request.getData());
                    break;
                case Operation.LOGIN_GLUMAC:
                    response.setData(ServerController.getInstance().loginG((Glumac)request.getData()));
                    break;
                case Operation.OBRISI_GLUMCA:
                    ServerController.getInstance().deleteGlumac((Glumac)request.getData());
                    break;
                case Operation.DODAJ_GLUMCA:
                    ServerController.getInstance().createGlumac((Glumac)request.getData());
                    break;
                case Operation.DAJ_GLUMCE:
                    response.setData(ServerController.getInstance().getAllGlumci());
                    break;
                case Operation.DAJ_PROJEKTE:
                    response.setData(ServerController.getInstance().getAllProjekti());
                    break;
                case Operation.DODAJ_NOVI_PROJEKAT:
                    ServerController.getInstance().createProjekat((Projekat)request.getData());
                    break;
                case Operation.OBRISI_PROJEKAT:
                    ServerController.getInstance().deleteProjekat((Projekat)request.getData());
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setException(ex);
        }
        return response;
    }

}
