package com.example.supermarket;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Rate_Market extends AppCompatActivity {

    private Rating currentRating;
    RatingBar rateLiquor;
    RatingBar rateProduce;
    RatingBar rateMeat;
    RatingBar rateCheese;
    RatingBar rateCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rate_market);
        initHomeButton();
        initSaveButton();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        currentRating = new Rating();
        String market = getIntent().getStringExtra("market");
        currentRating.setMarket(market);
        String address = getIntent().getStringExtra("address");
        currentRating.setMarketAddress(address);

        rateLiquor = findViewById(R.id.ratingLiquor);
        rateLiquor.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateLiquor.setZ(rating);
            }
        });
        rateProduce = findViewById(R.id.ratingProduce);
        rateProduce.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateProduce.setZ(rating);
            }
        });
        rateMeat = findViewById(R.id.ratingMeat);
        rateMeat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateMeat.setZ(rating);
            }
        });
        rateCheese = findViewById(R.id.ratingCheese);
        rateCheese.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateCheese.setZ(rating);
            }
        });
        rateCheckout = findViewById(R.id.ratingCheckout);
        rateCheckout.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateCheckout.setZ(rating);
            }
        });
    }

    private void initSaveButton(){
        Button saveButton = findViewById(R.id.Savebutton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sliquor = String.valueOf(rateLiquor.getRating());
                String sproduce = String.valueOf(rateProduce.getRating());
                String smeet = String.valueOf(rateMeat.getRating());
                String scheese = String.valueOf(rateCheese.getRating());
                String scheckout = String.valueOf(rateCheckout.getRating());
                currentRating.setLiquor(sliquor);
                currentRating.setProduce(sproduce);
                currentRating.setMeat(smeet);
                currentRating.setCheese(scheese);
                currentRating.setCheckout(scheckout);
                double total = (rateLiquor.getRating() + rateProduce.getRating() + rateMeat.getRating() + rateCheese.getRating() + rateCheckout.getRating()) / 5;
                TextView rate = findViewById(R.id.textViewAverage);
                Resources res = getResources();
                String displayString = res.getString(R.string.rating, total);
                boolean wasSuccessful;
                RatingDataSource ds = new RatingDataSource(Rate_Market.this);
                try{
                    ds.open();
                    if (ds.checkRating(currentRating.getMarket(), currentRating.getMarketAddress())){
                        long id = ds.getRatingId(currentRating.getMarket(), currentRating.getMarketAddress());
                        currentRating.setRatingID((int) id);
                        wasSuccessful = ds.updateRating(currentRating);
                    }
                    else{
                    if(currentRating.getRatingID() == -1){
                        wasSuccessful = ds.insertRating(currentRating);
                        if (wasSuccessful){
                            int newId = ds.getLastRatingId();
                            currentRating.setRatingID(newId);
                        }
                    }
                    else{
                        wasSuccessful = ds.updateRating(currentRating);
                    }
                    ds.close();
                }}
                catch (Exception e){
                    wasSuccessful = false;
                }
                if (wasSuccessful){
                    rate.setText(displayString);
                }

            }
        });
    }
    private void initHomeButton(){
        Button homeButton = findViewById(R.id.Homebutton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rate_Market.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}