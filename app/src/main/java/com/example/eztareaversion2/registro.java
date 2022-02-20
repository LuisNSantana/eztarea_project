package com.example.eztareaversion2;



import androidx.appcompat.app.AppCompatActivity;
//esta es nuestra clase registro donde se rellenaran los datos de nuestro formulario
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class registro extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    FloatingActionButton enviar;
    EditText password;
    EditText apodo;
    EditText email;
    //aqui instanciamos un objeto de nuestra clase db para utilizarlo en nuestro listener
    db dbhelp = new db(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        enviar = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellido = (EditText) findViewById(R.id.editTextApellidos);
        apodo = (EditText) findViewById(R.id.editTextApe);
        password = (EditText) findViewById(R.id.editTextPass);
        email = (EditText) findViewById(R.id.editTextCorreo);
/*
En este listener vamos a validar los datos y pasarlos a string para que
puedan ser validados de la forma correcta en la base de datos
 */
        enviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //aqui instanciamos un objeto de la clase SQLiteDataBase para que agarre los datos de nuestra tabla
                SQLiteDatabase dbb = dbhelp.getWritableDatabase();
                Editable cogeNombre = nombre.getText();
                String cogeNombres = nombre.getText().toString();
                Editable cogeApellido = apellido.getText();
                String cogeApellidos = apellido.getText().toString();
                Editable cogeApodo = apodo.getText();
                String cogeApodos = apodo.getText().toString();
                Editable cogePass = password.getText();
                String cogePassw = password.getText().toString();
                Editable cogeEmail = email.getText();
                String cogeEmails = email.getText().toString();

                /*
                En esta condicion validamos que exista la base de datos y ejecutamos la sentencia
                execSQL que sirve ejecutar una sentencia sql
                 */
                if (dbb != null) {
                    //aqui utilizamos la forma de instanciar datos en un tabla en sql
                    dbb.execSQL("INSERT INTO registros (nombre,apellido,apodo,password,email) VALUES ('"
                            + cogeNombres + "','" + cogeApellidos + "','" + cogeApodos + "','" + cogePassw + "','" +
                            cogeEmails + "')");
                    //Esto es opcional por si queremos saber la ubicacion exacta de donde se encuentra nuestra bd
                    System.out.println(getDatabasePath("eztarea3.sqlite").getAbsolutePath());

                     Intent intent = new Intent(registro.this, MainActivity.class);
                     startActivity(intent);

                }


            }

        });


    }
}
