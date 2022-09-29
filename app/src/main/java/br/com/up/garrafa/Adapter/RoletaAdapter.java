package br.com.up.garrafa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.up.garrafa.Model.RoletaModel;
import br.com.up.garrafa.R;

public class RoletaAdapter extends RecyclerView.Adapter<RoletaAdapter.MyViewHolder> {

    private List<RoletaModel> lista;
    public RoletaAdapter(List<RoletaModel> lista){
        this.lista = lista;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RoletaModel roleta = lista.get(position);
        holder.premiacao.setText(roleta.getPremiacao());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView premiacao;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            premiacao = itemView.findViewById(R.id.premiacao_roleta);
        }
    }
}
