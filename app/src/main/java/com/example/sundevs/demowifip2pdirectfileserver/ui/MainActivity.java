package com.example.sundevs.demowifip2pdirectfileserver.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.content.ContextCompat;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sundevs.demowifip2pdirectfileserver.R;
import com.example.sundevs.demowifip2pdirectfileserver.ServerContract;
import com.example.sundevs.demowifip2pdirectfileserver.Utilities;
import com.example.sundevs.demowifip2pdirectfileserver.config.socket.ServerThread;
import com.example.sundevs.demowifip2pdirectfileserver.domain.Book;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class MainActivity extends Activity implements ServerContract.MainView {

    public static final int PORT = 2027;
    public final static int TCP_BUFFER_SIZE = 1024*1024;

    @BindView(R.id.lab_ip_addres)
    TextView labIpAddress;
    @BindView(R.id.btn_start_server)
    Button btnStartServer;
    @BindView(R.id.books_list)
    ListView booksList;

    private ArrayList<String> books;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setIpAddress(Utilities.getIPAddress(true));
        toastyConfig();
        books = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books);
        booksList.setAdapter(adapter);
    }

    @Override
    public void disabledButtonStartServer() {
        btnStartServer.setEnabled(false);
    }

    @Override
    public void setIpAddress(String s) {
        labIpAddress.setText(s);
    }

    @Override
    public void addBook(final Book book) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                books.add(book.toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void toastyConfig() {
        Toasty.Config.getInstance()
                .setErrorColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                .setInfoColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                .setSuccessColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
                .setWarningColor(ContextCompat.getColor(this, android.R.color.holo_orange_light))
                .setTextColor(ContextCompat.getColor(this, android.R.color.white))
                .apply();
    }

    @OnClick(R.id.btn_start_server)
    public void onViewClicked() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                initServerSocket();
            }
        };
        thread.start();
        btnStartServer.setEnabled(false);
    }

    @Override
    public void showMessage(String message, MessageType type) {
        switch (type) {
            case SUCCESS:
                Toasty.success(this, message).show();
                break;
            case ERROR:
                Toasty.error(this, message).show();
                break;
            case WARNING:
                Toasty.warning(this, message).show();
                break;
            case INFO:
                Toasty.info(this, message).show();
                break;
        }
    }

    public void initServerSocket(){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(PORT);
            serverSocket.setReceiveBufferSize(TCP_BUFFER_SIZE);
            System.out.println("Listening");
            while (true) {
                System.out.println("New order");
                Runnable run = new ServerThread(serverSocket.accept(), this);
                Thread thread = new Thread(run);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
