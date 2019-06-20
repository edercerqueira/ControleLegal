package com.controlelegal.controlelegal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivityDespesa extends AppCompatActivity {

    Button btnSalvar;
    EditText editValor;
    EditText editDtVencimento;
    EditText editDescricao;
    Spinner spinnerConsolid;
    Spinner spinnerCompart;
    EditText editObs;
    ListView listaGeral;

    Dao Dao = new Dao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_despesa);

        Dao = new Dao(this);

        btnSalvar = findViewById(R.id.btnSalvar);
        editValor = findViewById(R.id.editValor);
        editDtVencimento = findViewById(R.id.editDtRecebimento);
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

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinnerConsolInsDesp = (String)spinnerConsolid.getSelectedItem();
                String spinnerCompartInsDesp = (String)spinnerCompart.getSelectedItem();
                Dao.inserirDespesa(editValor.getText().toString(), editDtVencimento.getText().toString(), editDescricao.getText().toString(), spinnerConsolInsDesp, spinnerCompartInsDesp, editObs.getText().toString());


            }

        });
    }
}
