package com.amd.clase1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class register extends AppCompatActivity {
    EditText name, user, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

            name = findViewById(R.id.fullName);
            user = findViewById(R.id.userName);
            email = findViewById(R.id.emailAddress);
            password = findViewById(R.id.password);
    }


    public void Create(View view){
        String uss = user.getText().toString().toUpperCase();

        List<Usuario> lista = Usuario.find(Usuario.class, "UPPER(user)="+"'"+uss+"'", null);
        if(lista.size() != 0){
            Toast.makeText(getApplicationContext(),"User name already exists",
                    Toast.LENGTH_LONG).show();
        }else {
            String nom = name.getText().toString();
            String users = user.getText().toString();
            String mail = email.getText().toString();
            String pass = password.getText().toString();

            Usuario u1 = new Usuario(nom, users, mail, pass);
            u1.save();

            name.setText("");
            user.setText("");
            email.setText("");
            password.setText("");

            Toast.makeText(getApplicationContext(), "Successful registration"
                    ,Toast.LENGTH_LONG).show();
        }
    }


    //Method Return Back

    public void Back(View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }


}

