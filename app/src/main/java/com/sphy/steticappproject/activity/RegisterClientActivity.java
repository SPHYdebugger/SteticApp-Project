package com.sphy.steticappproject.activity;

import static com.sphy.steticappproject.util.Constants.DATABASE_NAME;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.sphy.steticappproject.R;
import com.sphy.steticappproject.db.AppDatabase;
import com.sphy.steticappproject.domain.Cliente;

public class RegisterClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);
    }

    public void createCliente(View view) {
        EditText etName = findViewById(R.id.client_name);
        EditText etDescription = findViewById(R.id.client_lastname);
        EditText etDNI = findViewById(R.id.client_DNI);

        String clientName = etName.getText().toString();
        String clientLastname = etDescription.getText().toString();
        String clientDNI = etDescription.getText().toString();

        Cliente cliente = new Cliente(clientName, clientLastname, clientDNI);
        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        db.clienteDao().insert(cliente);

        Toast.makeText(this, "cliente_insertado", Toast.LENGTH_LONG).show();

        etName.setText("");
        etDescription.setText("");
        etDNI.setText("");
        etName.requestFocus();
    }
}