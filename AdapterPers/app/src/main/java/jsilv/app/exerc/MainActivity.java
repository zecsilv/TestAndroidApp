package jsilv.app.exerc;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements Serializable {

    private Button btnAdd, btnList;
    private EditText editText;
    private ArrayList<Word> arrayWords;
    private int cont = 0;

    private ArrayList<Word> getArrayWords() {
        if (arrayWords == null) {
            arrayWords = new ArrayList<Word>();
        }
        return arrayWords;
    }

    private EditText getEditText() {
        if (editText == null) {
            editText = (EditText) findViewById(R.id.edInputText);
        }
        return editText;
    }

    private Button getBtnAdd() {
        if (btnAdd == null) {
            btnAdd = (Button) findViewById(R.id.btnAdd);
        }
        return btnAdd;
    }

    private Button getBtnList() {
        if (btnList == null) {
            btnList = (Button) findViewById(R.id.btnList);
        }
        return btnList;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insere_texto);
        ;

        getBtnAdd().setOnClickListener(new View.OnClickListener() {  // Action Button "Add"
            @Override
            public void onClick(View view) {
                if (getEditText().getText().toString().equals("")) {
                    String aux = "UPS \n" +
                            " Edit Text Vazia! \n" +
                            " Digite Texto...";
                    alert(aux);
                } else {
                    addElement();
                }
            }
        });

        getBtnList().setOnClickListener(new View.OnClickListener() { // Action Button "List"
            @Override
            public void onClick(View view) {
                if (getArrayWords().size() == 0) {
                    String aux = "Não existem elementos para listar";
                    alert(aux);
                } else {


                    Word a0 = new Word("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", getDataAtual());
                    getArrayWords().add(a0);
                    Word a1 = new Word("bbbbb", getDataAtual());
                    getArrayWords().add(a1);
                    Word a2 = new Word("cccccc", getDataAtual());
                    getArrayWords().add(a2);
                    Word a3 = new Word("ddddd", getDataAtual());
                    getArrayWords().add(a3);
                    Word a4 = new Word("eeeee", getDataAtual());
                    getArrayWords().add(a4);
                    Word a5 = new Word("fffff", getDataAtual());
                    getArrayWords().add(a5);
                    Word a6 = new Word("gggg", getDataAtual());
                    getArrayWords().add(a6);
                    Word a7 = new Word("hhhhh", getDataAtual());
                    getArrayWords().add(a7);
                    Word a8 = new Word("cccccc", getDataAtual());
                    getArrayWords().add(a8);
                    Word a9 = new Word("ddddd", getDataAtual());
                    getArrayWords().add(a9);
                    getArrayWords().add(a9);
                    getArrayWords().add(a9);
                    getArrayWords().add(a9);
                    getArrayWords().add(a9);

                    Intent it = new Intent(MainActivity.this, ListaTexto.class);
                    it.putExtra("Info", arrayWords);

                    startActivity(it);
                }
            }
        });
    }

    private void TelaListaTexto() {
        Intent intent = new Intent(this, ListaTexto.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void alert(String texto) {
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
    }

    private void addElement() {
        String auxString = getEditText().getText().toString();
        jsilv.app.exerc.Log teste = new jsilv.app.exerc.Log();

        String dataCompleta = getDataAtual(); // Coloca a data do sistema Android em dataCompleta

        Word auxWord = new Word(auxString, dataCompleta);
        getArrayWords().add(auxWord);

        Toast.makeText(getApplicationContext(), "Sucess...", Toast.LENGTH_LONG).show();
        getEditText().setText("", null);

    }

    private String getDataAtual() {
        //Inicio Data e Hora do sistema Android
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        Date data = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date dataAtual = cal.getTime();
        String dataCompleta = dateFormat.format(dataAtual);
        return dataCompleta;
    }
}
