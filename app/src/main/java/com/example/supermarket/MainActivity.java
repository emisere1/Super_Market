package com.example.supermarket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements RateMarket.RateMarketListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initRateButton();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initRateButton(){
        Button rateButton = findViewById(R.id.RateButton);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                RateMarket rateMarket = new RateMarket();
                rateMarket.show(fm, "Rate Market");
            }
        });
    }

    @Override
    public void onFinishRating(RatingBar rating) {
        double liquor = rating.getRating();
        double produce = rating.getRating();
        double meat = rating.getRating();
        double cheese = rating.getRating();
        double checkout = rating.getRating();
        double total = (liquor + produce + meat + cheese + checkout) / 5;

    }
}