package com.sphy.steticappproject.activity;

import static com.sphy.steticappproject.util.Constants.DATABASE_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.sphy.steticappproject.adapter.ClienteAdapter;
import com.sphy.steticappproject.domain.Cliente;
import com.sphy.steticappproject.R;
import com.sphy.steticappproject.db.ClienteDao;
import com.sphy.steticappproject.db.AppDatabase;


import java.util.ArrayList;
import java.util.List;

public class ClientesListActivity extends AppCompatActivity {

    private List<Cliente> clientes;
    private ClienteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        clientes = new ArrayList<>();

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "clientes").allowMainThreadQueries().build();
        clientes.addAll(db.clienteDao().getAll());

        RecyclerView recyclerView = findViewById(R.id.client_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ClienteAdapter(clientes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        clientes.clear();
        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        clientes.addAll(db.clienteDao().getAll());

        adapter.notifyDataSetChanged();
    }

    public void addCliente(View view) {
        Intent intent = new Intent(this, RegisterClientActivity.class);
        startActivity(intent);
    }
    public void addCliente(MenuItem item) {
        Intent intent = new Intent(this, RegisterClientActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_addClient){
            Intent intent = new Intent(this, RegisterClientActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}