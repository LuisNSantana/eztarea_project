package com.example.eztareaversion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.nio.channels.Selector;


// clase LOGIN
public class MainActivity extends AppCompatActivity {

    FloatingActionButton boton1;

    EditText correo;
    EditText pass;
    Button botonLogin;
    //Aqui hacemos un cursor que recorrera la tabla de la base de datos
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registro.class);
                startActivity(intent);

            }
        });
        //aqui volvemos a crear un objeto de nuestra clase db con este contexto
        final db dbHelp = new db(this);

        correo = (EditText) findViewById(R.id.editTextCorreo);
        pass = (EditText) findViewById(R.id.editTextPass);
        botonLogin = (Button) findViewById(R.id.buttonIngreso);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase dbbb = dbHelp.getWritableDatabase();
                String email  = correo.getText().toString();
                String password = pass.getText().toString();
                //Aqui le instanciamos al cursor con el metodo rawQuery los datos que queremos selecionar de la tabla
                cursor = dbbb.rawQuery("select email, password from registros where email='" +email+"' and password= '"+ password + "'", null);
                // aqui utilizamos el cursor para recorrer esos datos selecionados y validamos
                if (cursor.moveToFirst()){
                    /*
                    Aqui instanciamos cursor con el metodo getString para que nos coja los valores
                    de la tabla que hemos hecho anteriormente y le especificamos la columna de las cuales
                    quiere que cojamos los datos
                     */
                    String ema = cursor.getString(0);
                    String paa = cursor.getString(1);
                    /*
                    Aqui validamos que los datos sean iguales a los de la tabla
                    para que se pueda acceder a la aplicacion
                     */
                    if ((email.equals(ema)&& password.equals(paa))){

                        Intent intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                        correo.setText("");
                        pass.setText("");
                    }
                }




            }
        });



    }
}
