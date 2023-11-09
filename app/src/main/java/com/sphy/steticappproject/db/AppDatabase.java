package com.sphy.steticappproject.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sphy.steticappproject.domain.Cliente;


@Database(entities = {Cliente.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ClienteDao clienteDao();
}
