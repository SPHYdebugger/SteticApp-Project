package com.sphy.steticappproject.activity;

import static com.sphy.steticappproject.util.Constants.DATABASE_NAME;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.mapbox.mapboxsdk.Mapbox;
import com.sphy.steticappproject.R;
import com.sphy.steticappproject.db.AppDatabase;
import com.sphy.steticappproject.domain.Cliente;


public class ShowClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
    }


}