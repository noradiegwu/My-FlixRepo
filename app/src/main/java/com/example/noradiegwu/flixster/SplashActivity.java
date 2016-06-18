package com.example.noradiegwu.flixster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    //@BindView(R.id.ivSplashImg) ImageView ivSplashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //ButterKnife.bind(this);
        final ImageView ivSplashImage = (ImageView) findViewById(R.id.ivSplashImg);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotation);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);

        ivSplashImage.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivSplashImage.startAnimation(an2);
                finish();
                Intent i = new Intent(SplashActivity.this, MoviesActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //final ImageView ivSplashImg = (ImageView) findViewById(R.id.ivSplashImg);



    }
}
