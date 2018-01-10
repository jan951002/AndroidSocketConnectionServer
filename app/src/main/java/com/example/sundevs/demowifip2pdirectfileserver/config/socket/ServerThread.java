package com.example.sundevs.demowifip2pdirectfileserver.config.socket;

import com.example.sundevs.demowifip2pdirectfileserver.ServerContract;
import com.example.sundevs.demowifip2pdirectfileserver.domain.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by SunDevs on 4/01/2018.
 */

public class ServerThread implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private ObjectOutputStream out;
    private ServerContract.MainView view;

    public ServerThread(Socket socket, ServerContract.MainView view) {
        this.socket = socket;
        this.view = view;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new ObjectOutputStream(socket.getOutputStream());
            String jsonObject;
            while ((jsonObject = in.readLine()) != null) {
                Book book = Book.create(jsonObject);
                String outResult = "Successful: " + book.toString();
                view.addBook(book);
                System.out.println(outResult);
                out.writeObject(outResult);
            }
        } catch (IllegalArgumentException | IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
