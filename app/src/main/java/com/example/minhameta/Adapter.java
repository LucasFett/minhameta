package com.example.minhameta;
//
import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.List;

public class Adapter extends ArrayAdapter<Meta> {

    private List<Meta> listaMeta;

    public Adapter(@NonNull Context context, List<Meta> lista){
        super(context,0,lista);
        listaMeta = lista;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            Context ctx = getContext();
            LayoutInflater li = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.item_meta,null);
        }
        Meta meta = listaMeta.get(position);
        TextView textViewNome = view.findViewById(R.id.ItemNome);
        TextView textViewData = view.findViewById(R.id.ItemData);
        TextView textViewDescricao = view.findViewById(R.id.ItemDescricao);
        TextView textViewValor = view.findViewById(R.id.ItemValor);
        textViewNome.setText(meta.getNome());
        textViewData.setText(meta.getData());
        textViewDescricao.setText(meta.getDescricao());
        textViewValor.setText(meta.getValor()+ "");
        return view;
    }
}