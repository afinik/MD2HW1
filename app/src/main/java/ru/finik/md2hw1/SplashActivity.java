package ru.finik.md2hw1;
//

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        Button btn_trans = findViewById(R.id.btn_trans);
        ImageView iv = findViewById(R.id.iv_image1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        iv.startAnimation(animation);
//        TextView textView = findViewById(R.id.txt_button);
//        AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_fly);
//        ObjectAnimator objectAnimator = new ObjectAnimator();
//        animator.setTarget(findViewById(R.id.txt_button));
//        animator.start();

;
            animframeExample();


    }

    /**
     * покадровая анимация програмно
     */
    AnimationDrawable createFrameAnimAtRuntime(){
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_1),500);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_2),500);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_3),500);
        animationDrawable.setOneShot(true);
        return animationDrawable;
    }
    /**
     * пример запуска покадровой анимации из xml
     */
    void animframeExample(){
        AnimationDrawable animationDrawable = (AnimationDrawable) findViewById(R.id.iv_frame_anim).getBackground();
        animationDrawable.start();
    }

}
