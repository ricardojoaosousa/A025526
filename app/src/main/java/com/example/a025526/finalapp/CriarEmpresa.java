package com.example.a025526.finalapp;

import android.app.AlertDialog;
import android.database.Cursor;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ricardo on 15/01/18.
 */

public class CriarEmpresa extends EmpresasActivity{
    DatabaseHelper myDb;
    EditText editNome, editRua, editTelefone ,editTextId, editEmail;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criarempresa);
        myDb = new DatabaseHelper(this);

        editTextId = (EditText)findViewById(R.id.editTextId);
        editNome = (EditText)findViewById(R.id.editNome);
        editRua = (EditText)findViewById(R.id.editRua);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editTelefone = (EditText)findViewById(R.id.editTelefone);


        btnAddData = (Button)findViewById(R.id.btnAddData);
        btnviewAll = (Button)findViewById(R.id.btnviewAll);
        btnUpdate= (Button)findViewById(R.id.btnUpdate);
        btnDelete= (Button)findViewById(R.id.btnDelete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(CriarEmpresa.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CriarEmpresa.this,"Insere um ID",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editNome.getText().toString(),
                                editRua.getText().toString(),
                                editTelefone.getText().toString(),
                                editEmail.getText().toString());

                        if(isUpdate == true)
                            Toast.makeText(CriarEmpresa.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CriarEmpresa.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editNome.getText().toString(),
                                editRua.getText().toString(),
                                editTelefone.getText().toString(),
                                editEmail.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(CriarEmpresa.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CriarEmpresa.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("\n"+"Id : "+ res.getString(0)+"\n\n");
                            buffer.append("Nome : "+ res.getString(1)+"\n");
                            buffer.append("Rua : "+ res.getString(2)+"\n");
                            buffer.append("Telefone : "+ res.getString(3)+"\n");
                            buffer.append("Email : "+ res.getString(4)+"\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}