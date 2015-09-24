package com.example.nonel.bootcamp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;

public class RatingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        RatingBar rb_customer1 = (RatingBar) findViewById(R.id.rb_customer1);
        RatingBar rb_customer2 = (RatingBar) findViewById(R.id.rb_customer2);
        RatingBar rb_customer3 = (RatingBar) findViewById(R.id.rb_customer3);
        RatingBar rb_customer4 = (RatingBar) findViewById(R.id.rb_customer4);
        RatingBar rb_customer5 = (RatingBar) findViewById(R.id.rb_customer5);

        rb_customer1.setRating(1f);
        rb_customer2.setRating(2.3f);
        rb_customer3.setRating(3.5f);
        rb_customer4.setRating(4.7f);
        rb_customer5.setRating(5f);


        rb_customer1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("RatingActivity", rating+"");
            }
        });
        rb_customer2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("RatingActivity", rating+"");
            }
        });
        rb_customer3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("RatingActivity", rating+"");
            }
        });
        rb_customer4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("RatingActivity", rating+"");
            }
        });
        rb_customer5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("RatingActivity", rating+"");
            }
        });
    }

}
