package com.example.laureen.pepitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.laureen.pepitapp.model.Level;
import com.example.laureen.pepitapp.presenter.SombreroListAdapter;
import com.example.laureen.pepitapp.presenter.SombreroPresenter;
import com.example.laureen.pepitapp.view.SombreroListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chewbs on 20/07/2018.
 */

public class SombreroListActivity extends AppCompatActivity implements SombreroListView, SombreroListAdapter.Listener {

    private static final String TAG = "SombreroListActivity";
    public static final String LEVEL_ID = "LEVEL_ID";

    private List<Level> sombreroList = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sombrero);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SombreroPresenter presenter = new SombreroPresenter(this);
        presenter.findAllSombrero(this, 3);

    }

    @Override public void getSombreroLevels(List<Level> levels) {
        SombreroListAdapter sombreroListAdapter = new SombreroListAdapter(levels);
        sombreroListAdapter.setListener(this);
        recyclerView.setAdapter(sombreroListAdapter);
    }

    @Override
    public void onLevelClick(Level level) {
        Intent intent = new Intent(this, SombreroSelectedActivity.class);
        intent.putExtra(LEVEL_ID, level.getId());
        startActivity(intent);
    }
}
