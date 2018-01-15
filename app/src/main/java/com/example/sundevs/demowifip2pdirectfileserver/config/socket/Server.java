package com.example.sundevs.demowifip2pdirectfileserver.config.socket;

import android.os.StrictMode;

import com.example.sundevs.demowifip2pdirectfileserver.ServerContract;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by SunDevs on 11/01/2018.
 */

public class Server implements ServerContract.Server{

    public static final int PORT = 2027;
    public final static int TCP_BUFFER_SIZE = 1024 * 1024;

    private ServerContract.MainView view;
    private ArrayList<Socket> sockets;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public Server() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        sockets = new ArrayList<>();
    }

    public void listen() {
        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReceiveBufferSize(TCP_BUFFER_SIZE);
            System.out.println("Listening");
            while (true) {
                clientSocket = serverSocket.accept();
                sockets.add(clientSocket);
                Runnable run = new ServerThread(clientSocket, view);
                Thread thread = new Thread(run);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void attachView(ServerContract.MainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
