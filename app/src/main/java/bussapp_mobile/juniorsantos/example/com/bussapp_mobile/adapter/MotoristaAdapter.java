package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Motorista;


public class MotoristaAdapter extends RecyclerView.Adapter<MotoristaAdapter.MotoristaHolder> {

    public List<Motorista> motoristas;
    public Context context;

    public MotoristaAdapter(List<Motorista> motoristas, Context context) {
        this.motoristas = motoristas;
        this.context = context;
    }

    @NonNull
    @Override
    public MotoristaAdapter.MotoristaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.motorista_adapter, viewGroup, false);

        return new MotoristaHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MotoristaAdapter.MotoristaHolder viewHolder, int i) {
        Motorista m = motoristas.get(i);
        viewHolder.nome.setText(m.getNome());
    }

    @Override
    public int getItemCount() {
        return motoristas != null ? motoristas.size() : 0;
    }

    class MotoristaHolder extends RecyclerView.ViewHolder {
        TextView nome;

        public MotoristaHolder(@NonNull View v) {
            super(v);
            v.findViewById(R.id.nome);
        }
    }
}
