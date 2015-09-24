package com.example.nonel.bootcamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getBaseContext(), "Bootcamp App loaded.", Toast.LENGTH_SHORT).show();

        Button btn_rating = (Button) findViewById(R.id.btn_rating);
        Button btn_calculator = (Button) findViewById(R.id.btn_calculator);
        Button btn_slam_book = (Button) findViewById(R.id.btn_slam_book);
        Button btn_delivery = (Button) findViewById(R.id.btn_delivery);

        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Activity", "Rating");
                Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intent);
            }
        });

        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Activity", "Calculator");
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        btn_slam_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Activity", "Slam Book");
                Intent intent = new Intent(MainActivity.this, SlamBookActivity.class);
                startActivity(intent);
            }
        });

        btn_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Activity", "Delivery");
                Intent intent = new Intent(MainActivity.this, DeliveryFragmentActivity.class);
                startActivity(intent);
            }
        });
    }

}
