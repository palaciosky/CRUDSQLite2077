package com.example.sqllitepoo;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import  android.widget.Toast;
import  android.widget.Button;

import  android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;
import  android.content.Intent;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import entidades.ConexionSQLite;
import entidades.DTO;

public class MainActivity extends AppCompatActivity {

    private EditText etcod,etdesc,etpz;
    private Button btng,btnbcod,btndes,btnmod,btndell;
    private TextView result;

   // "Despues se activa" Modal ventanas = new Modal();
    ConexionSQLite conexion = new ConexionSQLite(this);
    DTO dato = new DTO();
    AlertDialog.Builder wiuwiu;

    public boolean onKeyDown(int KeyCode, KeyEvent event){
        if (KeyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.cancel)
                    .setTitle("Advertencia")
                    .setMessage("¿Quieres salir?")
                    .setNegativeButton(android.R.string.cancel,null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                        }
                    })
                    .show();

            return true;
        }

        return  super.onKeyDown(KeyCode,event);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.bacl));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitleMargin(0,0,0,0);
        toolbar.setSubtitle("CRUD SQLite 2077");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Palaciosky");
        setSupportActionBar(toolbar);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmation();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ventanas.Search(MainActivity.this);
            }
        });

        etcod = (EditText) findViewById(R.id.et1);
        etdesc = (EditText) findViewById(R.id.et2);
        etpz = (EditText) findViewById(R.id.et3);

        btnbcod = (Button) findViewById(R.id.concod);
        btndes = (Button) findViewById(R.id.condes);
        btng = (Button) findViewById(R.id.btgrd);
        btnmod = (Button) findViewById(R.id.btnmod);
        btndell = (Button) findViewById(R.id.btdell);

        String signal = "";
        String codigo = "";
        String desc = "";
        String prezio = "";

        try {
            Intent intento = getIntent();
            Bundle bun = Intent.getExtras();
            if (bun != null){
                codigo = bun.getString("codigo");
                signal = bun.getString("signal");
                desc = bun.getString("desc");
                prezio = bun.getString("prezio");

                if (signal.equals("1")){
                    etcod.setText(codigo);
                    etdesc.setText(desc);
                    etpz.setText(prezio);
                }
            }

        }catch (Exception o){
            //AQUI SAMPARE UN TOAST CUANDO ME ACUERDE SINO ME AVISAN
        }


    }


    private void comfirmacion(){
        String msm = "¿Quieres salir";
        wiuwiu = new AlertDialog.Builder(MainActivity.this);
        wiuwiu.setIcon(R.drawable.cancel);
        wiuwiu.setTitle("Advertencia");
        wiuwiu.setMessage(msm);
        wiuwiu.setCancelable(false);
        wiuwiu.setPositiveButton("SHI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });

        wiuwiu.setNegativeButton("ÑO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        wiuwiu.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_listaArt){
            Intent spinnerAct = new Intent(MainActivity.this,Consu)
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}