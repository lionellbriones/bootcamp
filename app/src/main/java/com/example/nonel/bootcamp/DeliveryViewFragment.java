package com.example.nonel.bootcamp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nonel.bootcamp.Model.Products;

public class DeliveryViewFragment extends Fragment {

    private DeliveryViewFragment instance;
    TextView tv_meal_name;
    TextView tv_meal_price;
    TextView tv_meal_description;

    public DeliveryViewFragment getInstance(){
        if(instance == null){
            instance = new DeliveryViewFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_delivery_view, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tv_meal_name = (TextView) view.findViewById(R.id.tv_meal_name);
        tv_meal_price = (TextView) view.findViewById(R.id.tv_meal_price);
        tv_meal_description = (TextView) view.findViewById(R.id.tv_meal_description);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public void fillProductData(Products meal){
        tv_meal_name.setText(meal.getName());
        tv_meal_price.setText(Float.toString(meal.getPrice()));
        tv_meal_description.setText(meal.getDescription());
    }
}
