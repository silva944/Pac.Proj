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

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>();
    private ClienteRepository clienteRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        clienteRepository = new ClienteRepository(application);
    }

    public void login(String username, String password) {
        Cliente cliente = clienteRepository.getClienteByUsernameAndPassword(username, password);
        boolean isLoginSuccess = (cliente != null);
        loginSuccess.setValue(isLoginSuccess);
    }

    public LiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }

}
