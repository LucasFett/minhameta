package com.example.minhameta;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<Medicamento> {

    private List<Medicamento> listaMedicamento;

    public Adapter(@NonNull Context context, List<Medicamento> lista) {
        super(context,0,lista);
        listaMedicamento = lista;
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

        Medicamento medicamento = listaMedicamento.get(position);
        TextView textViewNome = view.findViewById(R.id.nome_medicamento);
        TextView textViewTipo = view.findViewById(R.id.tipo_medicamento);
        TextView textViewPreco = view.findViewById(R.id.preco_medicamento);

        textViewNome.setText(medicamento.getNome());
        textViewTipo.setText(medicamento.getTipo());
        textViewPreco.setText(medicamento.getPreco()+ "");
        return view;

    }

}