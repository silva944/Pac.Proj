package com.example.sportfinder.model;

import android.app.Application;

import com.example.sportfinder.data.localdatabase.AppDatabase;
import com.example.sportfinder.data.localdatabase.Cliente;
import com.example.sportfinder.data.localdatabase.ClienteDAO;

public class ClienteRepository {
    private ClienteDAO clienteDAO;

    public ClienteRepository(Application application) {
        clienteDAO = AppDatabase.getInstance(application).clienteDAO();
    }

    public Cliente getClienteByUsernameAndPassword(String username, String password) {
        return clienteDAO.getClienteByUsernameAndPassword(username, password);
    }

    public void inserirCliente(Cliente cliente) {
        clienteDAO.inserirCliente(cliente);
    }
}

