package com.amd.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class Admin extends AppCompatActivity {
    EditText name, user, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        name = findViewById(R.id.fullName);
        user = findViewById(R.id.userName);
        email = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
    }


    public void Read(View view){
        String uss = user.getText().toString().toUpperCase();

        List<Usuario> lista = Usuario.find(Usuario.class, "UPPER(user)="+"'"+uss+"'", null);
        if(lista.size() == 0){
            Toast.makeText(getApplicationContext(),"User name does not exist",
                    Toast.LENGTH_LONG).show();
        }else {
            Usuario registro = lista.get(0);
            name.setText(registro.getName());
            user.setText(registro.getUser());
            email.setText(registro.getEmail());
            password.setText(registro.getPassword());
        }

    }

    public void Update(View view){
        String uss = user.getText().toString().toUpperCase();

        List<Usuario> lista = Usuario.find(Usuario.class, "UPPER(user)="+"'"+uss+"'", null);
        if(lista.size() == 0){
            Toast.makeText(getApplicationContext(),"User name does not exist",
                    Toast.LENGTH_LONG).show();
        }else {
            Usuario registro = lista.get(0);
            registro.setName(name.getText().toString());
            registro.setEmail(email.getText().toString());
            registro.setPassword(password.getText().toString());
            registro.save();


            name.setText("");
            user.setText("");
            email.setText("");
            password.setText("");

            Toast.makeText(getApplicationContext(), "Successful updated"
                    ,Toast.LENGTH_LONG).show();
        }
    }

    public void Delete(View view){
        String uss = user.getText().toString().toUpperCase();

        List<Usuario> lista = Usuario.find(Usuario.class, "UPPER(user)="+"'"+uss+"'", null);
        if(lista.size() == 0){
            Toast.makeText(getApplicationContext(),"User name does not exist",
                    Toast.LENGTH_LONG).show();
        }else {
            Usuario registro = lista.get(0);
            registro.delete();
            Toast.makeText(getApplicationContext(),"User deleted",
                    Toast.LENGTH_LONG).show();
        }

        name.setText("");
        user.setText("");
        email.setText("");
        password.setText("");
    }


    //Method Return Back

    public void Back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }


}

