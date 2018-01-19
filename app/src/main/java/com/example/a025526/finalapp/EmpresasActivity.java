package com.example.a025526.finalapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ricardo on 15/01/18.
 */

public class EmpresasActivity extends Principal{

    DatabaseHelper mydb;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empresas);
        EcraCriarEmpresa();
        EcraVerEmpresas();
    }

    private void EcraCriarEmpresa() {
        Button clicado = (Button) findViewById(R.id.bcriar);
        clicado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EmpresasActivity.this, CriarEmpresa.class));
            }
        });
    }

    private void EcraVerEmpresas() {
        Button clicado1 = (Button) findViewById(R.id.bver);
        clicado1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EmpresasActivity.this, ListaEmpresas.class));
            }
        });
    }
}
