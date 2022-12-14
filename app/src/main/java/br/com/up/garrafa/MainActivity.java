package br.com.up.garrafa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button btn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_button = findViewById(R.id.btn_button);

        btn_button.setOnClickListener(view -> {

            Intent telaRoleta = new Intent(MainActivity.this, RoletaActivity.class);
            startActivity(telaRoleta);

        });
    }
}