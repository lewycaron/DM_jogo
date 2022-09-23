package br.com.up.garrafa;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class paginating extends AppCompatActivity {

    private ImageView garrafa;
    private Random random = new Random();
    private int ultimadirecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tela2);
        garrafa = findViewById(R.id.fundogarrafa);
        garrafa.setOnClickListener(view -> {

            int i = 1800;

            int direction = random.nextInt(i);
            float eixoX = garrafa.getWidth() /2;
            float eixoY = garrafa.getWidth() /2;
            Animation virar = new RotateAnimation(ultimadirecao, direction, eixoX, eixoY);
            virar.setDuration(2500);
            virar.setFillAfter(true);

            ultimadirecao = direction;
            garrafa.startAnimation(virar);


        });


    }

}
