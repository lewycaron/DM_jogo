package br.com.up.garrafa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    private ImageView roleta;
    private Random random = new Random();
    private int ultimadirecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        roleta = findViewById(R.id.idRoleta);
        roleta.setOnClickListener(view -> {



            int i = 2880;
            int direction = random.nextInt(i);
            float eixoX = roleta.getWidth() /2;
            float eixoY = roleta.getHeight() /2;

            Animation virar = new RotateAnimation(ultimadirecao, direction, eixoX, eixoY);
            virar.setDuration(2500);
            virar.setFillAfter(true);

            ultimadirecao = direction;
            roleta.startAnimation(virar);


        });

    }
}