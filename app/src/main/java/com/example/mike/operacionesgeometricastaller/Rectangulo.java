package com.example.mike.operacionesgeometricastaller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Rectangulo extends AppCompatActivity {

    private EditText base, altura;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        res=this.getResources();
        base=(EditText)findViewById(R.id.txtBasRec);
        altura=(EditText)findViewById(R.id.txtAltRec);
        context=this;
    }

    public void guardar(View v){
        String opera, dato, result;

        int baseFinal = Integer.parseInt(base.getText().toString());
        int alturaFinal = Integer.parseInt(altura.getText().toString());
        opera = res.getString(R.string.operacion2);
        String str1 = res.getString(R.string.base)+"\n "+baseFinal;
        String str2 = res.getString(R.string.altura)+"\n "+alturaFinal;
        dato = str1+"\n "+str2;

        int area = baseFinal*alturaFinal;
        result = Integer.toString(area);

        new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

        Operaciones o = new Operaciones(opera, dato, result);
        o.guardar();
        borrar(v);
    }

    public void borrar(View v){
        base.setText("");
        altura.setText("");
        base.requestFocus();
    }

}
