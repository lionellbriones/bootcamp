package com.example.nonel.bootcamp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeliveryActivity extends Activity{

    public void fillDialog(Dialog dialog, String mealName, String mealDescription, Float mealPrice){
        TextView tv_meal_name = (TextView) dialog.findViewById(R.id.tv_meal_name);
        TextView tv_meal_description = (TextView) dialog.findViewById(R.id.tv_meal_description);
        TextView tv_meal_price = (TextView) dialog.findViewById(R.id.tv_meal_price);

        tv_meal_name.setText(mealName);
        tv_meal_description.setText(mealDescription);
        tv_meal_price.setText(Float.toString(mealPrice));
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_delivery_page);
        dialog.setTitle("Meal Info");

        LinearLayout ll_meal1 = (LinearLayout) findViewById(R.id.ll_meal1);
        LinearLayout ll_meal2 = (LinearLayout) findViewById(R.id.ll_meal2);
        LinearLayout ll_meal3 = (LinearLayout) findViewById(R.id.ll_meal3);
        LinearLayout ll_meal4 = (LinearLayout) findViewById(R.id.ll_meal4);
        LinearLayout ll_meal5 = (LinearLayout) findViewById(R.id.ll_meal5);
        LinearLayout ll_meal6 = (LinearLayout) findViewById(R.id.ll_meal6);
        LinearLayout ll_meal7 = (LinearLayout) findViewById(R.id.ll_meal7);
        LinearLayout ll_meal8 = (LinearLayout) findViewById(R.id.ll_meal8);
        LinearLayout ll_meal9 = (LinearLayout) findViewById(R.id.ll_meal9);
        LinearLayout ll_meal10 = (LinearLayout) findViewById(R.id.ll_meal10);
        LinearLayout ll_meal11 = (LinearLayout) findViewById(R.id.ll_meal11);
        LinearLayout ll_meal12 = (LinearLayout) findViewById(R.id.ll_meal12);

        ll_meal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 1", "Meal 1 Described", 100.50f);
            }
        });

        ll_meal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 2", "Meal 2 Described", 200.50f);
            }
        });

        ll_meal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 3", "Meal 3 Described", 300.50f);
            }
        });

        ll_meal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 4", "Meal 4 Described", 400.50f);
            }
        });

        ll_meal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 5", "Meal 5 Described", 500.50f);
            }
        });

        ll_meal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 6", "Meal 6 Described", 600.50f);
            }
        });

        ll_meal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 7", "Meal 7 Described", 700.50f);
            }
        });

        ll_meal8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 8", "Meal 8 Described", 800.50f);
            }
        });

        ll_meal9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 9", "Meal 9 Described", 900.50f);
            }
        });

        ll_meal10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 10", "Meal 10 Described", 1000.50f);
            }
        });

        ll_meal11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 11", "Meal 11 Described", 1100.50f);
            }
        });

        ll_meal12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialog(dialog, "Meal 12", "Meal 12 Described", 1200.50f);
            }
        });
    }

}
