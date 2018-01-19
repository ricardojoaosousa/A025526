package com.example.a025526.finalapp;

import android.database.Cursor;
import android.os.Bundle;
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

        ListView listView = (ListView) findViewById(R.id.listview);
        mydb = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = mydb.getAllData();

        if(data.getCount() == 0){
            Toast.makeText(ListaEmpresas.this, "The Database was empty", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
