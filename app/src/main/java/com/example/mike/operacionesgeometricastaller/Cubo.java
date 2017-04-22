package com.example.mike.operacionesgeometricastaller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cubo extends AppCompatActivity {

    private EditText arista;
    private Resources res;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        res=this.getResources();
        arista=(EditText)findViewById(R.id.txtCuboLad);
        context=this;
    }
    public void guardar(View v) {
        String opera, dato, result;
        if (validar()) {
            int aristaFinal = Integer.parseInt(arista.getText().toString());
            opera = res.getString(R.string.operacion8);
            String str = res.getString(R.string.valorLados);
            dato = str + "\n " + aristaFinal;

            double volumen = (aristaFinal * aristaFinal * aristaFinal);
            volumen = (double) ((int) (volumen * 100.0) / 100.0);
            result = Double.toString(volumen);

            new AlertDialog.Builder(context).setTitle(opera).setMessage(result).show();

            Operaciones o = new Operaciones(opera, dato, result);
            o.guardar();
            borrar(v);
        }
    }

    public void borrar(View v){
        arista.setText("");
        arista.requestFocus();
    }

    public boolean validar() {
        if (arista.getText().toString().isEmpty()) {
            arista.setError(getResources().getString(R.string.error));

            return false;
        }
        return true;

    }

}
