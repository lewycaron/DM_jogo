package br.com.up.garrafa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.up.garrafa.Adapter.RoletaAdapter;
import br.com.up.garrafa.Model.RoletaModel;

public class RoletaActivity extends AppCompatActivity{
    private ImageView roleta;
    private Random random = new Random();
    private RecyclerView recycleView;
    private List<RoletaModel> listaRoleta = new ArrayList<>();

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

        roleta.startAnimation(rodarRoletaAnimation);
        calculaAnguloRoleta(direcao, anguloRoleta);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            createRecycleView();
        }, 2500);

    }

    public void createRecycleView(){
        recycleView = findViewById(R.id.recycleViewRoleta);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setHasFixedSize(true);
        RoletaAdapter adapter = new RoletaAdapter(listaRoleta);
        recycleView.setAdapter(adapter);
        recycleView.smoothScrollToPosition(0);
    }

    public void traduzValores(double anguloRoleta){

        String valorRoleta = "";
        if(anguloRoleta >= 0 && anguloRoleta < 27){valorRoleta = "R$10";}
        if(anguloRoleta >= 27 && anguloRoleta < 61){valorRoleta = "R$5";}
        if(anguloRoleta >= 61 && anguloRoleta < 88){valorRoleta = "R$1";}
        if(anguloRoleta >= 88 && anguloRoleta < 121){valorRoleta = "R$100";}
        if(anguloRoleta >= 121 && anguloRoleta < 147){valorRoleta = "R$15";}
        if(anguloRoleta >= 147 && anguloRoleta < 180){valorRoleta = "JACKPOT";}
        if(anguloRoleta >= 180 && anguloRoleta < 207){valorRoleta = "R$20";}
        if(anguloRoleta >= 207 && anguloRoleta < 239){valorRoleta = "R$5";}
        if(anguloRoleta >= 239 && anguloRoleta < 266){valorRoleta = "R$1";}
        if(anguloRoleta >= 266 && anguloRoleta < 299){valorRoleta = "R$50";}
        if(anguloRoleta >= 299 && anguloRoleta < 326){valorRoleta = "R$2";}
        if(anguloRoleta >= 326 && anguloRoleta < 360){valorRoleta = "Zero";}
        criarPremiacao(valorRoleta);
    }

    public void calculaAnguloRoleta(double direcao, int anguloRoleta){
        double numeroVoltasRoleta =  direcao / anguloRoleta;
        double sobraVoltas = numeroVoltasRoleta - (int)(numeroVoltasRoleta);
        double anguloReal = sobraVoltas * anguloRoleta;
        traduzValores(anguloReal);
    }

    public void criarPremiacao(String premiacao){
        RoletaModel roleta = new RoletaModel(premiacao);
        listaRoleta.add(0, roleta);
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