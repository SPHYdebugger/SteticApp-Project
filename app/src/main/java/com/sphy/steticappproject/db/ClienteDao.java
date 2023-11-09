package com.sphy.steticappproject.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.sphy.steticappproject.domain.Cliente;

import java.util.List;

@Dao
public interface ClienteDao {
    @Query("SELECT * FROM cliente")
    List<Cliente> getAll();

    @Query("SELECT * FROM cliente WHERE name = :name")
    List<Cliente> findByName(String name);

    @Insert
    void insert(Cliente cliente);

    @Update
    void update(Cliente cliente);

    @Delete
    void delete(Cliente cliente);
}
