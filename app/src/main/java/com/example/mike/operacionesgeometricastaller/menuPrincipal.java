package com.example.mike.operacionesgeometricastaller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class menuPrincipal extends Activity {
    
    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ls=(ListView)findViewById(R.id.lstMenuPrincipal);
        res=this.getResources();
        opc=res.getStringArray(R.array.lstOpciones);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        i = new Intent(menuPrincipal.this, Areas.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(menuPrincipal.this, Volumen.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(menuPrincipal.this, Resultados.class);
                        startActivity(i);
                        break;
                }
            }
        });
        
    }
}
