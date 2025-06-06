package com.example.cyberioninnovations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ChamadoAdapter extends ArrayAdapter<Chamado> {
    public ChamadoAdapter(Context context, List<Chamado> chamados) {
        super(context, 0, chamados);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chamado chamado = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_chamado, parent, false);
        }

        TextView textTitulo = convertView.findViewById(R.id.textTitulo);
        TextView textDescricao = convertView.findViewById(R.id.textDescricao);

        textTitulo.setText(chamado.getAssunto() + " (" + chamado.getCategoria() + ")");
        textDescricao.setText(chamado.getDescricao());

        return convertView;
    }
}
