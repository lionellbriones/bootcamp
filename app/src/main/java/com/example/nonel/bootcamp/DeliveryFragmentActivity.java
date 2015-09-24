package com.example.nonel.bootcamp;

import android.app.Activity;
import android.os.Bundle;

import com.example.nonel.bootcamp.Model.Products;

public class DeliveryFragmentActivity extends Activity {
    DeliveryViewFragment fragment_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_fragment);

        fragment_view = (DeliveryViewFragment) this.getFragmentManager().findFragmentById(R.id.fragment_view);

    }

    public void fillFragmentView(Products meal){
        fragment_view.fillProductData(meal);
    }

}