package com.example.kinoilovasi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    KinoAdapter adapter;
    List<Kino> kinoList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        kinoList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewKino);

        loadKinolar();

    }

    private void loadKinolar() {
        ApiClient.getApiService.getKinolar().enqueue(new Callback<List<Kino>>() {
            @Override
            public void onResponse(Call<List<Kino>> call, Response<List<Kino>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    kinoList = response.body();
                    for (Kino kino : kinoList) {
                        Log.d("@@@@@", kino.getName() + "|||" + kino.getSight_age() + "|||" + kino.getImg() + "|||" + kino.getDescription() + "|||" + kino.getGenre() + "|||" + kino.getVideo_fayl());
                    }
                    adapter = new KinoAdapter(kinoList,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Kino>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Xatoliq bo'ldi nichikdir", Toast.LENGTH_SHORT).show();
            }
        });
    }
}