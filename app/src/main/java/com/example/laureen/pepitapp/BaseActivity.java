package com.example.laureen.pepitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity /*implements BottomNavigationView.OnNavigationItemSelectedListener*/ {
    public static final String BASE_URL = "http://localhost:3000/";
    //protected BottomNavigationView navigationView;
    public  abstract int getLayoutId();
    public abstract int getNavigationMenuItemId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        //navigationView = findViewById(R.id.navigation);
        //navigationView.setOnNavigationItemSelectedListener(this);

    }

    /*@Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_quizz:
                startActivity(new Intent(this, QuizzActivity.class));
                break;
            case R.id.navigation_liste_courses:
                //startActivity(new Intent(this, PutClass.class));
                break;
            case R.id.navigation_profile:
                //startActivity(new Intent(this, profilActivity.class));
                break;

            default:
                break;
        }

        finish();
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }

    /*private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    private void selectBottomNavigationBarItem(int itemId){
        Menu menu = navigationView.getMenu();
        for(int i = 0, size = menu.size(); i < size; i++){
            MenuItem item = menu.getItem(i);
            if(item.getItemId() == itemId){
                item.setChecked(true);
                break;
            }
        }
    }*/
}
