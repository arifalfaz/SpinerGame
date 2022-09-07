package com.example.spinergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
           private   static final String [] selecter = {"1","ariffggggggggggggffvfdv wrtgwwwwr","Asharaf", " alfazrt  ffffffffff      " +
                   "edsfcd  ewfedfe" ," shalufffffffffffffffffffffffffffffff", " ruksaharffffffffffffffffffffffff", "maafffffffffffffffffff"};


           private static final int[] selecterDegeree = new int[selecter.length];
           private static final Random random = new Random();
           private int degree = 0;
           private boolean isSpining = false;
           private ImageView spiner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         spiner = findViewById(R.id.weal);
        final Button btn = findViewById(R.id.btn);


        getDegereeForselecter();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(!isSpining){
               spin();
               isSpining = true;
              }
            }
        });
    }



    private void spin(){

        degree = random.nextInt(selecter.length-1);
        RotateAnimation rotateAnimation = new RotateAnimation(0,(360*selecter.length)+selecterDegeree[degree],
         RotateAnimation.RELATIVE_TO_SELF,0.5f ,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        rotateAnimation.setDuration(5000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());



        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Start now!", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onAnimationEnd(Animation animation) {


             Toast.makeText(MainActivity.this, "You Are  "+selecter[selecter.length-(degree +1)] , Toast.LENGTH_SHORT).show();
                   isSpining = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
       spiner.startAnimation(rotateAnimation);

    }


    private void getDegereeForselecter(){

        int selecterDegree = 360/selecter.length;
        for(int i=0;i< selecter.length;i++){

            selecterDegeree[i] = (i+1) * selecterDegree;
        }
    }
}
