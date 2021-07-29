/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Panda
 */
public class Session {
    private static Session instance;
    private Socket socket;
    private Object ulogovan;
    
    public Session() {
        try {
            socket = new Socket("localhost", 10000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Object getTrenutnoUlogovan() {
        return ulogovan;
    }

    public void setTrenutnoUlogovan(Object ulogovan) {
        this.ulogovan = ulogovan;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
    
}
