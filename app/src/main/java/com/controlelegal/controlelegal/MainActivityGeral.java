package com.controlelegal.controlelegal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityGeral extends AppCompatActivity {

    Button btnSair;
    Button btnReceita;
    Button btnDespesa;
    /*EditText editValor;*/
    ListView listaGeral;

    ArrayAdapter<String> adpt;

    List<String> listagem;

    Dao Geral = new Dao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_geral);
        //DECLARAÇÃO DE VARIAVEIS
        btnSair = findViewById(R.id.btnSair);
        listaGeral = findViewById(R.id.listaGeral);
        btnReceita = findViewById(R.id.btnReceita);
        btnDespesa = findViewById(R.id.btnDespesa);





        listagem = new ArrayList<String>();
        listagem = Geral.Busca();

        //Passar parâmetros para o adapter
        adpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listagem);
        listaGeral.setAdapter(adpt);



        //inserir o adapter na ListView

        btnSair.setOnClickListener(Sair);
        btnReceita.setOnClickListener(Receita);
        btnDespesa.setOnClickListener(Despesa);

        Toast.makeText(getApplicationContext(), "Bem vindo!!", Toast.LENGTH_SHORT).show();

        listaGeral.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

               // String linha = listagem.get(position);
//                String codigo = linha.substring(0,linha.indexOf(1));

//               Toast.makeText(getApplicationContext(), "Registro "+codigo+" excluído!!", Toast.LENGTH_SHORT).show();

                String teste = listagem.get(position);
                Toast.makeText(MainActivityGeral.this, teste, Toast.LENGTH_SHORT).show();
                String x = String.valueOf(position);

                Geral.onDelete(Integer.valueOf(x));
                Exibir();
                return false;
            }
        });

        /* Exibir(); */
    }



    View.OnClickListener Sair = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            Intent intent = new Intent(MainActivityGeral.this, MainActivityLogin.class);
            startActivity(intent);
        }
    };

    View.OnClickListener Receita = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivityGeral.this, MainActivityReceita.class);
            startActivity(intent);
        }
    };

    View.OnClickListener Despesa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivityGeral.this, MainActivityDespesa.class);
            startActivity(intent);
        }
    };

    public void Exibir(){
        listagem = Geral.Busca();
        adpt = new ArrayAdapter<String>(MainActivityGeral.this,  android.R.layout.simple_list_item_1, listagem);
        listaGeral.setAdapter(adpt);
    }

}
