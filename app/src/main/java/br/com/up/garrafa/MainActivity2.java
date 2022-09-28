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
    private double ultimadirecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        roleta = findViewById(R.id.idRoleta);
        roleta.setOnClickListener(view -> {
            startRoleta();
        });

    }

    public void startRoleta()
    {
        int i = 360 * 8;
        double direction = random.nextInt(i);
        float eixoX = roleta.getWidth() /2;
        float eixoY = roleta.getHeight() /2;

        Animation virar = new RotateAnimation(0, (int)direction, eixoX, eixoY);

        virar.setDuration(2500);
        virar.setFillAfter(true);
        // TODO: Descobrir o numero de voltas e a sobra multiplica por 360 vai achar a angulação.

        double numeroVoltas =  direction / 360;
        ultimadirecao = direction;
        double valor_decimal = numeroVoltas - (int)(numeroVoltas);
        double angulo = valor_decimal * 360;
        roleta.startAnimation(virar);
    }

//    angulo > 0 && angulo < 34 =  "Zero"
//    angulo > 35 && angulo < 60 =  "2$"
//    angulo > 61 && angulo < 94 =  "50$"
//    angulo > 95 && angulo < 120 =  "1$"
//    angulo > 121 && angulo < 154 =  "5$"
//    angulo > 155 && angulo < 180 =  "20$"
//    angulo > 181 && angulo < 213 =  "JACKPOT"
//    angulo > 214 && angulo < 239 =  "15$"
//    angulo > 240 && angulo < 272 =  "100$"
//    angulo > 273 && angulo < 299 =  "1$"
//    angulo > 300 && angulo < 333 =  "5$"
//    angulo > 334 && angulo < 359 =  "10$"

}