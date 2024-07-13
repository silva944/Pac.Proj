package com.example.sportfinder.data.localdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ClienteDAO {
    @Query("SELECT * FROM clientes WHERE username = :username AND password = :password")
    Cliente getClienteByUsernameAndPassword(String username, String password);

    @Insert
    void inserirCliente(Cliente cliente);

    @Update
    void update(Cliente cliente);

}