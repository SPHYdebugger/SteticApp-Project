package com.sphy.steticappproject.adapter;

import static com.sphy.steticappproject.util.Constants.DATABASE_NAME;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.sphy.steticappproject.R;
import com.sphy.steticappproject.db.AppDatabase;
import com.sphy.steticappproject.domain.Cliente;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.clienteHolder> {

    private List<Cliente> clientes;

    public ClienteAdapter(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public clienteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_client_item, parent, false);
        return new clienteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull clienteHolder holder, int position) {
        holder.tvName.setText(clientes.get(position).getName());
        holder.tvLastname.setText(clientes.get(position).getApellidos());
        holder.tvDNI.setText(clientes.get(position).getDNI());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public class clienteHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvLastname;
        public TextView tvDNI;
        public Button deleteButton;
        public Button detailsButton;
        public View parentView;

        public clienteHolder(@NonNull View view) {
            super(view);
            parentView = view;

            tvName = view.findViewById(R.id.client_name);
            tvLastname = view.findViewById(R.id.client_lastname);
            tvDNI = view.findViewById(R.id.client_DNI);
            deleteButton = view.findViewById(R.id.delete_button);
            detailsButton = view.findViewById(R.id.details_button);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    Cliente cliente = clientes.get(adapterPosition);
                    AppDatabase db = Room.databaseBuilder(view.getContext(), AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();

                    db.clienteDao().delete(cliente);
                    clientes.remove(cliente);
                    notifyDataSetChanged();

                }
            });
        }
    }
}
