package com.example.apolo.circlereveal;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView revealImage;
    private Button btnReveal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        revealImage = (ImageView) findViewById(R.id.revealImage);
        btnReveal = (Button) findViewById(R.id.btnReveal);

        btnReveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnimation();
            }
        });
        /*revealImage.post(new Runnable() {
            @Override
            public void run() {

            }
        }); */
    }

    private void showAnimation() {
        int cx = (revealImage.getLeft() + revealImage.getRight()) / 2;
        int cy = (revealImage.getTop() + revealImage.getBottom()) / 2;

        int finalRadius = Math.max(revealImage.getWidth(),revealImage.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(revealImage,cx,cy,0,finalRadius);
        anim.setDuration(1000);
        revealImage.setVisibility(View.VISIBLE);
        anim.start();
    }


}
