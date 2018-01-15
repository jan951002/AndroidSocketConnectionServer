package com.example.sundevs.demowifip2pdirectfileserver.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sundevs.demowifip2pdirectfileserver.R;

public class CardviewSaleOrderFragment extends Fragment {

    public CardviewSaleOrderFragment() {
        // Required empty public constructor
    }

    public static CardviewSaleOrderFragment newInstance() {
        CardviewSaleOrderFragment fragment = new CardviewSaleOrderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cardview_sale_order, container, false);
    }
}
