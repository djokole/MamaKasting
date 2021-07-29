/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ThreadServer extends Thread {

    private ServerSocket serverSocket;
    private List<ThreadClient> list;

    public ThreadServer() {
        try {
            list = new LinkedList<>();
            serverSocket = new ServerSocket(10000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                ThreadClient thc = new ThreadClient(socket);
                thc.start();
                list.add(thc);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<ThreadClient> getList() {
        return list;
    }

    
}
