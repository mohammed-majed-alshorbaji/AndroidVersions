package com.example.androidversions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AndroidAdapter adapter;
    private List<AndroidVersion> versionList;
    private Button btnSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSort = findViewById(R.id.btnSort);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        versionList = new ArrayList<>();

        versionList.add(new AndroidVersion(R.drawable.donut, "Donut", "1.6"));
        versionList.add(new AndroidVersion(R.drawable.eclair, "Éclair", "2.0-2.1"));
        versionList.add(new AndroidVersion(R.drawable.froyo, "Froyo", "2.2-2.2.3"));
        versionList.add(new AndroidVersion(R.drawable.gingerbread, "Gingerbread", "2.3-2.3.7"));
        versionList.add(new AndroidVersion(R.drawable.honeycomb, "Honeycomb", "3.0-3.2.6"));
        versionList.add(new AndroidVersion(R.drawable.ice_cream, "Ice Cream Sandwich", "4.0-4.0.4"));
        versionList.add(new AndroidVersion(R.drawable.jelly_bean, "Jelly Bean", "4.1-4.3.1"));
        versionList.add(new AndroidVersion(R.drawable.kitkat, "KitKat", "4.4-4.4.4"));
        versionList.add(new AndroidVersion(R.drawable.lollipop, "Lollipop", "5.0-5.1.1"));
        versionList.add(new AndroidVersion(R.drawable.marshmallow, "Marshmallow", "6.0-6.0.1"));
        versionList.add(new AndroidVersion(R.drawable.nougat, "Nougat", "7.0-7.1.2"));
        versionList.add(new AndroidVersion(R.drawable.oreo, "Oreo", "8.0-8.1"));


        adapter = new AndroidAdapter(versionList);
        recyclerView.setAdapter(adapter);


        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(versionList, new Comparator<AndroidVersion>() {
                    @Override
                    public int compare(AndroidVersion v1, AndroidVersion v2) {
                        return v1.codeName.compareToIgnoreCase(v2.codeName);
                    }
                });

                adapter.notifyDataSetChanged();
            }
        });
    }
}