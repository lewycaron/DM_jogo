package br.com.up.garrafa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class RoletaActivity extends AppCompatActivity {


    private ImageView roleta;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roleta);


        roleta = findViewById(R.id.idRoleta);
        roleta.setOnClickListener(view -> {
            startRoleta();
        });

    }

    public void startRoleta() {
        int anguloRoleta = 360;
        int qntVoltas = 8;
        int maxVoltas = anguloRoleta * qntVoltas;

        double direcao = random.nextInt(maxVoltas);
        float eixoX = roleta.getWidth() /2;
        float eixoY = roleta.getHeight() /2;

        Animation rodarRoletaAnimation = new RotateAnimation(0, (int)direcao, eixoX, eixoY);

        rodarRoletaAnimation.setDuration(2500);
        rodarRoletaAnimation.setFillAfter(true);

        calculaAnguloRoleta(direcao, anguloRoleta);

        roleta.startAnimation(rodarRoletaAnimation);
    }

    public void traduzValores(double anguloRoleta) {
        String valorRoleta = "";
        if(anguloRoleta >= 0 && anguloRoleta < 27){valorRoleta = "10";}
        if(anguloRoleta >= 27 && anguloRoleta < 61){valorRoleta = "5";}
        if(anguloRoleta >= 61 && anguloRoleta < 88){valorRoleta = "1";}
        if(anguloRoleta >= 88 && anguloRoleta < 121){valorRoleta = "100";}
        if(anguloRoleta >= 121 && anguloRoleta < 147){valorRoleta = "15";}
        if(anguloRoleta >= 147 && anguloRoleta < 180){valorRoleta = "JACKPOT";}
        if(anguloRoleta >= 180 && anguloRoleta < 207){valorRoleta = "20";}
        if(anguloRoleta >= 207 && anguloRoleta < 239){valorRoleta = "5";}
        if(anguloRoleta >= 239 && anguloRoleta < 266){valorRoleta = "1";}
        if(anguloRoleta >= 266 && anguloRoleta < 299){valorRoleta = "50";}
        if(anguloRoleta >= 299 && anguloRoleta < 326){valorRoleta = "2";}
        if(anguloRoleta >= 326 && anguloRoleta < 360){valorRoleta = "Zero";}
    }

    public void calculaAnguloRoleta(double direcao, int anguloRoleta){
        double numeroVoltasRoleta =  direcao / anguloRoleta;
        double sobraVoltas = numeroVoltasRoleta - (int)(numeroVoltasRoleta);
        double anguloReal = sobraVoltas * anguloRoleta;

        traduzValores(anguloReal);
    }

//    angulo > 326 && angulo < 360 =  "Zero"
//    angulo > 299 && angulo < 326 =  "2$"
//    angulo > 266 && angulo < 299 =  "50$"
//    angulo > 239 && angulo < 266 =  "1$"
//    angulo > 207 && angulo < 239 =  "5$"
//    angulo > 180 && angulo < 207 =  "20$"
//    angulo > 147 && angulo < 180 =  "JACKPOT"
//    angulo > 121 && angulo < 147 =  "15$"
//    angulo > 88 && angulo < 121 =  "100$"
//    angulo > 61 && angulo < 88 =  "1$"
//    angulo > 27 && angulo < 61 =  "5$"
//    angulo > 0 && angulo < 27 =  "10$"

}