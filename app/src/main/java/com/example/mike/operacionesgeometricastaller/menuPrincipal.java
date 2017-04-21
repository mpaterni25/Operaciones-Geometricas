package com.example.mike.operacionesgeometricastaller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class menuPrincipal extends Activity {

    private ListView ls;
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
        opc=res.getStringArray(R.array.lstMenuprincipal);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);

        
    }
}
