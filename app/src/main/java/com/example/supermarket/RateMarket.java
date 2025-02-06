//package com.example.supermarket;
//
//import android.annotation.SuppressLint;
//import android.content.res.Resources;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.DialogFragment;
//
//import androidx.fragment.app.DialogFragment;
//
//public class RateMarket extends AppCompatActivity implements RateMarket.RateMarketListener {
//    RatingBar rateLiquor;
//    RatingBar rateProduce;
//    RatingBar rateMeat;
//    RatingBar rateCheese;
//    RatingBar rateCheckout;
//
//    public interface RateMarketListener {
//        void onFinishRating(RatingBar rating);
//    }
//
//    public RateMarket() {
//        //setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
//    }
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        final View view = inflater.inflate(R.layout.rate_market, container);
//
//      //  getDialog().setTitle("Rate Market");
//
//        rateLiquor  = view.findViewById(R.id.ratingLiquor);
//        rateLiquor.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                rateLiquor.setZ(rating);
//            }
//        });
//        rateProduce  = view.findViewById(R.id.ratingProduce);
//        rateProduce.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                rateProduce.setZ(rating);
//            }
//        });
//        rateMeat  = view.findViewById(R.id.ratingMeat);
//        rateMeat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                rateMeat.setZ(rating);
//            }
//        });
//        rateCheese  = view.findViewById(R.id.ratingCheese);
//        rateCheese.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                rateCheese.setZ(rating);
//            }
//        });
//        rateCheckout  = view.findViewById(R.id.ratingCheckout);
//        rateCheckout.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                rateCheckout.setZ(rating);
//            }
//        });
//        Button saveButton = view.findViewById(R.id.Savebutton);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                saveItem(rateLiquor);
//                saveItem(rateProduce);
//                saveItem(rateMeat);
//                saveItem(rateCheese);
//                saveItem(rateCheckout);
//                double total = (rateLiquor.getRating() + rateProduce.getRating() + rateMeat.getRating() + rateCheese.getRating() + rateCheckout.getRating()) / 5;
//                TextView rate = view.findViewById(R.id.textViewAverage);
//                Resources res = getResources();
//                String displayString = res.getString(R.string.rating, total);
//                rate.setText(displayString);
//                boolean wasSuccessful;
//                RatingDataSource ds = new RatingDataSource(getContext());
//                try{
//                    ds.open();
//                    if(currentRating.getRatingID() == -1)
//                }
//            }
//        });
//        Button homeButton = view.findViewById(R.id.Homebutton);
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//        return view;
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (getDialog() != null && getDialog().getWindow() != null) {
//            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            getDialog().getWindow().setGravity(Gravity.CENTER);
//            getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        }
//    }
//
//    @Override
//    public void onFinishRating(RatingBar rating) {
//        String liquor = String.valueOf(rating.getRating());
//        currentRating.setLiquor(liquor);
//        String produce = String.valueOf(rating.getRating());
//        currentRating.setProduce(produce);
//        String meat = String.valueOf(rating.getRating());
//        currentRating.setMeat(meat);
//        String cheese = String.valueOf(rating.getRating());
//        currentRating.setCheese(cheese);
//        String checkout = String.valueOf(rating.getRating());
//        currentRating.setCheckout(checkout);
//        //double total = (liquor + produce + meat + cheese + checkout) / 5;
//    }
//    public void saveItem(RatingBar rating) {
//        RateMarketListener activity = (RateMarketListener) getActivity();
//        activity.onFinishRating(rating);
//    }
//}
