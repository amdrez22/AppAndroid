package com.amd.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.userName);
        password = findViewById(R.id.userPassword);
    }


    //Method Create Account
    public void LogIn (View view){

        String uss = name.getText().toString().toUpperCase();
        String pass = password.getText().toString();

        List<Usuario> lista = Usuario.find(Usuario.class, "UPPER(user)="+"'"+uss+"'", null);
        if(lista.size() == 0){
            Toast.makeText(getApplicationContext(),"User name does not exist",
                    Toast.LENGTH_LONG).show();
        }else {
            Usuario registro = lista.get(0);
            if(pass.equals(registro.getPassword())){
                Intent logIn = new Intent(this, Admin.class);
                startActivity(logIn);
            }else{
                Toast.makeText(getApplicationContext(), "Error user / Password:",
                        Toast.LENGTH_LONG).show();
            }

        }
    }



    //Method Create Account
    public void CreateAccount (View view){
        Intent createAccount = new Intent(this, register.class);
        startActivity(createAccount);
    }

    //Method Show BD
    public void ShowDB (View view){
        Intent showDB = new Intent(this, Admin.class);
        startActivity(showDB);
    }


}