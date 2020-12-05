package com.merino.safe_and_security;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class Logo extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.abajo);

        final TextView deTextView = findViewById(R.id.Seguridad);
        TextView deTextView2 = findViewById(R.id.familia);
        final ImageView logoimagen = findViewById(R.id.LogoScreen);

        deTextView.setAnimation(animation2);
        deTextView2.setAnimation(animation2);
        logoimagen.setAnimation(animation1);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Logo.this,MainActivity.class);
            startActivity(intent);
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(logoimagen, "logoImageTransition");
            pairs[1] = new Pair<View, String>(deTextView,"contenido");
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Logo.this, pairs);
                        startActivity(intent, options.toBundle());
                    }else{
                        startActivity(intent);
                        finish();

                    }

        }
    },4000);

    }
}