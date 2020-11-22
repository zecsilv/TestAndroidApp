package jsilv.app.exerc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPersonalizado extends BaseAdapter {

    private final ArrayList<Word> word;
    private final Activity act;

    public AdapterPersonalizado(ArrayList<Word> word, Activity act) {
        this.word = word;
        this.act = act;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.lista_personalizada, parent, false);

        //pegando as referências das Views
        TextView nome = (TextView) view.findViewById(R.id.tvShowResults);
        TextView descricao = (TextView) view.findViewById(R.id.tvShowDateResults);

        //populando as Views
        nome.setText(word.get(position).getTxt().toString());
        descricao.setText(word.get(position).getDate().toString());

        return view;
    }

    @Override
    public int getCount() {
        return word.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}