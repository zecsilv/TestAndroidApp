package jsilv.app.exerc;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaTexto extends AppCompatActivity {

    private TextView tvShowResults;
    private TextView tvShowDateResults;
    private ListView lvRes;
    private Button btnHelp;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_texto);

        ArrayList<Word> c = (ArrayList<Word>) getIntent().getSerializableExtra("Info");


        AdapterPersonalizado adapter = new AdapterPersonalizado(c, this);

        getLvRes().setAdapter(adapter);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");

        Intent resultIntent = new Intent(this, ListaTexto.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ListaTexto.class);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());


/*
        ArrayAdapter<Word> adapter = new ArrayAdapter<Word>(this, android.R.layout.simple_list_item_1,c);

        getLvRes().setAdapter(adapter);
*/
        /*

        for (int i = 0; i < c.size(); i++) {
            getTvShowResults().append("\n" + c.get(i).getTxt().toString());
            getTvShowDateResults().append("\n" + c.get(i).getDate());
        }
        */

    }

    private ListView getLvRes() {
        if (lvRes == null) {
            lvRes = (ListView) findViewById(R.id.lvRes);
        }
        return lvRes;
    }

    private Button getBtnHelp() {
        if (btnHelp == null) {
            btnHelp = (Button) findViewById(R.id.btnHelp);
        }
        return btnHelp;
    }

    /*
- criado para utilizar o ScrollView - a atual implementação está com listView
    private TextView getTvShowResults() {
        if (tvShowResults == null) {
            tvShowResults = (TextView) findViewById(R.id.tvShowResults);
        }
        return tvShowResults;
    }

- criado para utilizar o ScrollView - a atual implementação está com listView

    public TextView getTvShowDateResults() {
        if (tvShowDateResults == null) {
            tvShowDateResults = (TextView) findViewById(R.id.tvShowDateResults);
        }
        return tvShowDateResults;
    }
*/
}
