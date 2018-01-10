package com.example.sundevs.demowifip2pdirectfileserver;

import com.example.sundevs.demowifip2pdirectfileserver.domain.Book;
import com.example.sundevs.demowifip2pdirectfileserver.ui.MessageType;

/**
 * Created by SunDevs on 8/01/2018.
 */

public interface ServerContract {
    interface ViewData{
        void setIpAddress(String s);
        void addBook(Book book);
    }
    interface MainView {
        void showMessage(String message, MessageType type);

        void disabledButtonStartServer();

        void setIpAddress(String s);

        void addBook(Book book);


    }

    interface ThreadServer extends BasePresenter {
    }

    interface MainPresenter extends BasePresenter {
        void initServer();
    }
}
