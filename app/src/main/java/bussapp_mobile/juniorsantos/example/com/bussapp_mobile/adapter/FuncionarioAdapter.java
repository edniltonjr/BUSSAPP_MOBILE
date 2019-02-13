package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.R;
import bussapp_mobile.juniorsantos.example.com.bussapp_mobile.entities.Funcionario;

public class FuncionarioAdapter extends RecyclerView.Adapter<FuncionarioAdapter.FuncionarioHolder> {

    private List<Funcionario> funcionarios;
    private Context context;
    private FuncionarioAdapterInterface funcionarioAdapterInterface;


    public FuncionarioAdapter(List<Funcionario> funcionarios, Context context, FuncionarioAdapterInterface funcionarioAdapterInterface) {
        this.funcionarios = funcionarios;
        this.context = context;
        this.funcionarioAdapterInterface = funcionarioAdapterInterface;
    }

    @NonNull
    @Override
    public FuncionarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.funcionario_adapter, parent, false);

        return new FuncionarioHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FuncionarioHolder holder, int position) {
        Funcionario f = funcionarios.get(position);

        holder.cpfFuncionario.setText(f.getCpf());
        holder.nomeFuncionario.setText(f.getNome());
        holder.idFuncionario.setText(f.getId_funcionario() + "");
    }

    @Override
    public int getItemCount() {
        return funcionarios != null ? funcionarios.size() : 0;
    }

    public class FuncionarioHolder extends RecyclerView.ViewHolder {

        TextView idFuncionario;
        TextView nomeFuncionario;
        TextView cpfFuncionario;

        public FuncionarioHolder(@NonNull View v) {
            super(v);
            idFuncionario = v.findViewById(R.id.idFuncionario);
            nomeFuncionario = v.findViewById(R.id.nomeFuncionario);
            cpfFuncionario = v.findViewById(R.id.cpfFuncionario);
        }
    }

    public interface FuncionarioAdapterInterface {

    }
}
