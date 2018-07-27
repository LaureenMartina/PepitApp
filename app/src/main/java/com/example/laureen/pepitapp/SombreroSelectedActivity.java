package com.example.laureen.pepitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.laureen.pepitapp.model.Sombrero;
import com.example.laureen.pepitapp.model.SombreroItem;
import com.example.laureen.pepitapp.presenter.SombreroPresenter;
import com.example.laureen.pepitapp.presenter.SombreroSelectedAdapter;
import com.example.laureen.pepitapp.view.SombreroSelectedView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chewbs on 20/07/2018.
 */

public class SombreroSelectedActivity extends AppCompatActivity implements SombreroSelectedView {

    private static final String TAG = "SombreroSelectdActivity";
    private SombreroPresenter presenter;
    private List<SombreroItem> sombreroList = new ArrayList<>();

    @BindView(R.id.gridview) RecyclerView gridView;
    @BindView(R.id.table_f1) TableLayout f_grid1;
    @BindView(R.id.table_f2) TableLayout f_grid2;
    @BindView(R.id.table_f3) TableLayout f_grid3;
    @BindView(R.id.table_f4) TableLayout f_grid4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_sombrero);

        ButterKnife.bind(this);

        int levelId = getIntent().getIntExtra(SombreroListActivity.LEVEL_ID, 1);

        presenter = new SombreroPresenter(this);
        presenter.findOneSombrero(this, 3, levelId);

    }

    @Override public void getSelectedSombrero(Sombrero sombrero) {
        sombreroList = sombrero.getCellList();
        int cell_count = sombrero.getCellCount();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), cell_count);
        gridView.setLayoutManager(layoutManager);

        gridView.setHasFixedSize(true);
        SombreroSelectedAdapter adapter = new SombreroSelectedAdapter(sombreroList);
        gridView.setAdapter(adapter);

        fillTableFunctions(sombrero);

    }

    void fillTableFunctions(Sombrero sombrero) {

        int f1 = sombrero.getF1();
        TableRow tableRow1 = new TableRow(this);
        for (int i = 0; i < f1; i++){
            tableRow1.addView(fillCommandCell(i));
        }
        f_grid1.addView(tableRow1);

        int f2 = sombrero.getF2();
        TableRow tableRow2 = new TableRow(this);
        for (int i = 0; i < f2; i++){
            tableRow2.addView(fillCommandCell(i));
        }
        f_grid2.addView(tableRow2);

        int f3 = sombrero.getF3();
        TableRow tableRow3 = new TableRow(this);
        for (int i = 0; i < f3; i++) {
            tableRow3.addView(fillCommandCell(i));
        }
        f_grid3.addView(tableRow3);

        int f4 = sombrero.getF4();
        TableRow tableRow4 = new TableRow(this);
        for (int i = 0; i < f4; i++) {
            tableRow1.addView(fillCommandCell(i));
        }
        f_grid4.addView(tableRow4);

    }

    TextView fillCommandCell(int count) {

        TextView view = new TextView(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        params.topMargin = 2;
        params.rightMargin = 2;
        view.setLayoutParams(params);
        view.setBackgroundColor(getResources().getColor(R.color.colorLightgrey));
        view.setPadding(30, 30, 30, 30);
        view.setText(String.valueOf(count + 1));

        return view;
    }

}