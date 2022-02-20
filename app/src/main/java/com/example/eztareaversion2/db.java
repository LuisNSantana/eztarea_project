package com.example.eztareaversion2;
//Esta clase la hemos creado para hacer la base de datos
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
Aqui instanciamos el nombre de la clase y extendemos la clase SQLiteOpeHelper
que es la que nos ofrece los metodos para poder crear e instanciar nuestra base de datos
 */
public class db extends SQLiteOpenHelper {
    //En este atributo creamos la tabla que haremos en nuestra base de datos, se instancia la sentencia que utiliza sql para crear una tabla
    private static final  String REGISTROS_TABLE_CREATE = "CREATE TABLE  registros (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, apodo VARCHAR(250), password VARCHAR(250), email VARCHAR(250))";
    /*
    En este atributo instanciamos el nombre que va a utilizar la bd y le añadimos .sqlite para
    que se cree el archivo con el nombre de la tabla
     */
    private  static final String DB_NAME="eztarea3.sqlite";
    //aca instanciamos la version de base de datos que vamos a utilizar
    private static final  int DB_VERSION = 1;

    //en esta funcion instanciamos el nombre de la bd y la ersion
    public db (Context context){super(context,  DB_NAME, null, DB_VERSION);}

    @Override
    //Ejecuto la query de crear la tabla como se puede ver el metodo que se utilizar
    //para ejecutar la bd es el "execSQL"
    public void onCreate(SQLiteDatabase db){db.execSQL(REGISTROS_TABLE_CREATE);}
    // este metodo es para actualizar nuestra base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int new_version, int old_version){


    }



}
