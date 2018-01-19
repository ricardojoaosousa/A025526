package com.example.a025526.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by a025526 on 03/01/2018.
 */

public class Principal extends MainActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        EcraAdmin();
    }
    private void EcraAdmin() {
        Button clicado = (Button) findViewById(R.id.bempresas);
        clicado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Principal.this, EmpresasActivity.class));
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.principal, menu);
    return true;
}
}
