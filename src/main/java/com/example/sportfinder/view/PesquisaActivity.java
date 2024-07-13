package com.example.sportfinder.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportfinder.R;
import com.example.sportfinder.data.localdatabase.SpotItem;
import com.example.sportfinder.data.localdatabase.SpotService;
import com.example.sportfinder.data.localdatabase.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class PesquisaActivity extends AppCompatActivity {

    private List<SpotItem> spotList = new ArrayList<>();
    private SpotAdapter spotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        RecyclerView recyclerView = findViewById(R.id.recyclerView10);
        spotAdapter = new SpotAdapter(this, spotList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(spotAdapter);

        fetchSpotsFromAPI();

        spotAdapter.setOnSpotItemClickListener(spotItem -> {
            openSpotClassification(spotItem);
        });
    }
    private void fetchSpotsFromAPI() {
        SpotService service = RetrofitClientInstance.getRetrofitInstance().create(SpotService.class);
        Call<List<SpotItem>> call = service.getSpots();
        Call<List<SpotItem>> call2 = service.deleteSpots();
        Call<List<SpotItem>> call3 = service.addSpots();
        Call<List<SpotItem>> call4 = service.updateSpots();

        call.enqueue(new Callback<List<SpotItem>>() {
            @Override
            public void onResponse(Call<List<SpotItem>> call, Response<List<SpotItem>> response) {
                if (response.isSuccessful()) {
                    spotList = response.body();
                    Toast.makeText(PesquisaActivity.this, "Api ligada com sucesso", Toast.LENGTH_SHORT).show();
                    spotAdapter.updateList(spotList);
                } else {
                    Toast.makeText(PesquisaActivity.this, "Falha ao obter dados da API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SpotItem>> call, Throwable t) {
                Toast.makeText(PesquisaActivity.this, "Erro de conexão: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openSpotClassification(SpotItem spot) {
        String spotName = spot.getSpotName();
        Intent intent;
        switch (spotName) {

            case "Beja Basket Clube":
                intent = new Intent(PesquisaActivity.this, bbc.class);
                break;
            case "KettClub":
                intent = new Intent(PesquisaActivity.this, Kett.class);
                break;
            case "Blive":
                intent = new Intent(PesquisaActivity.this, Blive.class);
                break;
            case "Zona Azul":
                intent = new Intent(PesquisaActivity.this, ZonaAzul.class);
                break;
            case "Fit4You Beja":
                intent = new Intent(PesquisaActivity.this, Fit4You.class);
                break;

            default:
                return;
        }
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(PesquisaActivity.this, MainActivity.class));
        startActivity(intent);
    }

    public void Tutorial(View view) {
        Intent intent = (new Intent(PesquisaActivity.this, tutorialActivity.class));
        startActivity(intent);
    }
}