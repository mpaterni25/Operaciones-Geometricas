package com.example.mike.operacionesgeometricastaller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cono extends AppCompatActivity {

    private EditText radio, altura;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        res = this.getResources();
        radio = (EditText) findViewById(R.id.txtRadCon);
        altura = (EditText) findViewById(R.id.txtAltCon);
        context = this;
    }

    public void guardar(View v) {
        String opera, dato, result;

        int radioFinal = Integer.parseInt(radio.getText().toString());
        int alturaFinal = Integer.parseInt(altura.getText().toString());
        opera = res.getString(R.string.operacion7);
        String str = res.getString(R.string.radio);
        String str2 = res.getString(R.string.altura);
        dato = str + "\n " + radioFinal + "\n" + str2 + "\n " + alturaFinal;

        double volumen = (Math.PI * radioFinal * radioFinal * alturaFinal) / 3;
        volumen = (double) ((int) (volumen * 100.0) / 100.0);
        result = Double.toString(volumen);

        new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

        Operaciones o = new Operaciones(opera, dato, result);
        o.guardar();
        borrar(v);
    }

    public void borrar(View v) {
        radio.setText("");
        altura.setText("");
        radio.requestFocus();
    }


}

