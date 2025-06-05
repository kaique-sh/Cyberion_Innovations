package com.example.cyberioninnovations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChamadoAdapter extends RecyclerView.Adapter<ChamadoAdapter.ViewHolder> {

    private final List<Chamado> chamados;

    public ChamadoAdapter(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAssunto, txtCategoria, txtDescricao;

        public ViewHolder(View itemView) {
            super(itemView);
            txtAssunto = itemView.findViewById(R.id.txtAssunto);
            txtCategoria = itemView.findViewById(R.id.txtCategoria);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chamado, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chamado chamado = chamados.get(position);
        holder.txtAssunto.setText(chamado.getAssunto());
        holder.txtCategoria.setText(chamado.getCategoria());
        holder.txtDescricao.setText(chamado.getDescricao());
    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }
}
