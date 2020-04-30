package com.example.mapsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mapsapi.adapter.CustomHomeAdapter;
import com.example.mapsapi.model.dataHome;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<dataHome> data;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.rv_judul);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        data.add(new dataHome("hospital", "Rumah Sakit"));
        data.add(new dataHome("mosque", "Masjid"));
        data.add(new dataHome("bank", "Bank"));
        data.add(new dataHome("atm", "ATM"));
        data.add(new dataHome("school", "Sekolah"));
        data.add(new dataHome("university", "Universitas"));
        data.add(new dataHome("stadium", "Stadion"));
        data.add(new dataHome("police", "Kantor Polisi"));

        adapter = new CustomHomeAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }
}
