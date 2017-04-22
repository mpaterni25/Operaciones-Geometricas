package com.example.mike.operacionesgeometricastaller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cuadrado extends AppCompatActivity {

    private EditText lado;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        res=this.getResources();
        lado=(EditText)findViewById(R.id.txtCuadraLado);
        context=this;

    }
    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int ladoFinal = Integer.parseInt(lado.getText().toString());
            opera = res.getString(R.string.operacion1);
            String str = res.getString(R.string.valorLados);
            dato = str + "\n " + ladoFinal;

            int area = ladoFinal * ladoFinal;
            result = Integer.toString(area);

            new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }
    public void borrar(View v) {
        lado.setText("");
        lado.requestFocus();
    }

    public boolean validar() {
        if (lado.getText().toString().isEmpty()) {
            lado.setError(getResources().getString(R.string.error));

            return false;
        }
        return true;

    }

}
