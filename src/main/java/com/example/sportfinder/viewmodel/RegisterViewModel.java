package com.example.sportfinder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sportfinder.data.localdatabase.AppDatabase;
import com.example.sportfinder.data.localdatabase.Cliente;
import com.example.sportfinder.data.localdatabase.ClienteDAO;
import com.example.sportfinder.model.ClienteRepository;

public class RegisterViewModel extends AndroidViewModel {
    private MutableLiveData<Cliente> clienteLiveData = new MutableLiveData<>();
    private ClienteRepository clienteRepository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        clienteRepository = new ClienteRepository(application);
    }

    public void registerCliente(String nome, String username, String password) {
        Cliente cliente = new Cliente(nome, username, password);
        clienteRepository.inserirCliente(cliente);
        clienteLiveData.setValue(cliente);
    }

    public LiveData<Cliente> getClienteLiveData() {
        return clienteLiveData;
    }
}
