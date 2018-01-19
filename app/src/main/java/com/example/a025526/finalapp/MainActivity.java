package com.example.a025526.finalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EcraLogin();
    }
    private void EcraLogin() {
        Button clicado = (Button) findViewById(R.id.bentrar);
        clicado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Principal.class));
            }
        });

    }

}
