package jsilv.app.calculadora;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;
import android.app.*;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText et_num1, et_num2;
    private Button btn_Somar, btn_Subtrair, btn_Multiplicar, btn_Dividir;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        et_num1 = (EditText) findViewById(R.id.et_Num1);
        et_num2 = (EditText) findViewById(R.id.et_Num2);

        btn_Somar = (Button) findViewById(R.id.btn_Somar);
        btn_Subtrair = (Button) findViewById(R.id.btn_Subtrair);
        btn_Multiplicar = (Button) findViewById(R.id.btn_Multiplicar);
        btn_Dividir = (Button) findViewById(R.id.btn_Dividir);

        btn_Somar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double num1 = Double.parseDouble(et_num1.getText().toString());
                double num2 = Double.parseDouble(et_num2.getText().toString());
                double resultado = num1 + num2;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
                dialogo.setTitle("Resutado soma");
                dialogo.setMessage(num1 + " + " + num2 + " = " + resultado);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
            }
        });

        btn_Subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(et_num1.getText().toString());
                double num2 = Double.parseDouble(et_num2.getText().toString());
                double resultado = num1 - num2;

                AlertDialog.Builder dialog = new AlertDialog.Builder(CalculadoraActivity.this);
                dialog.setTitle("Resultado");
                dialog.setMessage(num1 + " - " + num2 + " = " + resultado );
                dialog.setNeutralButton("Ok", null);
                dialog.show();
            }
        });

        btn_Dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(et_num1.getText().toString());
                double num2 = Double.parseDouble(et_num2.getText().toString());
                double resultado = num1 / num2;
                //if(et_num2.getText().toString().equalsIgnoreCase("0")){
                if(num2 == 0){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CalculadoraActivity.this);
                    dialog.setMessage("Impossivel divisão por 0");
                    dialog.setTitle("Ups");
                    dialog.setNeutralButton("Ok", null);
                    dialog.show();
                } else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CalculadoraActivity.this);
                    dialog.setTitle("Dividir");
                    dialog.setMessage(num1 + " / " + num2 + " = " + resultado);
                    dialog.setNeutralButton("Ok",null);
                    dialog.show();
                }
            }
        });

        btn_Multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(et_num1.getText().toString());
                double num2 = Double.parseDouble(et_num2.getText().toString());
                double resultado = num1 * num2;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
                dialogo.setTitle("Multiplicação");
                dialogo.setMessage(num1 + " x " + num2 + " = " + resultado);
                dialogo.setNeutralButton("Ok",null);
                dialogo.show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Calculadora Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
