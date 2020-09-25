package com.example.sqllitepoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import entidades.ConexionSQLite;
import entidades.DTO;

public class activity_consulta extends AppCompatActivity {
    private Spinner spoptions;
    private TextView tcod,tdec,tpz;

    ConexionSQLite conexion = new ConexionSQLite(this);
    DTO dato = new DTO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        spoptions = (Spinner)findViewById(R.id.spioptions);
        tcod = (TextView) findViewById(R.id.codspin);
        tdec = (TextView) findViewById(R.id.descpin);
        tpz = (TextView) findViewById(R.id.pzspin);

        conexion.consultarListaArticulos();

        ArrayAdapter<CharSequence> adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item,conexion.obtenerListaArticulos());
        spoptions.setAdapter(adap);

        spoptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    tcod.setText("Codigo: "+conexion.consultarListaArticulos().get(i-1).getCodigo());
                    tdec.setText("Descripcion: "+conexion.consultarListaArticulos().get(i-1).getDescripcion());
                    tpz.setText("Precio: "+conexion.consultarListaArticulos().get(i-1).getPrecio());

                }else
                    {
                    tcod.setText("Codigo: VACIO");
                    tdec.setText("Descripción: VACIO");
                    tpz.setText("Precio: VACIO");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}