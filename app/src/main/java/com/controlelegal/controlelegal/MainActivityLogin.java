package com.controlelegal.controlelegal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityLogin extends AppCompatActivity {

    EditText Login;
    EditText Senha;
    Button   btnLogin;
    TextView txtAlerta1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        Login = findViewById(R.id.editLogin);
        Senha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        txtAlerta1 = findViewById(R.id.txtAlerta1);

        btnLogin.setOnClickListener(chamada);
    }

           View.OnClickListener chamada;

    {
        chamada = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Login.getText().toString().equals("eder")) && (Senha.getText().toString().equals("123"))) {
                    Intent intent = new Intent(MainActivityLogin.this, MainActivityGeral.class);
                    startActivity(intent);
                    finish();
                } else {
                    /*txtAlerta1.setText("Dados inválidos!!"); */
                    Toast.makeText(getApplicationContext(), "Dados inválidos!", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
