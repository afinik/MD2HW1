package ru.finik.md2hw1;
//

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent intent = new Intent(this, MainActivity.class);
//        Button btn_trans = findViewById(R.id.btn_trans);
        ImageView iv = findViewById(R.id.iv_image1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        iv.startAnimation(animation);
        AnimationDrawable drawable = createFrameAnimAtRuntime();
        drawable.start();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(intent);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
//        this.finish();


    }

    /**
     * покадровая анимация програмно
     */
    AnimationDrawable createFrameAnimAtRuntime(){
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_1),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_2),5000);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_3),5000);
        animationDrawable.setOneShot(true);
        return animationDrawable;
    }
    /**
     * пример запуска покадровой анимации из xml
     */
//    void animframeExample(){
//        AnimationDrawable animationDrawable = (AnimationDrawable) findViewById(R.id.iv_frame_anim).getBackground();
//        animationDrawable.start();
//    }

}
