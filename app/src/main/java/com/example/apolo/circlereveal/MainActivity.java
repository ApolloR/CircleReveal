package com.example.apolo.circlereveal;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView revealImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revealImage = (ImageView) findViewById(R.id.revealImage);
        revealImage.post(new Runnable() {
            @Override
            public void run() {
                showAnimation();
            }
        });
    }

    private void showAnimation() {
        int cx = (revealImage.getLeft() + revealImage.getRight()) / 2;
        int cy = (revealImage.getTop() + revealImage.getBottom()) / 2;

        int finalRadius = Math.max(revealImage.getWidth(),revealImage.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(revealImage,cx,cy,0,finalRadius);
        anim.setDuration(5000);
        revealImage.setVisibility(View.VISIBLE);
        anim.start();
    }


}
