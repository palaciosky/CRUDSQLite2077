package entidades;

import  android.content.Context;
import  android.content.ContentValues;
import  android.content.DialogInterface;
import  android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;
import  android.util.Log;
import  android.widget.Toast;

import androidx.annotation.Nullable;
import  androidx.appcompat.widget.AlertDialogLayout;
import  java.text.SimpleDateFormat;
import  java.util.ArrayList;
import  java.util.Calendar;



public class ConexionSQLite extends SQLiteOpenHelper{

    boolean statusdel = true;

    ArrayList<String> listaArts;//informacion que se representara en la vista de lista
    ArrayList<DTO> artList; //Entidad que representara los datos de la tabla articulos

    public ConexionSQLite( Context context) {
        super(context, "administracion.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table articulos(codigo integer not null primary key," +
                "descripcion text, precio real)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists articulos");
        onCreate(db);
    }
}
