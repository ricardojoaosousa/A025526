package com.example.a025526.finalapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by a025526 on 19/01/2018.
 */

public class ListaEmpresas extends EmpresasActivity {

    DatabaseHelper mydb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaempresas);
        final ListView listView = (ListView) findViewById(R.id.listview);
        mydb = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = mydb.getAllData();

        if(data.getCount() == 0){
            Toast.makeText(ListaEmpresas.this, "A base de dados está vazia", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v,int position, long id){
                    Intent intent = new Intent(ListaEmpresas.this, PerfilEmpresa.class);
                    intent.putExtra("LISTA", listView.getItemAtPosition(position).toString());
                    startActivity(intent);

            }
        });
    }
}
