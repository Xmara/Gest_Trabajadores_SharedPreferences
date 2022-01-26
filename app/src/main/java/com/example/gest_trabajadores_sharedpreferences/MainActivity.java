package com.example.gest_trabajadores_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3,et4,et5,et6;
    private TextView tvEspecialidad;
    private CheckBox cb1, cb2, cb3;
    private Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2= (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        tvEspecialidad = (TextView) findViewById(R.id.tvEspecialidad);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);



        btn1 = (Button) findViewById(R.id.bt1);
        btn2 = (Button) findViewById(R.id.bt2);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                guardar(view);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buscar(view);
            }


        });
    }

    public void guardar(View view){
        String DNI = et1.getText().toString();
        String Nombre = et2.getText().toString();
        String Edad = et3.getText().toString();
        String Genero = et4.getText().toString();
        String Email = et5.getText().toString();
        String Teléfono = et6.getText().toString();
        String Investigador = cb1.getText().toString();




        SharedPreferences preferencias1 = getSharedPreferences("agendaNombre", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = preferencias1.edit();

        SharedPreferences preferencias2 = getSharedPreferences("agendaEdad", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = preferencias2.edit();

        SharedPreferences preferencias3 = getSharedPreferences("agendaGenero", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = preferencias3.edit();

        SharedPreferences preferencias4 = getSharedPreferences("agendaEmail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor4 = preferencias4.edit();

        SharedPreferences preferencias5 = getSharedPreferences("agendaTeléfono", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor5 = preferencias5.edit();

        SharedPreferences preferencias6 = getSharedPreferences("agendaInvestigador", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor6 = preferencias6.edit();

        boolean cb1checked = cb1.isChecked();
        if (cb1checked) {
            cb1.setChecked(true);
        }else{
            cb1.setChecked(false);
        }







       editor1.putString(DNI, Nombre);
       editor1.commit();
        et1.setText("");
        et2.setText("");

        editor2.putString(DNI, Edad);
        editor2.commit();
        et1.setText("");
        et3.setText("");

        editor3.putString(DNI, Genero);
        editor3.commit();
        et1.setText("");
        et4.setText("");

        editor4.putString(DNI, Email);
        editor4.commit();
        et1.setText("");
        et5.setText("");

        editor5.putString(DNI, Teléfono);
        editor5.commit();
        et1.setText("");
        et6.setText("");

        editor6.putString(DNI, Investigador);
        editor6.commit();
        et1.setText("");
        et6.setText("");




    }

    private void spinner1(String s) {
    }

    public void buscar(View view){
        String DNI = et1.getText().toString();
        SharedPreferences preferencias1 = getSharedPreferences("agendaNombre", Context.MODE_PRIVATE);
        String cad1 = preferencias1.getString(DNI, "");
        if(cad1.length() == 0){
            Toast.makeText(this,"No hay datos para este DNI", Toast.LENGTH_SHORT).show();
        }else{
            et2.setText(cad1);
        }

        SharedPreferences preferencias2 = getSharedPreferences("agendaEdad", Context.MODE_PRIVATE);
        String cad2 = preferencias2.getString(DNI, "");
        if(cad2.length() == 0){
            Toast.makeText(this,"No hay datos para este DNI", Toast.LENGTH_SHORT).show();
        }else{
            et3.setText(cad2);
        }

        SharedPreferences preferencias3 = getSharedPreferences("agendaGenero", Context.MODE_PRIVATE);
        String cad3 = preferencias3.getString(DNI, "");
        if(cad3.length() == 0){
            Toast.makeText(this,"No hay datos para este DNI", Toast.LENGTH_SHORT).show();
        }else{
            et4.setText(cad3);
        }

        SharedPreferences preferencias4 = getSharedPreferences("agendaEmail", Context.MODE_PRIVATE);
        String cad4 = preferencias4.getString(DNI, "");
        if(cad4.length() == 0){
            Toast.makeText(this,"No hay datos para este DNI", Toast.LENGTH_SHORT).show();
        }else{
            et5.setText(cad4);
        }

        SharedPreferences preferencias5 = getSharedPreferences("agendaTeléfono", Context.MODE_PRIVATE);
        String cad5 = preferencias5.getString(DNI, "");
        if(cad5.length() == 0){
            Toast.makeText(this,"No hay datos para este DNI", Toast.LENGTH_SHORT).show();
        }else{
            et6.setText(cad5);
        }

        SharedPreferences preferencias6 = getSharedPreferences("agendaInvestigador", Context.MODE_PRIVATE);
        String cad6 = preferencias6.getString(DNI, "");
        if(cb1.equals("1")){
            cb1.setChecked(true);
        }else{
            cb1.setChecked(false);
        }


    }

}