package com.example.sundevs.demowifip2pdirectfileserver.config.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import com.example.sundevs.demowifip2pdirectfileserver.ServerContract;
import com.example.sundevs.demowifip2pdirectfileserver.Utilities;
import com.example.sundevs.demowifip2pdirectfileserver.ui.MessageType;

/**
 * Created by SunDevs on 10/01/2018.
 */

public class ConnectivityChange extends BroadcastReceiver implements ServerContract.ConnectivityChangePresenter {

    private ServerContract.MainView view;

    public ConnectivityChange() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            boolean connected = info.isConnected();
            if (connected) {
                if (view != null) {
                    view.showMessage("Connected", MessageType.SUCCESS);
                    view.setIpAddress(Utilities.getIPAddress(true));
                }
            } else {
                if (view != null) {
                    view.showMessage("No Connected", MessageType.WARNING);
                }
            }
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
