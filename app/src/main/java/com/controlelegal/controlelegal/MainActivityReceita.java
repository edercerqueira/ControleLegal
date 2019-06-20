package com.controlelegal.controlelegal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Date;

public class MainActivityReceita extends AppCompatActivity {

    Button btnSalvar;
    EditText editValor;
    EditText editDtRecebimento;
    EditText editDescricao;
    Spinner spinnerConsolid;
    Spinner spinnerCompart;
    EditText editObs;
    ListView listaGeral;

    Dao Dao = new Dao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receita);

        Dao = new Dao(this);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(Salvar);
        editValor = findViewById(R.id.editValor);
        editDtRecebimento = findViewById(R.id.editDtRecebimento);
        editDescricao = findViewById(R.id.editDescricao);
        spinnerConsolid = findViewById(R.id.spinnerConsolid);
        spinnerCompart = findViewById(R.id.spinnerCompart);
        editObs = findViewById(R.id.editObs);

        final String spinner[] = {"", "Sim", "Não"};

        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinner);
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConsolid.setAdapter(spinnerArrayAdapter1);

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinner);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompart.setAdapter(spinnerArrayAdapter2);


        btnSalvar.setOnClickListener(Salvar);
    }

    View.OnClickListener Salvar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String spinnerConsolInsRec = (String)spinnerConsolid.getSelectedItem();
            String spinnerCompartInsRec = (String)spinnerCompart.getSelectedItem();
            Dao.inserirReceita(editValor.getText().toString(),editDtRecebimento.getText().toString(),editDescricao.getText().toString(), spinnerConsolInsRec, spinnerCompartInsRec, editObs.getText().toString());
            Intent intent = new Intent(MainActivityReceita.this,MainActivityGeral.class);
            startActivity(intent);
        }
    };

}
