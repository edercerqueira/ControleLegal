package com.controlelegal.controlelegal;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Dao extends SQLiteOpenHelper {

     List<String> listaGeral;
     static String banco = "ControleLegal.db";
     static int versao  = 1;

     public Dao (Context context) {super(context, banco, null, versao);}

    @Override
    // Cria tabela
    public void onCreate(SQLiteDatabase db) {
         String sql = "create table receita (id_receita integer not null primary key autoincrement, "+
                                    "editValor varchar(10), "+
                                    "editDtRecebimento varchar(8), "+
                                    "editDescricao varchar(250)," +
                                    "spinnerConsolid char(1)," +
                                    "spinnerCompart char(1)," +
                                    "editObs varchar(250))";
         db.execSQL(sql);

         String sql2 = "create table despesa (id_despesa integer not null primary key autoincrement, "+
                                    "editValor varchar(10), "+
                                    "editDtVencimento varchar(8), "+
                                    "editDescricao varchar(250)," +
                                    "spinnerConsolid char(1)," +
                                    "spinnerCompart char(1)," +
                                    "editObs varchar(250))";
         db.execSQL(sql2);
    }
    // Insert Receita
    public void inserirReceita (String editValor, String editDtRecebimento , String editDescricao, String spinnerConsolid, String spinnerCompart, String editObs){
         String sql = "insert into receita (editValor, editDtRecebimento, editDescricao, spinnerConsolid, spinnerCompart, editObs) values ('"+editValor+"','"+editDtRecebimento+"','"+editDescricao+"','"+spinnerConsolid+"','"+spinnerCompart+"','"+editObs+"')";
         getWritableDatabase().execSQL(sql);
    }

    // Insert Despesa
    public void inserirDespesa (String editValor, String editDtVencimento, String editDescricao, String spinnerConsolid, String spinnerCompart, String editObs){
        String sql = "insert into despesa (editValor, editDtVencimento, editDescricao, spinnerConsolid, spinnerCompart, editObs) values ('"+editValor+"','"+editDtVencimento+"','"+editDescricao+"','"+spinnerConsolid+"','"+spinnerCompart+"','"+editObs+"')";
        getWritableDatabase().execSQL(sql);
    }


    // Delete
//    public void onDelete(int KeyValue){
//         String tabela = "receita";
//         String linha = "id_receita";
//         String condicao = linha+"="+KeyValue;
//        String[] WhereArgs = null;
//        getWritableDatabase().delete(tabela,condicao,WhereArgs);
//
//    }
    public boolean onDelete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("receita", "id_receita ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }

    // Lista e exibe
    public List<String> Busca(){
        String tabela = "receita";
        String[] colunas = new String[]{"id_receita","editValor","editDtRecebimento", "editDescricao", "spinnerConsolid", "spinnerCompart", "editObs"};
        String condicao = null;
        String ordernacao = "1";
        Cursor c = getReadableDatabase().query(tabela, colunas,condicao,null,null,null,ordernacao);
        listaGeral = new ArrayList<String>();
        while (c.moveToNext()){
            String id_receita = c.getString(c.getColumnIndex("id_receita")).toString();
            String editValor = c.getString(c.getColumnIndex("editValor")).toString();
            String editDtRecebimento = c.getString(c.getColumnIndex("editDtRecebimento")).toString();
            String editDescricao = c.getString(c.getColumnIndex("editDescricao")).toString();
            String spinnerConsolid = c.getString(c.getColumnIndex("spinnerConsolid")).toString();
            String spinnerCompart = c.getString(c.getColumnIndex("spinnerCompart")).toString();
            String editObs = c.getString(c.getColumnIndex("editObs")).toString();

            listaGeral.add(id_receita+"','"+editValor+"','"+editDtRecebimento+"','"+editDescricao+"'',"+spinnerConsolid+"','"+spinnerCompart+"','"+editObs);
        }
        return listaGeral;
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
